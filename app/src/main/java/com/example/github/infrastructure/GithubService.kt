package com.example.github.infrastructure

import com.example.github.domain.Repository
import com.example.github.domain.SearchResult
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface GithubService {
    @GET("search/repositories?q=language:kotlin&sort=stars&page=1")
    fun getRepositories(): Deferred<Response<SearchResult>>
}