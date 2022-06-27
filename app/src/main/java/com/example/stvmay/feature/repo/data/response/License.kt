package com.example.stvmay.feature.repo.data.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class License(
    val key: String?, // mit
    val name: String?, // MIT License
    val node_id: String?, // MDc6TGljZW5zZTEz
    val spdx_id: String?, // MIT
    val url: String? // https://api.github.com/licenses/mit
) : Parcelable
