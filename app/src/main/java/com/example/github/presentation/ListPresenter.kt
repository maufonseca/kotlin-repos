package com.example.github.presentation

import com.example.github.domain.SearchResult

class ListPresenter(private val listView: ListViewInterface): ListPresenterInterface {

    override fun onResultReceived(result: SearchResult) {
        result.items?.let {
            listView.updateList(it)
            listView.stopRefresh()
        }
    }
}