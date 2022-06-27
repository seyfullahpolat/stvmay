package com.example.stvmay.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Calendar
import java.util.Date

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

@Entity(tableName = "RepoFavoriteItem")
data class RepoFavoriteItem(

    @PrimaryKey
    @ColumnInfo(name = "repo_id")
    val id: Long,

    @ColumnInfo(name = "repo_name")
    var repoName: String,

    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean,

    var createdAt: Date? = Calendar.getInstance().time,

    var updatedAt: Date? = Calendar.getInstance().time
)
