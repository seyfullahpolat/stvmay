package com.example.stvmay.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

@Dao
interface RepoFavoriteDao {
    @Query("Select * from RepoFavoriteItem where is_favorite = 1")
    fun getFavorite(): Flow<List<RepoFavoriteItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFavoriteStatus(repoFavoriteItem: RepoFavoriteItem)

    @Delete
    suspend fun delete(repoFavoriteItem: RepoFavoriteItem)
}
