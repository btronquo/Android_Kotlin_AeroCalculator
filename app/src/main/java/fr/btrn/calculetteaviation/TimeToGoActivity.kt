package fr.btrn.calculetteaviation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.math.RoundingMode
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.pranavpandey.android.dynamic.toasts.DynamicToast
import kotlinx.android.synthetic.main.activity_derive.*
import kotlinx.android.synthetic.main.activity_tod.InputTrueSpeed
import kotlinx.android.synthetic.main.activity_tod.btn_time_to_go
import kotlinx.android.synthetic.main.activity_tod.input_distance
import kotlinx.android.synthetic.main.activity_tod.input_wind_force
import kotlinx.android.synthetic.main.activity_tod.str_result
import kotlin.math.sin

class TimeToGoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_to_go)



        btn_time_to_go.setOnClickListener {

            /* -- hide the keyboard -- */
            val inputManager: InputMethodManager =getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(currentFocus?.applicationWindowToken, InputMethodManager.SHOW_FORCED)

            if (InputTrueSpeed.text.toString() == "" || input_distance.text.toString() == "") {
                DynamicToast.makeError(applicationContext, applicationContext.getString(R.string.toast_error_input)).show();
            }else {

                // formule
                // = distance(nm) * facteur_base

                var result =
                    (input_distance.text.toString().toDouble() * (60/InputTrueSpeed.text.toString().toDouble())).formatDecimal(1)


                str_result.text = "Temps sans vent: $result minutes"


            }

        }

    }

    fun onClickBtnMenu(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

private fun Double.formatDecimal(numberOfDecimals: Int = 2): String = "%.${numberOfDecimals}f".format(this)
