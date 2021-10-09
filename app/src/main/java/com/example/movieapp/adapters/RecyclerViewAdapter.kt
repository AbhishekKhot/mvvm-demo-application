package com.example.movieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.movieapp.databinding.RvItemBinding
import com.example.movieapp.models.ShowsData

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    inner class RecyclerViewHolder(val binding: RvItemBinding):RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<ShowsData>() {
        override fun areItemsTheSame(oldItem: ShowsData, newItem: ShowsData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ShowsData, newItem: ShowsData): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this,diffCallback)

    var ListOfShows:List<ShowsData>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(RvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.binding.apply {
            ShowTitleTextView.text = ListOfShows[position].name
            ShowsRatingTextView.text =ListOfShows[position].rating.toString()
            ShowTypeTextView.text = ListOfShows[position].type
            ShowImageView.load(ListOfShows[position].image.original){
                crossfade(true)
                crossfade(1000)
            }
        }
    }
    override fun getItemCount() = ListOfShows.size
}