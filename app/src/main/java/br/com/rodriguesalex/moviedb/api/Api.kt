package br.com.rodriguesalex.moviedb.api

import br.com.rodriguesalex.moviedb.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Api {

    private val timeout: Long = 40
    private val API_URL = BuildConfig.API_URL

    private  object Holder {
        val ADAPTER = Api().createAdapter()
    }

    companion object {
        val adapter: IApi by lazy {
            Api.Holder.ADAPTER
        }
    }

    private fun createRetrofit(): Retrofit {
        val gson = GsonBuilder()
                .create()

        val client = OkHttpClient.Builder()
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .readTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(logging)
        }

        return Retrofit.Builder()
                .baseUrl(API_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client.build())
                .build()
    }

    fun createAdapter(): IApi {
        return createRetrofit().create(IApi::class.java)
    }


}