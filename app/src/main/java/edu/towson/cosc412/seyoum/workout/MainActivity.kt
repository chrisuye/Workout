package edu.towson.cosc412.seyoum.workout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    var intensity = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        next_btn.setOnClickListener {
            handler_intense()

            val intent = Intent (this, InfoList :: class.java)


            intent.putExtra("Intensity", intensity)
            startActivity(intent)


        }
    }

    fun handler_intense() {
        try {

            intensity = when(select_rad.checkedRadioButtonId){
                R.id. abs_rad -> 10
                R.id. arm_rad -> 8
                R.id. back_rad -> 12
                R.id. calves_rad -> 14
                R.id. chest_rad -> 11
                R.id. legs_rad -> 9
                R.id. sholders_rad -> 13
                else -> throw Exception()
            }

            if (intensity == 10){
                println("abs")
            }
            else if (intensity == 8){
                println("arm")
            }
            else if (intensity == 14){
                println("calves")
            }


        }catch (e: Exception){

        }
    }
}
