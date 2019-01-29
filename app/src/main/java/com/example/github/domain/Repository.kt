package com.example.github.domain

class Repository {
    var name: String? = null
    var full_name: String? = null
    var owner: Owner? = null
    var stargazers_count: Long = 0
    var forks_count: Long = 0
}