package fr.btrn.calculetteaviation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.pranavpandey.android.dynamic.toasts.DynamicToast
import kotlinx.android.synthetic.main.activity_tod.*
import java.lang.String

class BaseFactor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_factor)


        // calculer le resultat
        btn_time_to_go.setOnClickListener {

            val inputManager: InputMethodManager =getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(currentFocus?.applicationWindowToken, InputMethodManager.SHOW_FORCED)

            if (InputTrueSpeed.text.toString() == "" ) {
                DynamicToast.makeError(applicationContext, "Veuillez vérifier vos saisies").show();
            }else {
                val baseFactor = kotlin.String.format("%.02f", (60 / InputTrueSpeed.text.toString().toFloat()))
                str_result.text = "Facteur de base calculé: $baseFactor"
            }

        }

    }

    fun onClickBtnMenu(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}