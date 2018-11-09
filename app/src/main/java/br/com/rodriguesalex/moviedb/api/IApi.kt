package br.com.rodriguesalex.moviedb.api

import br.com.rodriguesalex.moviedb.models.MDbResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface IApi {

    @GET("/3/movie/popular")
    fun getMovies(@Query("api_key") apiKey: String,
                    @Query("page") page: Int): Observable<MDbResponse>

}