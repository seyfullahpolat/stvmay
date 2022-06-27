package com.example.stvmay.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

@Database(
    entities = [RepoFavoriteItem::class],
    version = 1,
    exportSchema = true
)

@TypeConverters(Converters::class)
abstract class RepoRoomDatabase : RoomDatabase() {
    abstract fun repoFavoriteDao(): RepoFavoriteDao
}
