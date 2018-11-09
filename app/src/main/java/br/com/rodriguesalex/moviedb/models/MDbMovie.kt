package br.com.rodriguesalex.moviedb.models

import com.google.gson.annotations.SerializedName

class MDbMovie {
    @SerializedName("poster_path") var poster: String? = null
    @SerializedName("title") var title: String? = null
    @SerializedName("vote_average") val voteAverage: Double? = null
    @SerializedName("release_date") val releaseDate: String? = null
}

