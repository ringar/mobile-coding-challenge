package com.daniel.farre.yogasolotest.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daniel.farre.yogasolotest.R
import com.daniel.farre.yogasolotest.domain.Posture
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.posture_list_cell_layout.view.*

class PosturesAdapter(private val listener: PosturesListener) : RecyclerView.Adapter<PosturesAdapter.PosturesViewHolder>() {

    var posturesList = emptyList<Posture>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PosturesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.posture_list_cell_layout, parent, false), listener)

    override fun getItemCount(): Int = posturesList.size

    override fun onBindViewHolder(holder: PosturesViewHolder, position: Int) {
        holder.bind(posturesList[position])
    }

    class PosturesViewHolder(itemView: View, private val  listener: PosturesListener) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Posture) {
            itemView.row_description.text = item.description
            if(itemView.row_image != null) Picasso.with(itemView.context).load(item.picture).skipCache().into(itemView.row_image)
            itemView.setOnClickListener {
                listener.onClicked(item)
            }
        }
    }
}