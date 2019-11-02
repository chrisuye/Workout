package edu.towson.cosc412.seyoum.workout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_info_list.*
import okhttp3.*
import java.io.IOException

class InfoList : AppCompatActivity() {

    var list = ArrayList<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_list)
        println("hello")
        recyclerView_main.layoutManager = LinearLayoutManager(this)

        val intent = intent
        val category = intent.getIntExtra("Option", 10)




        val name = "https://wger.de/api/v2/exercise/?format=json"

        fetchJson(name, category)

        println("go")



    }

    fun fetchJson(name:String, category:Int){
        println("fetching")

        val url = name

        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()

        //This is where the error is need to fix

        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("fail")
            }

            override fun onResponse(call: Call, response: Response) {

                 val body = response?.body()?.string()
                 println(body)

                 val gson = GsonBuilder().create()

                 println("some thing is wrong with homefeed")
                 val homeFeed = gson.fromJson(body, HomeFeed :: class.java)

                 println("just need to figure out request")


                for (elm in homeFeed.results){
                    if (elm.category == category){
                        println(elm.description)
                        list.add(DataModel(elm.id,elm.name,elm.description))
                    }
                }

                if (homeFeed.next != null){
                    fetchJson(homeFeed.next,category)
                }

                println("Finished fetching")

                runOnUiThread {
                    recyclerView_main.adapter = MainAdapter(list)
                }
                //wait_view.text = "DONE!"



            }


        })


    }
}
