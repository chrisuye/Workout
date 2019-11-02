package edu.towson.cosc412.seyoum.workout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_work_out.*
import java.lang.Exception

class WorkOut : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_out)

        val intent = intent
        val title = intent.getStringExtra("Title")
        val description = intent.getStringExtra("Description")
        val id = intent.getIntExtra("Id", -1)
        val license = intent.getIntExtra("License", 1)


        title_view.text = title
        description_view.text = description


        showsteps_btn.setOnClickListener {
            val i = Intent(this, ShowStep::class.java)
            i.putExtra("Id", id)
            startActivity(i)
        }

        int_btn.setOnClickListener {
            val intensity = when (int_group.checkedRadioButtonId){
                R.id. flex_rad -> 1
                R.id. Gen_rad -> 2
                R.id. bod_rad -> 3
                else -> throw Exception()
            }

            num_set.text = "you choice " + intensity
            num_reps.text = "you choice " + intensity
            num_weight.text = "you choice " + intensity
        }

        license_btn.setOnClickListener {
            val i = Intent(this, License::class.java)
            i.putExtra("License", license)
            startActivity(i)
        }



    }
}
