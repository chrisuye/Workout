package edu.towson.cosc412.seyoum.workout

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list.view.*

class MainAdapter(var list: ArrayList<DataModel>): RecyclerView.Adapter<CustomViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.list, parent, false)
        return CustomViewHolder(cellForRow, list)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        if (list[position].title != ""){
            holder?.view?.title_txt.text = list[position].title
        }
        else{
            holder?.view?.title_txt.text = "Workout " + position
        }



    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class CustomViewHolder(val view: View, var list: ArrayList<DataModel>): RecyclerView.ViewHolder(view) {

    init {
        view.setOnClickListener {
            val position = adapterPosition
            //println("adapt "+position)

            val intent = Intent(view.context, WorkOut::class.java)

            intent.putExtra("Title", list[position].title)
            intent.putExtra("Description", list[position].description)
            intent.putExtra("Id", list[position].id)
            intent.putExtra("License", list[position].license)
            view.context.startActivity(intent)
        }
    }

}