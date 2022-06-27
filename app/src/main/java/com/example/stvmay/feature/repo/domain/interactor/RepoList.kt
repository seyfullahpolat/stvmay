package com.example.stvmay.feature.repo.domain.interactor

import com.example.stvmay.api.DataState
import com.example.stvmay.base.interactor.BaseRequestUseCase
import com.example.stvmay.feature.repo.data.repository.RepoListRepository
import com.example.stvmay.feature.repo.data.request.RepoListRequest
import com.example.stvmay.feature.repo.data.response.RepoResponseItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

class RepoList @Inject constructor(
    val repository: RepoListRepository
) : BaseRequestUseCase<String, RepoListRequest, List<RepoResponseItem>>() {

    override suspend fun execute(params: String): Flow<DataState<List<RepoResponseItem>>> {
        return repository.getRepoByUser(onCreateRequest(params))
    }

    override fun onCreateRequest(params: String) = RepoListRequest(userName = params)
}
