package edu.towson.cosc412.seyoum.workout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class InfoList : AppCompatActivity() {

    val list = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_list)

        val intent = intent
        val category = intent.getIntExtra("Intensity", 10)




        val url = "https://wger.de/api/v2/exercise/?format=json"

        fetchJson(url, category)
    }

    fun fetchJson(url:String, category:Int){
        println("fetching")

        val url = url

        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("fail")
            }

            override fun onResponse(call: Call, response: Response) {
                 val body = response?.body()?.toString()
                 println(body)

                 val gson = GsonBuilder().create()

                 val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                println("just need to figure out request")


                for (elm in homeFeed.results){
                    if (elm.category == category){
                        println(elm.description)
                        list.add(elm.description)
                    }
                }

                if (homeFeed.next == null){
                    fetchJson(homeFeed.next,category)
                }



                //runOnUiThread {
                // recyclerView_main.adapter = MainAdapter(homeFeed)
                // }
            }


        })


    }
}
