package com.example.stvmay.component.loading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.stvmay.databinding.LoadingViewBinding

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

class LoadingView : DialogFragment() {
    companion object {
        fun newInstance(): LoadingView {
            return LoadingView()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return LoadingViewBinding.inflate(layoutInflater).root
    }
}
