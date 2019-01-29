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
                  private val context: Context): RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun getItemCount(): Int = repositories.size

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.cell_repository, p0, false))
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.rank.text = context.getString(R.string.rank, p1+1)
        repositories[p1].let {
            p0.repoName.text = it.name
            p0.itemView.tag = it.html_url
            p0.starsCount.text = context.getString(R.string.stars, it.stargazers_count)
            p0.forkCount.text = context.getString(R.string.forks, it.forks_count)
            it.owner?.let { owner ->
                p0.ownerName.text = context.getString(R.string.by, owner.login)
                Glide
                    .with(context)
                    .load(owner.avatar_url)
                    .into(p0.ownerImage)
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val repoName = itemView.tvRepoName
        val ownerName = itemView.tvOwner
        val ownerImage = itemView.ivOwner
        val starsCount = itemView.tvStars
        val forkCount = itemView.tvForks
        val rank = itemView.tvRank
    }
}