package com.example.github.domain

class SearchResult {
    var total_count = 0
    var incomplete_results = false
    var items: List<Repository>? = null
}