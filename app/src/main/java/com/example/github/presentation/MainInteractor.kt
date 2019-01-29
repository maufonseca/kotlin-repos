package com.example.github.presentation

import com.example.github.infrastructure.GithubService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainInteractor(private val presenter: ListPresenterInterface,
                     private val service: GithubService): ListInteractorInterface {

    override fun onCreateList() {
        getRepositories()
    }

    private fun getRepositories() {
        GlobalScope.launch(Dispatchers.Main) {
            val request = service.getRepositories()
            try {
                val response = request.await()
                response.body()?.let {
                    presenter.onResultReceived(it)
                }
            } catch (e: HttpException) {
                print(e.code())
            } catch (e: Throwable) {
                print("Ooops. Error!")
            }
        }
    }
}