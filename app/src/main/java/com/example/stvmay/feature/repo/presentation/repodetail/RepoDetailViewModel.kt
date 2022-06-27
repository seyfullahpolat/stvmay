package com.example.stvmay.feature.repo.presentation.repodetail

import androidx.lifecycle.viewModelScope
import com.example.stvmay.base.view.BaseViewModel
import com.example.stvmay.db.RepoFavoriteItem
import com.example.stvmay.feature.repo.domain.entity.RepoItemViewEntity
import com.example.stvmay.feature.repo.domain.interactor.RepoList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

@HiltViewModel
class RepoDetailViewModel @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val repoList: RepoList
) : BaseViewModel() {
    private lateinit var repoItem: RepoItemViewEntity

    fun updateFavoriteState() {
        repoItem.isFavorite = !repoItem.isFavorite
        viewModelScope.launch(dispatcher) {
            repoList.repository.updateFavoriteState(
                RepoFavoriteItem(
                    repoItem.id,
                    repoItem.name,
                    repoItem.isFavorite
                )
            )
            _liveData.postValue(repoItem)
        }
    }

    fun initRepoResponse(repoItem: RepoItemViewEntity) {
        this.repoItem = repoItem.copy()
        _liveData.postValue(repoItem)
    }
}
