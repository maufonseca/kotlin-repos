package com.example.github.presentation

import com.example.github.domain.Repository

interface ListViewInterface {

    fun updateList(list: List<Repository>)
    fun addToList(list: List<Repository>)
    fun endInfiniteScroll()
    fun stopRefresh()
}