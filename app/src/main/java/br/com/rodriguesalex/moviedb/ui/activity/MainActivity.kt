package br.com.rodriguesalex.moviedb.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.rodriguesalex.moviedb.R
import br.com.rodriguesalex.moviedb.viewmodels.MovieViewModel

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

    }

    override fun didFail() {

    }
}
