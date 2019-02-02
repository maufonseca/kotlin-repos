package com.example.github.presentation

interface ListInteractorInterface {

    fun onCreateList()
    fun onRefresh()
    fun onScrolledBeyondVisibleThreshold()
    fun onDestroy()
}