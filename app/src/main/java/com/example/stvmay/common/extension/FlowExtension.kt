package com.example.stvmay.common.extension

import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.Flow

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

suspend inline fun <T> Flow<T>.safeCollect(crossinline action: suspend (T) -> Unit) {
    collect {
        currentCoroutineContext().ensureActive()
        action(it)
    }
}
