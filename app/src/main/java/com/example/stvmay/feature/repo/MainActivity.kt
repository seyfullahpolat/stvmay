package com.example.stvmay.feature.repo

import android.view.LayoutInflater
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.stvmay.R
import com.example.stvmay.base.view.BaseActivity
import com.example.stvmay.databinding.ActivityMainBinding
import com.example.stvmay.feature.repo.domain.entity.RepoItemViewEntity
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Seyfullah POLAT on 26.06.2022.
 * Copyright (c) 2022 Seyfullah POLAT. All rights reserved.
 */

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    override fun bindScreen() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(R.id.repoListFragment),
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )

        binding.toolbar.setupWithNavController(
            navController,
            appBarConfiguration
        )

        navController.addOnDestinationChangedListener { _, destination, args ->
            when (destination.id) {
                R.id.repoListFragment -> {
                    binding.toolbar.menu.clear()
                    binding.toolbar.setBackgroundResource(R.color.purple_500)
                }
                R.id.repoDetailFragment -> {
                    args?.get("repo_item")?.let {
                        if (it is RepoItemViewEntity) {
                            binding.toolbar.setBackgroundResource(R.color.teal_200)
                            binding.toolbar.inflateMenu(R.menu.menu)
                        }
                    }
                }
            }
        }
    }

    override fun clickListeners() {}

    override fun observeViewModel() {}

    override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java
    override fun inflateLayout(layoutInflater: LayoutInflater) =
        ActivityMainBinding.inflate(layoutInflater)
}
