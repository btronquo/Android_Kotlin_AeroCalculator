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




            if ((InputCruiseAltitude.text.toString() == "" || InputApproachFixAltitude.text.toString() == "" || InputTrueSpeed.text.toString() == "" || InputRateOfDescent.text.toString() == "") || (InputCruiseAltitude.text.toString().toInt() < InputApproachFixAltitude.text.toString().toInt())) {

                DynamicToast.makeError(applicationContext, applicationContext.getString(R.string.toast_error_input)).show();
            }else {

                // tod = (ground speed * Δ Z)/(60 * Vz)
                var distanceToTod = (InputTrueSpeed.text.toString().toInt() * (InputCruiseAltitude.text.toString().toInt() - InputApproachFixAltitude.text.toString().toInt())) / (60 * InputRateOfDescent.text.toString().toInt())
                var timeToTod = ((InputCruiseAltitude.text.toString().toInt() - InputApproachFixAltitude.text.toString().toInt()) / InputRateOfDescent.text.toString().toInt())
                str_result.text = getString(R.string.tod_result, distanceToTod, timeToTod)



            }

        }

    }

    fun onClickBtnMenu(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)


    }

}
