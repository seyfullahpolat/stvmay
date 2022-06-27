package com.example.stvmay.feature.repo.presentation.repolist

import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.example.stvmay.base.view.BaseFragment
import com.example.stvmay.databinding.RepoListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

@AndroidEntryPoint
class RepoListFragment : BaseFragment<RepoListViewModel, RepoListFragmentBinding>() {
    private val repoListAdapter: ProductListAdapter by lazy {
        ProductListAdapter()
    }

    override fun bindScreen() {
        binding.apply {
            repoList.adapter = repoListAdapter
            searchEditText.doOnTextChanged { text, _, _, _ ->
                searchButton.isEnabled = !text.isNullOrEmpty()
            }
            searchButton.setOnClickListener {
                viewModel.getRepoListByUserName(searchEditText.text.toString())
                repoListAdapter.submitList(null)
            }
        }

        repoListAdapter.apply {
            showRepoDetail = { item ->
                val action = RepoListFragmentDirections.repoListFragmentToRepoDetailFragment(
                    item.name,
                    item
                )
                findNavController().navigate(action)
            }
            clickFavoriteBtn = { repoResponseItem ->
                viewModel.updateFavoriteState(repoResponseItem)
            }
        }
    }

    override fun clickListeners() {}

    override fun observeViewModel() {
        viewModel.repoLiveData.observe(this) {
            binding.emptyListMessage.isVisible = it.isEmpty()
            repoListAdapter.submitList(it.map { it.copy() })
        }
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        RepoListFragmentBinding.inflate(layoutInflater)

    override fun getViewModelClass(): Class<RepoListViewModel> = RepoListViewModel::class.java
}
