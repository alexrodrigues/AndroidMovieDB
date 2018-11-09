package br.com.rodriguesalex.moviedb.viewmodels

import br.com.rodriguesalex.moviedb.models.MDbMovie
import br.com.rodriguesalex.moviedb.repository.MovieRepository

class MovieViewModel(private val movie: MDbMovie) {

    fun getCoverImage(): String {
        movie.poster?.let {
            return "https://image.tmdb.org/t/p/w200/$it"
        }
        return ""
    }

    fun getTitle(): String {
        return movie.title ?: ""
    }

    companion object {
        fun getPopularMovies(callback: MovieViewModelCallback) {
            MovieRepository().fetchMovies(callback)
        }
    }

    interface MovieViewModelCallback {
        fun didFetchMovies(movies: List<MovieViewModel>)
        fun didFail(errorMessage: String)
    }
}
