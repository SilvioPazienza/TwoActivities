package it.silviopazienza.twoactivities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_fourth.*

class FourthActivity : AppCompatActivity() {
    val TAG = "FourthActivity"
    var returnValue = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        title = TAG

        val data = intent.getDoubleExtra("main_activity.data", 0.0) //secondo valore di default nel caso la chiave non contenga nulla
        returnValue = data * 5
        textViewActivity4.text = "$data => $returnValue" // <- Hai sbagliato qui
        Log.v(TAG, "onCreate second activity")
    }

    //gestire chiusura della second activity tramite click su button
    fun closeActivity4(v: View) {//metodo che useremo come handler
        var resultIntent = Intent()
        resultIntent.putExtra("result", returnValue)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}