package fr.btrn.calculetteaviation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickBtnTod(view:View) {
        val intent = Intent(this, TodActivity::class.java)
        startActivity(intent)
    }

    fun onClickBtnBaseFactor(view:View) {
        val intent = Intent(this, BaseFactor::class.java)
        startActivity(intent)
    }

    fun onClickBtnDerive(view:View) {
        val intent = Intent(this, DeriveActivity::class.java)
        startActivity(intent)
    }

    fun onClickBtnTimeToGo(view:View) {
        val intent = Intent(this, TimeToGoActivity::class.java)
        startActivity(intent)
    }
}