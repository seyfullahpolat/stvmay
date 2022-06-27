package com.example.stvmay.feature.repo.data.repository

import com.example.stvmay.api.ApiServices
import com.example.stvmay.api.DataState
import com.example.stvmay.api.Loading
import com.example.stvmay.db.RepoFavoriteItem
import com.example.stvmay.db.RepoRoomDatabase
import com.example.stvmay.feature.repo.data.request.RepoListRequest
import com.example.stvmay.feature.repo.data.response.RepoResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

@Singleton
class RepoListRepositoryImpl @Inject constructor(
    private val remoteDataSource: ApiServices,
    val db: RepoRoomDatabase
) : RepoListRepository() {
    override suspend fun getRepoByUser(request: RepoListRequest): Flow<DataState<List<RepoResponseItem>>> {
        return flow {
            emit(Loading())
            emit(
                safeApiCall {
                    remoteDataSource.getRepoByUser(
                        request.userName
                    )
                }
            )
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getFavorite(): Flow<List<RepoFavoriteItem>> {
        return db.repoFavoriteDao().getFavorite()
    }

    override suspend fun updateFavoriteState(item: RepoFavoriteItem) {
        if (item.isFavorite)
            db.repoFavoriteDao().updateFavoriteStatus(item)
        else
            db.repoFavoriteDao().delete(item)
    }
}
