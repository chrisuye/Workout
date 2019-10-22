package edu.towson.cosc412.seyoum.workout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list.view.*

class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.list, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val result = homeFeed.results.get(position)
        holder?.view?.title_txt?.text = result.description

    }

    override fun getItemCount(): Int {
        return homeFeed.results.count()
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}