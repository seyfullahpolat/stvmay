package com.example.stvmay.base.interactor

import com.example.stvmay.api.DataState
import kotlinx.coroutines.flow.Flow

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

abstract class BaseRequestUseCase<Params, Request, Response> {
    abstract suspend fun execute(params: Params): Flow<DataState<out Response>>
    abstract fun onCreateRequest(params: Params): Request
}
