package com.example.github.presentation

import com.example.github.domain.SearchResult

interface ListPresenterInterface {

    fun onResultReceived(result: SearchResult)

}