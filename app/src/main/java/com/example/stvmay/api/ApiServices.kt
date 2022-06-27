package com.example.stvmay.api

import com.example.stvmay.feature.repo.data.response.RepoResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

interface ApiServices {
    @GET("users/{user}/repos")
    suspend fun getRepoByUser(
        @Path("user") user: String
    ): Response<List<RepoResponseItem>>
}
