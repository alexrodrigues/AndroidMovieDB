package br.com.rodriguesalex.moviedb.injection.component

import br.com.rodriguesalex.moviedb.viewmodels.MovieViewModel
import dagger.Component
import net.gahfy.mvvmposts.injection.module.NetworkModule
import javax.inject.Singleton

/**
 * https://proandroiddev.com/mvvm-with-kotlin-android-architecture-components-dagger-2-retrofit-and-rxandroid-1a4ebb38c699
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(movieViewModel: MovieViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }
}