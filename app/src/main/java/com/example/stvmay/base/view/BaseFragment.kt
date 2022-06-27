package com.example.stvmay.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.stvmay.R
import com.example.stvmay.api.Error
import com.example.stvmay.api.Loading
import com.example.stvmay.component.loading.LoadingView
import com.example.stvmay.feature.bottomsheetinfo.InfoBottomSheetData
import com.example.stvmay.feature.bottomsheetinfo.InfoBottomSheetFragmentDirections
import java.net.UnknownHostException

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding> : Fragment() {
    private var progress: LoadingView? = null
    abstract fun bindScreen()
    abstract fun clickListeners()
    abstract fun observeViewModel()
    abstract fun inflateLayout(layoutInflater: LayoutInflater): VB
    protected abstract fun getViewModelClass(): Class<VM>
    lateinit var binding: VB
    internal val viewModel: VM by lazy { ViewModelProvider(this)[getViewModelClass()] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateLayout(layoutInflater)
        bindScreen()
        clickListeners()
        observeViewModel()
        observer()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    private fun observer() {
        viewModel.run {
            loading.observe(this@BaseFragment) {
                when (it) {
                    is Loading -> {
                        showLoading()
                    }
                    is Error -> {
                        hideLoading()
                        var message =
                            it.error.message ?: getString(R.string.general_connection_exception)
                        if (it.error is UnknownHostException) {
                            message = getString(R.string.internet_connection)
                        }
                        InfoBottomSheetData(
                            message,
                            firstBtn = getString(R.string.action_ok),
                            firstBtnAction = {}
                        ).apply {
                            showInfoDialog(this)
                        }
                    }
                    else -> {
                        hideLoading()
                    }
                }
            }
        }
    }

    private fun showInfoDialog(rateBottomSheetData: InfoBottomSheetData) {
        val action = InfoBottomSheetFragmentDirections.showInfoBottomSheet(rateBottomSheetData)
        findNavController().navigate(action)
    }

    private fun showLoading() {
        progress = LoadingView.newInstance()
        progress?.isCancelable = false
        progress?.show(childFragmentManager, LoadingView::class.java.simpleName)
    }

    private fun hideLoading() {
        lifecycleScope.launchWhenResumed {
            progress?.dismiss()
            progress = null
        }
    }
}
