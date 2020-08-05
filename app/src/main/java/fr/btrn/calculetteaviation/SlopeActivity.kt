package fr.btrn.calculetteaviation

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.pranavpandey.android.dynamic.toasts.DynamicToast
import kotlinx.android.synthetic.main.activity_base_factor.*
import kotlinx.android.synthetic.main.activity_derive.*
import kotlinx.android.synthetic.main.activity_derive.InputTrueSpeed
import kotlinx.android.synthetic.main.activity_slope.*
import kotlinx.android.synthetic.main.activity_slope.str_result

class SlopeActivity : AppCompatActivity() {
    @SuppressLint("StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slope)

        btn_slope.setOnClickListener {

            /* -- hide the keyboard -- */
            val inputManager: InputMethodManager =getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(currentFocus?.applicationWindowToken, InputMethodManager.SHOW_FORCED)

            if (InputRunwayMaxElevation.text.toString() == "" || InputRunwayMinElevation.text.toString() == "") {
                DynamicToast.makeError(applicationContext, applicationContext.getString(R.string.toast_error_input)).show();
            }else {

                var res =
                    ((InputRunwayMaxElevation.text.toString().toDouble() - InputRunwayMinElevation.text.toString().toDouble()) / (InputRunwayLenght.text.toString().toDouble()) * 100)

                Log.i("SLOPE", "Resultat du calcul du slope $res")

                str_result.text = getString(R.string.txt_res_slope, res)




            }

        }

    }

    fun onClickBtnMenu(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun Double.formatDecimal(numberOfDecimals: Int = 2): String = "%.${numberOfDecimals}f".format(this)

}