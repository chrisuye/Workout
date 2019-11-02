package edu.towson.cosc412.seyoum.workout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_show_step.*
import okhttp3.*
import java.io.IOException

class ShowStep : AppCompatActivity() {

    var listimage = ArrayList<ImageDataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_step)

        val intent = intent
        val id = intent.getIntExtra("Id", 0)

        recycle_image.layoutManager = LinearLayoutManager(this)
        val url = "https://wger.de/api/v2/exerciseimage/?format=json"

        getjson(url, id)
    }

    fun getjson(url:String, id:Int){

        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("fail")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()

                val imageFeed = gson.fromJson(body, ImageFeed::class.java)

                for (elm in imageFeed.results){
                    if (elm.exercise == id){
                        println(elm.image)
                        listimage.add(ImageDataModel(elm.image))
                    }
                }

                if (imageFeed.next != null){
                    getjson(imageFeed.next,id)
                }


                runOnUiThread {
                    recycle_image.adapter = ImageAdapter(listimage)
                }
            }


        })
    }
}
