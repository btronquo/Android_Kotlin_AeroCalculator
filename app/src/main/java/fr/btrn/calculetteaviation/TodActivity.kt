package fr.btrn.calculetteaviation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.pranavpandey.android.dynamic.toasts.DynamicToast
import kotlinx.android.synthetic.main.activity_tod.*


class TodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tod)

        btn_time_to_go.setOnClickListener {


            val inputManager:InputMethodManager =getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(currentFocus?.applicationWindowToken, InputMethodManager.SHOW_FORCED)




            if ((input_distance.text.toString() == "" || input_wind_force.text.toString() == "" || InputTrueSpeed.text.toString() == "" || txt_rate.text.toString() == "") || (input_wind_force.text.toString().toInt() > input_distance.text.toString().toInt())) {

                //val text = "Veuillez vérifier vos saisies"
                //val duration = Toast.LENGTH_SHORT
                //Toast.makeText(applicationContext, text, duration).show()
                DynamicToast.makeError(applicationContext, "Veuillez vérifier vos saisies").show();
            }else {
                var alt = input_distance.text.toString().trim()
                var altfinal = input_wind_force.text.toString().trim()


                var calculator = ((alt.toInt() - altfinal.toInt()) * 3) / 1000

                var toto = calculator.toString()




                // on calcule ce qu'on peut couvrir à une speed de 180 kts (il faut diviser par 60)
                var coverDistance = InputTrueSpeed.text.toString().toInt() / 60 // ca donne 3 miles par minute

                // 2. On regarde combien ce qu'on vas devoir descendre comme altitude
                val altRange = input_distance.text.toString().toInt() - input_wind_force.text.toString().toInt()

                // 3. Pour savoir combien de minutes il nous faut depuis le terrain pour le tod
                var minToTod = altRange / txt_rate.text.toString().toInt() // resultat en minutes

                // 4. Pour calculer la distance depuis le TOD, on multiplie les minutes depuis le terrain par les miles par minutes qu'on peut parcourir à la vitesse actuelle
                var distanceTod = (minToTod * coverDistance) // basé sur la groundspeed - resultat en Nm

                str_result.text = "TOD  à " + distanceTod + " Nm. \nDurée: " + minToTod + "minutes"
            }

        }

    }

    fun onClickBtnMenu(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)


    }

}
