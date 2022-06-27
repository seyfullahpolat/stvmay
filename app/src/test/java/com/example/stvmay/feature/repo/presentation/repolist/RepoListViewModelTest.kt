package com.example.stvmay.feature.repo.presentation.repolist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.stvmay.MainCoroutineRule
import com.example.stvmay.api.DataState
import com.example.stvmay.api.Error
import com.example.stvmay.api.Success
import com.example.stvmay.common.extension.getOrAwaitValue
import com.example.stvmay.feature.repo.data.response.Owner
import com.example.stvmay.feature.repo.data.response.RepoResponseItem
import com.example.stvmay.feature.repo.domain.interactor.RepoList
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import retrofit2.HttpException
import retrofit2.Response

/**
 * Created by Seyfullah POLAT on 27.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

@HiltAndroidTest
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class RepoListViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: RepoListViewModel

    @Mock
    private lateinit var repoList: RepoList

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        viewModel = RepoListViewModel(
            mainCoroutineRule.dispatcher,
            repoList
        )
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testGetRepoList() = runTest {
        // Given
        val channel = Channel<DataState<List<RepoResponseItem>>>()
        val flow = channel.consumeAsFlow()
        val item = RepoResponseItem(
            id = 123321,
            owner = Owner(
                login = "",
                avatar_url = ""
            ),
            name = "",
        )
        val data: List<RepoResponseItem> = listOf(item)

        Mockito.`when`(repoList.execute(any())).thenReturn(flow)
        launch(this.coroutineContext) {
            channel.send(Success(data))
        }

        // when
        viewModel.getRepoListByUserName("kobe")
        delay(10)
        val result = viewModel.repoLiveData.getOrAwaitValue()

        // Then
        Assert.assertTrue(result.isNotEmpty())
        Assert.assertTrue(result[0].id == data[0].id)
    }

    @Test
    fun testGetRepoListWithHttpError404() = runTest {
        // Given
        val errorResponse =
            "{\n" +
                "  \"type\": \"error\",\n" +
                "  \"message\": \"What you were looking for isn't here.\"\n" +
                "}"
        val errorResponseBody = errorResponse.toResponseBody("application/json".toMediaTypeOrNull())
        val mockResponse = Response.error<String>(404, errorResponseBody)

        val error = HttpException(mockResponse)

        val channel = Channel<DataState<List<RepoResponseItem>>>()
        val flow = channel.consumeAsFlow()

        Mockito.`when`(repoList.execute(any())).thenReturn(flow)
        launch(this.coroutineContext) {
            channel.send(Error(error))
        }
        // when
        viewModel.getRepoListByUserName("kobe")
        delay(10)
        val result = viewModel.loading.getOrAwaitValue() as Error
        // Then
        Assert.assertTrue(result.error is HttpException)
        Assert.assertTrue((result.error as HttpException).code() == 404)
    }
}
