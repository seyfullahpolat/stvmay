package com.example.stvmay.common.extension

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Created by Seyfullah POLAT on 27.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

fun Date.toReadableDate(): String {
    val format = SimpleDateFormat("dd.MM.yyy HH:mm:ss", Locale.getDefault())
    return format.format(this)
}
