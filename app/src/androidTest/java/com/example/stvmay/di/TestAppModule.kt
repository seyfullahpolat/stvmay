package com.example.stvmay.di

import android.content.Context
import androidx.room.Room
import com.example.stvmay.db.RepoRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

/**
 * Created by Seyfullah POLAT on 27.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Named("repoList")
    fun provideInMemoryDb(@ApplicationContext context: Context) =
        Room.inMemoryDatabaseBuilder(
            context, RepoRoomDatabase::class.java
        ).allowMainThreadQueries()
            .build()
}
