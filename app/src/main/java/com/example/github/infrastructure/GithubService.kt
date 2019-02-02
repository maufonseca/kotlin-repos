package com.example.github.infrastructure

import com.example.github.domain.SearchResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("search/repositories")
    fun getRepositories(
        @Query("page") page: Int = 1,
        @Query("q") language: String = "language:kotlin",
        @Query("sort") sortBy: String = "starts"
    ): Observable<SearchResult>
}