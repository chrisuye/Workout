package edu.towson.cosc412.seyoum.workout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_license.*
import okhttp3.*
import java.io.IOException

class License : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_license)

        val intent = intent
        val license = intent.getIntExtra("License", 1)


        if (license == 1) {
            fullname_view.text = "Creative Commons Attribution Share Alike 3"
            shortname_view.text = "CC-BY-SA 3"
            url_view.text = "https://creativecommons.org/licenses/by-sa/3.0/deed.en"
        }
        else if (license == 2) {

            fullname_view.text =  "Creative Commons Attribution Share Alike 4"
            shortname_view.text = "CC-BY-SA 4"
            url_view.text = "https://creativecommons.org/licenses/by-sa/4.0/deed.en"
        }
        else if (license == 3) {
            fullname_view.text = "Creative Commons Public Domain 1.0"
            shortname_view.text = "CC0"
            url_view.text = "http://creativecommons.org/publicdomain/zero/1.0/"
        }




    }

}
