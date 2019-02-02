package com.example.github.domain

import com.google.gson.annotations.SerializedName

class Repository {
    var name: String? = null

    @SerializedName("full_name")
    var fullName: String? = null

    @SerializedName("html_url")
    var htmlUrl: String? = null

    var owner: Owner? = null

    @SerializedName("stargazers_count")
    var stargazersCount: Long = 0

    @SerializedName("forks_count")
    var forksCount: Long = 0
}