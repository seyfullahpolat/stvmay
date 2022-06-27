package com.example.stvmay.feature.repo.domain.entity

import com.example.stvmay.base.data.model.BaseViewEntity
import kotlinx.parcelize.Parcelize

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

@Parcelize
data class RepoItemViewEntity(
    val id: Long,
    val name: String?,
    val avatarUrl: String?,
    val stargazersCount: Int,
    val openIssuesCount: Int,
    val login: String?,
    var isFavorite: Boolean
) : BaseViewEntity()
