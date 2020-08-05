package fr.btrn.calculetteaviation

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.pranavpandey.android.dynamic.toasts.DynamicToast
import kotlinx.android.synthetic.main.activity_derive.*
import kotlinx.android.synthetic.main.activity_derive.InputTrueSpeed
import kotlinx.android.synthetic.main.activity_derive.btn_time_to_go
import kotlinx.android.synthetic.main.activity_derive.str_result
import kotlinx.android.synthetic.main.activity_tod.*
import java.lang.Math.toRadians
import kotlin.math.roundToInt
import kotlin.math.sin

class DeriveActivity : AppCompatActivity() {
    @SuppressLint("StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_derive)

        btn_time_to_go.setOnClickListener {


            /* -- hide the keyboard -- */
            val inputManager: InputMethodManager =getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(currentFocus?.applicationWindowToken, InputMethodManager.SHOW_FORCED)

            if (InputTrueSpeed.text.toString() == "" || InputWindDegree.text.toString() == "" || InputWindForce.text.toString() == "") {
                DynamicToast.makeError(applicationContext, applicationContext.getString(R.string.toast_error_input)).show();
            }else {


                // Exemple :   Avion = DR 400 Vp = 100 kt Vent = 280° / 15 kt


                // -- données à mapper -- //
                // facteur de base ?
                // Rm (route magnétique) ?

                // d = X . sin(alpha)
                // Alpha = 280 - 50 = 230 - 180 = 50
                // sin de 50 = 0.7
                // X = 15 x 0.6 = 9
                // X = vent en kt x fb
                // donc ----> d = 9 x 0.7 = 6.3°
                // donc ----> d =


                val alpha =
                    (InputWindDegree.text.toString().toDouble() - Input_RouteMagnetique.text.toString().toDouble()) - 180
                val x =
                    InputWindForce.text.toString().toDouble() * (60/InputTrueSpeed.text.toString().toDouble())
                val derive =
                    ((x * sin(toRadians(alpha))) * 100).roundToInt() / 100.0
                str_result.text = getString(R.string.txt_res_drift, derive)

            }

        }

    }

    fun onClickBtnMenu(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}