package br.com.rodriguesalex.moviedb.ui.adapters

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.rodriguesalex.moviedb.R
import br.com.rodriguesalex.moviedb.viewmodels.MovieViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(private val context: Context,
                  private val list: List<MovieViewModel>)
                        : RecyclerView.Adapter<HomeAdapter.HomeItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_home, parent, false)
        return HomeItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HomeItemViewHolder, position: Int) {
        holder.bind(context, list[position])
    }


    class HomeItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(context: Context, movie: MovieViewModel) {
            itemView.vPlaceholder.visibility = View.INVISIBLE
            val options = RequestOptions().transform(RoundedCorners(8))
            Glide.with(context)
                    .applyDefaultRequestOptions(options)
                    .load(movie.getCoverImage())
                        .into(itemView.ivCover)
            itemView.ivCover.visibility = View.VISIBLE
            itemView.tvMovieName.text = movie.getTitle()
        }
    }
}