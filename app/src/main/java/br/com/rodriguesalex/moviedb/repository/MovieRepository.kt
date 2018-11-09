package br.com.rodriguesalex.moviedb.repository

import br.com.rodriguesalex.moviedb.BuildConfig
import br.com.rodriguesalex.moviedb.api.Api
import br.com.rodriguesalex.moviedb.api.IApi
import br.com.rodriguesalex.moviedb.models.MDbMovie
import br.com.rodriguesalex.moviedb.viewmodels.MovieViewModel
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MovieRepository {
    fun fetchMovies(callback: MovieViewModel.MovieViewModelCallback) {
        val api: IApi = Api().createAdapter()
        val firstPage = 1
        api.getMovies(BuildConfig.API_KEY, firstPage)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe({response ->
                    response.results?.let { movieList ->
                        val viewModelList = ArrayList<MovieViewModel>()
                        for (movie in movieList) {
                            viewModelList.add(convertToViewModel(movie))
                        }
                        callback.didFetchMovies(viewModelList)
                    }
                }, {
                    callback.didFail()
                })
    }

    private fun convertToViewModel(movie: MDbMovie): MovieViewModel {
        return MovieViewModel(movie)
    }
}