package com.example.github.presentation

import com.example.github.infrastructure.GithubService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ListInteractor(private val presenter: ListPresenterInterface,
                     private val service: GithubService): ListInteractorInterface {

    private var page = 1
    private var isLoading = false
    private var isComplete = false
    private val compositeDisposable = CompositeDisposable()

    override fun onCreateList() {
        getRepositories()
    }

    override fun onRefresh() {
        isComplete = false
        page = 1
        getRepositories()
    }

    override fun onScrolledBeyondVisibleThreshold() {
        if (!isLoading && !isComplete) {
            getRepositories()
        }
    }

    private fun getRepositories() {

        compositeDisposable.add(service.getRepositories(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                isLoading = true
            }.doOnTerminate {
                isLoading = false
            }.subscribe(
                {
                    presenter.onResultReceived(it, page)

                    isLoading = false
                    if ( page * 30 >= it.totalCount) {
                        presenter.onItemsCompleted()
                        isComplete = true
                    }
                    page++

                },
                {
                    it.printStackTrace()
                }
            ))
    }

    override fun onDestroy() { compositeDisposable.dispose() }
}