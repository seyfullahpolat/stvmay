package com.example.stvmay.feature.repo

import com.example.stvmay.api.ApiServices
import com.example.stvmay.db.RepoRoomDatabase
import com.example.stvmay.feature.repo.data.repository.RepoListRepository
import com.example.stvmay.feature.repo.data.repository.RepoListRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */
@Module
@InstallIn(SingletonComponent::class)
object RepoListModule {

    @Provides
    @Singleton
    fun provideRepoListRepository(
        api: ApiServices,
        db: RepoRoomDatabase
    ): RepoListRepository {
        return RepoListRepositoryImpl(api, db)
    }
}
