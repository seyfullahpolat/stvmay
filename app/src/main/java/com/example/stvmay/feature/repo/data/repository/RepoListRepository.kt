package com.example.stvmay.feature.repo.data.repository

import com.example.stvmay.api.DataState
import com.example.stvmay.base.data.repository.BaseRepository
import com.example.stvmay.db.RepoFavoriteItem
import com.example.stvmay.feature.repo.data.request.RepoListRequest
import com.example.stvmay.feature.repo.data.response.RepoResponseItem
import kotlinx.coroutines.flow.Flow

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

abstract class RepoListRepository : BaseRepository {
    // Remote data
    abstract suspend fun getRepoByUser(request: RepoListRequest): Flow<DataState<List<RepoResponseItem>>>

    // Local data
    abstract suspend fun getFavorite(): Flow<List<RepoFavoriteItem>>
    abstract suspend fun updateFavoriteState(item: RepoFavoriteItem)
}
