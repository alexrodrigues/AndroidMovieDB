package br.com.rodriguesalex.moviedb.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import br.com.rodriguesalex.moviedb.R
import br.com.rodriguesalex.moviedb.ui.adapters.HomeAdapter
import br.com.rodriguesalex.moviedb.viewmodels.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MovieViewModel.MovieViewModelCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchMovies()
    }

    private fun fetchMovies() {
        MovieViewModel.getPopularMovies(this)
    }

    override fun didFetchMovies(movies: List<MovieViewModel>) {
        if (movies.isNotEmpty()) {
            val layoutManager = GridLayoutManager(this, 3)
            layoutManager.orientation = GridLayoutManager.VERTICAL
            val adapter = HomeAdapter(this, movies)
            rvHome.layoutManager = layoutManager
            rvHome.adapter = adapter
            rvHome.visibility = View.VISIBLE
            pbHome.visibility = View.GONE
        }
    }

    override fun didFail(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }
}
