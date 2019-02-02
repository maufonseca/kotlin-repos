package com.example.github.presentation

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EndlessScrollListener(private val visibleThreshold: Int = 6,
                            private val linearLayoutManager: LinearLayoutManager,
                            private val onScrolledBeyondVisibleThreshold: () -> Unit,
                            private val onScrolled: () -> Unit? = { null }) :
    RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if (linearLayoutManager.findLastVisibleItemPosition() > linearLayoutManager.itemCount - visibleThreshold) onScrolledBeyondVisibleThreshold()
        onScrolled()
    }
}