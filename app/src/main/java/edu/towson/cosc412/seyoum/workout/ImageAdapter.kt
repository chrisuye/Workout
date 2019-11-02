package edu.towson.cosc412.seyoum.workout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_row.view.*

class ImageAdapter (var listimage: ArrayList<ImageDataModel>): RecyclerView.Adapter<CustomeView>(){

    override fun getItemCount(): Int {
        return listimage.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomeView {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.image_row, parent, false)
        return CustomeView(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomeView, position: Int) {
        val picture = holder?.view?.imageView
        Picasso.with(holder?.view?.context).load(listimage[position].image).into(picture)
    }

}

class CustomeView(val view:View):RecyclerView.ViewHolder(view){

}