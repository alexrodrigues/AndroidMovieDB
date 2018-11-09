package br.com.rodriguesalex.moviedb

import br.com.rodriguesalex.moviedb.models.MDbMovie
import br.com.rodriguesalex.moviedb.viewmodels.MovieViewModel
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verify

class HomeTests {

    private lateinit var movie: MovieViewModel

    @Before
    fun setup() {
        val mDbMovie = MDbMovie()
        mDbMovie.title = "Alex Kid"
        mDbMovie.poster = "cover.png"
        movie = MovieViewModel(mDbMovie)
    }

    @Test
    fun whenPageOpens() {
        assertEquals(movie.getTitle(), "Alex Kid")
        assertEquals(movie.getCoverImage(), "https://image.tmdb.org/t/p/w200/cover.png")
    }
}