package com.example.github.domain

import com.google.gson.annotations.SerializedName

class Owner {
    var login: String? = null

    @SerializedName("avatar_url")
    var avatarUrl: String? = null
}