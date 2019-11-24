package edu.towson.cosc412.seyoum.workout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
            when (int_group.checkedRadioButtonId){
                R.id. flex_rad -> {
                    num_set.text = "3 to 8 reps"
                    num_reps.text = "3 minute rest on between sets"
                    num_weight.text = "Rest the body part for 48 hours"}
                R.id. Gen_rad -> {
                    num_set.text = "15 to 25 reps"
                    num_reps.text = "1 minute rest on between sets"
                    num_weight.text = "Rest the body part for 48 hours"
                }
                R.id. bod_rad -> {
                    num_set.text = "8 to 12 reps"
                    num_reps.text = "2 minute rest on between sets"
                    num_weight.text = "Rest the body part for 48 hours"
                }
                else -> {
                    Toast.makeText(this,"select intensity", Toast.LENGTH_SHORT).show()
                }
            }


        }

        license_btn.setOnClickListener {
            val i = Intent(this, License::class.java)
            i.putExtra("License", license)
            startActivity(i)
        }



    }
}
