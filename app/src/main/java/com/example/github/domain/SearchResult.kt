package com.example.github.domain

import com.google.gson.annotations.SerializedName

class SearchResult {
    @SerializedName("total_count")
    var totalCount = 0

    @SerializedName("incomplete_results")
    var incompleteResults = false

    var items: List<Repository>? = null
}