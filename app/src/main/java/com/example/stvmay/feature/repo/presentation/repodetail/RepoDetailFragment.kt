package com.example.stvmay.feature.repo.presentation.repodetail

import android.view.LayoutInflater
import android.view.Menu
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import com.example.stvmay.R
import com.example.stvmay.base.view.BaseFragment
import com.example.stvmay.common.extension.loadImage
import com.example.stvmay.databinding.RepoDetailFragmentBinding
import com.example.stvmay.feature.repo.MainActivity
import com.example.stvmay.feature.repo.domain.entity.RepoItemViewEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class RepoDetailFragment : BaseFragment<RepoDetailViewModel, RepoDetailFragmentBinding>() {
    companion object {
        const val STARS_LABEL_TEXT = R.string.stars
        const val OPEN_ISSUE_LABEL_TEXT = R.string.open_issues
        /** const val REPO_COUNT_LABEL_TEXT = R.string.repo_count
         *  const val FOLLOWING_LABEL_TEXT = R.string.following
         *  const val FOLLOWERS_LABEL_TEXT = R.string.followers
         */
    }

    private val args: RepoDetailFragmentArgs by navArgs()

    override fun bindScreen() {
        if (activity is MainActivity) {
            (activity as MainActivity).binding.toolbar.setOnMenuItemClickListener { menuItem ->
                if (menuItem.itemId == R.id.isFavorite) {
                    viewModel.updateFavoriteState()
                }
                false
            }
        }
        setData(args.repoItem.copy())
        viewModel.initRepoResponse(args.repoItem.copy())
    }

    override fun clickListeners() {}

    override fun observeViewModel() {
        viewModel.liveData.observe(this) { viewEntity ->
            when (viewEntity) {
                is RepoItemViewEntity -> {
                    notifyFavoriteState(viewEntity)
                }
            }
        }
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        RepoDetailFragmentBinding.inflate(layoutInflater)

    override fun getViewModelClass() = RepoDetailViewModel::class.java

    private fun setData(repoItem: RepoItemViewEntity) {
        with(binding) {
            repoItem.avatarUrl.let { userAvatar.loadImage(it) }
            userName.text = repoItem.login
            stars.setFieldData(
                getString(STARS_LABEL_TEXT),
                repoItem.stargazersCount.toString()
            )
            openIssues.setFieldData(
                getString(OPEN_ISSUE_LABEL_TEXT),
                repoItem.openIssuesCount.toString()
            )
        }
    }

    private fun notifyFavoriteState(repoItem: RepoItemViewEntity) {
        if (activity is MainActivity) {
            val menu: Menu = (activity as MainActivity).binding.toolbar.menu
            if (menu.size() > 0) {
                menu.getItem(0).icon = if (repoItem.isFavorite) {
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_favorite)
                } else {
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_unfavorite)
                }
            }
        }
    }
}
