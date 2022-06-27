package com.example.stvmay.feature.repo.presentation.repolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.stvmay.R
import com.example.stvmay.databinding.RepoListItemBinding
import com.example.stvmay.feature.repo.domain.entity.RepoItemViewEntity

/**
 * Created by seyfullahpolat on 2.04.2022.
 */

class ProductListAdapter : ListAdapter<RepoItemViewEntity, ProductListAdapter.ViewHolder>(notify) {
    companion object {
        val notify = object : DiffUtil.ItemCallback<RepoItemViewEntity>() {
            override fun areItemsTheSame(
                oldItem: RepoItemViewEntity,
                newItem: RepoItemViewEntity
            ) = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: RepoItemViewEntity,
                newItem: RepoItemViewEntity
            ) = oldItem.isFavorite == newItem.isFavorite
        }
    }

    var showRepoDetail: (productItem: RepoItemViewEntity) -> Unit = {}
    var clickFavoriteBtn: (productItem: RepoItemViewEntity) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RepoListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(private val binding: RepoListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RepoItemViewEntity) {
            binding.apply {
                repoName.text = item.name
                favoriteState.setOnClickListener { clickFavoriteBtn.invoke(item) }

                favoriteState.setImageDrawable(
                    if (item.isFavorite) {
                        ContextCompat.getDrawable(binding.root.context, R.drawable.ic_favorite)
                    } else {
                        ContextCompat.getDrawable(binding.root.context, R.drawable.ic_unfavorite)
                    }
                )
            }
            binding.root.setBackgroundColor(
                if (adapterPosition % 2 == 0) {
                    ContextCompat.getColor(binding.root.context, R.color.double_item)
                } else {
                    ContextCompat.getColor(binding.root.context, R.color.odd_item)
                }
            )

            itemView.setOnClickListener {
                showRepoDetail(item)
            }
        }
    }
}
