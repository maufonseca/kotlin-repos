package com.example.github.presentation

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.github.R
import com.example.github.domain.Repository
import com.example.github.infrastructure.RetrofitFactory
import kotlinx.android.synthetic.main.activity_main.*

class ListActivity : AppCompatActivity(), ListViewInterface {

    private lateinit var interactor: ListInteractorInterface
    private lateinit var presenter: ListPresenterInterface
    private lateinit var listAdapter: ListAdapter
    private val repositories: MutableList<Repository> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupScene()
        setupList()
    }

    private fun setupScene() {
        presenter = ListPresenter(this)
        interactor = ListInteractor(presenter, RetrofitFactory.makeGithubService())
    }

    private fun setupList() {
        srlRepositoriesRefresh.setOnRefreshListener { interactor.onCreateList() }
        rvRepositories.layoutManager = LinearLayoutManager(this)
        listAdapter = ListAdapter(repositories, this)
        rvRepositories.adapter = listAdapter
        interactor.onCreateList()
    }

    override fun updateList(list: List<Repository>) {
        repositories.clear()
        addToList(list)
    }

    override fun addToList(list: List<Repository>) {
        repositories.addAll(list)
        listAdapter.notifyDataSetChanged()
    }

    override fun stopRefresh() {
        srlRepositoriesRefresh.isRefreshing = false
    }

    fun openRepository(v: View) {
        val url = v.tag as String
        val uris = Uri.parse(url)
        val intents = Intent(Intent.ACTION_VIEW, uris)
        val b = Bundle()
        b.putBoolean("new_window", true)
        intents.putExtras(b)
        startActivity(intents)
    }
}
