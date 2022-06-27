package com.example.stvmay.feature.bottomsheetinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.example.stvmay.base.view.BaseBottomSheet
import com.example.stvmay.databinding.InfoBottomSheetFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

@AndroidEntryPoint
class InfoBottomSheetFragment :
    BaseBottomSheet<InfoBottomSheetViewModel, InfoBottomSheetFragmentBinding>() {
    private val args: InfoBottomSheetFragmentArgs by navArgs()
    private lateinit var rateBottomSheetData: InfoBottomSheetData

    private lateinit var mBottomSheetBehavior: BottomSheetBehavior<View>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        rateBottomSheetData = args.infoBottomSheetData
        mBottomSheetBehavior = BottomSheetBehavior.from(binding.rootContainer)
        mBottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        return binding.root
    }

    override fun bindScreen() {
        binding.apply {
            message.text = rateBottomSheetData.title.also {
                message.isVisible = true
            }
            firstBtn.text = rateBottomSheetData.firstBtn?.also {
                firstBtn.isVisible = true
            }
            secondBtn.text = rateBottomSheetData.secondBtn?.also {
                secondBtn.isVisible = true
            }

            firstBtn.setOnClickListener {
                rateBottomSheetData.firstBtnAction.invoke()
                dialog?.onBackPressed()
            }
            secondBtn.setOnClickListener {
                rateBottomSheetData.secondBtnAction.invoke()
                dialog?.onBackPressed()
            }
        }
    }

    override fun observeViewModel() {}

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        InfoBottomSheetFragmentBinding.inflate(
            LayoutInflater.from(
                requireContext()
            )
        )

    override fun getViewModelClass() = InfoBottomSheetViewModel::class.java

    override fun setRootContainer() = binding.rootContainer
}
