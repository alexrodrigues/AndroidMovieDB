package br.com.rodriguesalex.moviedb.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MDbResponse: Serializable {
    @SerializedName("page") var page: Int? = null
    @SerializedName("results") var results: List<MDbMovie>? = null
}