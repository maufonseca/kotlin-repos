package com.example.github.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.github.R
import com.example.github.domain.Repository
import kotlinx.android.synthetic.main.cell_repository.view.*

class ListAdapter(private val repositories: List<Repository>,
                  private val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val LOADING_CELL = 0
        const val ITEM_CELL = 1
    }

    private var scrollLoading = true

    override fun getItemViewType(position: Int): Int {
        return if (scrollLoading && position == repositories.size) LOADING_CELL else ITEM_CELL
    }

    override fun getItemCount(): Int = if (scrollLoading) repositories.size + 1 else repositories.size

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return if( p1 == ITEM_CELL ) {
            CellViewHolder(LayoutInflater.from(context).inflate(R.layout.cell_repository, p0, false))
        } else {
            LoadingViewHolder(LayoutInflater.from(context).inflate(R.layout.cell_loading_repository, p0, false))
        }
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        (p0 as? CellViewHolder)?.let {
            p0.rank.text = context.getString(R.string.rank, p1+1)
            repositories[p1].let {
                p0.repoName.text = it.name
                p0.itemView.tag = it.htmlUrl
                p0.starsCount.text = context.getString(R.string.stars, it.stargazersCount)
                p0.forkCount.text = context.getString(R.string.forks, it.forksCount)
                it.owner?.let { owner ->
                    p0.ownerName.text = context.getString(R.string.by, owner.login)
                    Glide
                        .with(context)
                        .load(owner.avatarUrl)
                        .into(p0.ownerImage)
                }
            }
        }

    }

    fun addLoading() {
        scrollLoading = true
        notifyDataSetChanged()
    }

    fun removeLoading() {
        scrollLoading = false
        notifyDataSetChanged()
    }

    class CellViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val repoName = itemView.tvRepoName
        val ownerName = itemView.tvOwner
        val ownerImage = itemView.ivOwner
        val starsCount = itemView.tvStars
        val forkCount = itemView.tvForks
        val rank = itemView.tvRank
    }

    class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}