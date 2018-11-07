package net.gahfy.mvvmposts.injection.module

import br.com.rodriguesalex.moviedb.api.Api
import br.com.rodriguesalex.moviedb.api.IApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
/**
 * https://proandroiddev.com/mvvm-with-kotlin-android-architecture-components-dagger-2-retrofit-and-rxandroid-1a4ebb38c699
 */
@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object NetworkModule {
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideApi(retrofit: Retrofit): IApi {
        return retrofit.create(IApi::class.java)
    }
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Api().createRetrofit()
    }
}