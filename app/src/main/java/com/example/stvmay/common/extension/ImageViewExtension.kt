package com.example.stvmay.common.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by seyfullahpolat on 3.04.2022.
 */
fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
        .load(url)
        .fitCenter()
        .into(this)
}
