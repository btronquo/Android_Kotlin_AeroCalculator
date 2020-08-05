package fr.btrn.calculetteaviation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.firebase.analytics.FirebaseAnalytics




class MainActivity : AppCompatActivity() {

    private lateinit var mAdView : AdView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
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

    fun onClickBtnSlope(view:View) {
        val intent = Intent(this, SlopeActivity::class.java)
        startActivity(intent)
    }


    /* donate btn */
    fun onClickBtnPayMeACoffee(view:View) {
        val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://paypal.me/btrn/2"))
        startActivity(i)
    }
}