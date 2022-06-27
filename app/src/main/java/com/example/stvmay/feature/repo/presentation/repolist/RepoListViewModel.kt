package com.example.stvmay.feature.repo.presentation.repolist

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.stvmay.api.Success
import com.example.stvmay.base.view.BaseViewModel
import com.example.stvmay.common.extension.safeCollect
import com.example.stvmay.db.RepoFavoriteItem
import com.example.stvmay.feature.repo.domain.entity.RepoItemViewEntity
import com.example.stvmay.feature.repo.domain.interactor.RepoList
import com.example.stvmay.feature.repo.domain.mapper.toViewEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

@HiltViewModel
class RepoListViewModel @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val repoList: RepoList
) : BaseViewModel() {

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    var responseList: MutableList<RepoItemViewEntity> = mutableListOf()

    val repoLiveData: LiveData<MutableList<RepoItemViewEntity>>
        get() = _repoLiveData
    private val _repoLiveData: MutableLiveData<MutableList<RepoItemViewEntity>> = MutableLiveData()

    fun getRepoListByUserName(userName: String) {
        viewModelScope.launch(dispatcher) {
            repoList.execute(userName).safeCollect { dataState ->
                loading.value = dataState
                if (dataState is Success) dataState.data?.apply {
                    responseList.clear()
                    responseList.addAll(this.map { it.toViewEntity() })
                    mergeFavorite()
                    _repoLiveData.value = responseList
                }
            }
        }
    }

    private fun mergeFavorite() {
        viewModelScope.launch(dispatcher) {
            repoList.repository.getFavorite().safeCollect { favItem ->
                responseList.forEach { item ->
                    favItem.find { it.id == item.id }.let {
                        item.isFavorite = it?.isFavorite ?: false
                    }
                }
                _repoLiveData.value = responseList
            }
        }
    }

    fun updateFavoriteState(item: RepoItemViewEntity) {
        val updatedItem = item.copy()
        viewModelScope.launch(dispatcher) {
            repoList.repository.updateFavoriteState(
                RepoFavoriteItem(
                    updatedItem.id,
                    updatedItem.name,
                    !updatedItem.isFavorite
                )
            )
        }
    }
}
