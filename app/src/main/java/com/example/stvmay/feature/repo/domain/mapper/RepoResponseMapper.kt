package com.example.stvmay.feature.repo.domain.mapper

import com.example.stvmay.feature.repo.data.response.RepoResponseItem
import com.example.stvmay.feature.repo.domain.entity.RepoItemViewEntity

/**
 * Created by Seyfullah POLAT on 23.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

fun RepoResponseItem.toViewEntity() = RepoItemViewEntity(
    id = this.id,
    name = this.name,
    isFavorite = this.isFavorite,
    login = this.owner.login,
    stargazersCount = this.stargazers_count ?: 0,
    openIssuesCount = this.open_issues_count ?: 0,
    avatarUrl = this.owner.avatar_url
)
