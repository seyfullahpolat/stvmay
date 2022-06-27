package com.example.stvmay.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asLiveData
import androidx.test.filters.SmallTest
import com.example.stvmay.common.extension.getOrAwaitValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Seyfullah POLAT on 27.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

@HiltAndroidTest
@SmallTest
class RepoRangeDaoTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    @Named("repoList")
    lateinit var database: RepoRoomDatabase
    private lateinit var repoFavoriteDao: RepoFavoriteDao

    @Before
    fun setup() {
        hiltRule.inject()
        repoFavoriteDao = database.repoFavoriteDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun updateFavoriteStatus() = runBlocking {
        val repoFavoriteItem = RepoFavoriteItem(
            id = 123321435345345543,
            repoName = "repoName",
            isFavorite = true
        )
        repoFavoriteDao.updateFavoriteStatus(repoFavoriteItem)
        val allFavoriteItem = repoFavoriteDao.getFavorite().asLiveData().getOrAwaitValue()
        assertTrue(allFavoriteItem.contains(repoFavoriteItem))
    }
}
