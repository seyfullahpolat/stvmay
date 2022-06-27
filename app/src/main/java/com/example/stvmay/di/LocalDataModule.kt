package com.example.stvmay.di

import android.content.Context
import androidx.room.Room
import com.example.stvmay.db.RepoRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext app: Context,
    ): RepoRoomDatabase {
        return synchronized(this) {
            Room.databaseBuilder(app, RepoRoomDatabase::class.java, "repoLocalDb")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
