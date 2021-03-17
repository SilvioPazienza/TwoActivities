package it.silviopazienza.twoactivities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    //leggere valore che arriva tramite intent
    val TAG = "SecondActivity"
    var returnvalue = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title = TAG
        //recuperiamo il valore dall'intent e lo asseniamo alla textview
        val data = intent.getDoubleExtra("main_activity_data", 0.0) //secondo valore di default nel caso la chiave non contenga nulla
        returnvalue = data*data
        textView.text = "$data => $returnvalue"

        Log.v(TAG, "onCreate second activity")
    }

    //gestire chiusura della second activity tramite click su button
    fun closeActivity2(v: View) {//metodo che useremo come handler
        var resulIntent = Intent() //assegno un nuovo intent alla variabile
        resulIntent.putExtra("result", returnvalue)
        setResult(Activity.RESULT_OK, resulIntent)//impostiamo il risultato che la second activity tornerà al chiamante
        finish() //chiusura della second activity e passo il controllo al chiamante
    }
}