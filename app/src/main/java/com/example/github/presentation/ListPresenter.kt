package com.example.github.presentation

import com.example.github.domain.SearchResult

class ListPresenter(private val listView: ListViewInterface): ListPresenterInterface {

    override fun onResultReceived(result: SearchResult, page: Int) {
        result.items?.let {
            print("adding page: $page")
            if(page == 1) listView.updateList(it)
            else listView.addToList(it)
            listView.stopRefresh()
        }
    }

    override fun onItemsCompleted() {
        listView.endInfiniteScroll()
    }
}