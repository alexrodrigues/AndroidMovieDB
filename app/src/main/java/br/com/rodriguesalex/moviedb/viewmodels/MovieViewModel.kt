package br.com.rodriguesalex.moviedb.viewmodels

import br.com.rodriguesalex.moviedb.BuildConfig
import br.com.rodriguesalex.moviedb.api.Api
import br.com.rodriguesalex.moviedb.api.IApi
import br.com.rodriguesalex.moviedb.models.MDbMovie
import br.com.rodriguesalex.moviedb.repository.MovieRepository
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

class MovieViewModel(private val movie: MDbMovie) {


    companion object {
        fun getPopularMovies(callback: MovieViewModelCallback) {
            MovieRepository().fetchMovies(callback)
        }
    }

    interface MovieViewModelCallback {
        fun didFetchMovies(movies: List<MovieViewModel>)
        fun didFail()
    }
}
