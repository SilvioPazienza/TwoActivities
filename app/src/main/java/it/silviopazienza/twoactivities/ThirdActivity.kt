package it.silviopazienza.twoactivities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class ThirdActivity : AppCompatActivity() {
    val TAG = "ThirdActivity"
    var returnvalue = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        title = TAG
        val data = intent.getDoubleExtra("main_activity.data", 0.0)
        returnvalue = data*2.0
        textView.text = "$data => $returnvalue"

        Log.v(TAG, "onCreate third activity")
    }

    fun closeActivity3(v: View) {
        var resultIntent = Intent()
        resultIntent.putExtra("result", returnvalue)
        setResult(Activity.RESULT_OK, resultIntent) //impostiamo il rusiltato che la third activity tornerà al chiamante
        finish()
    }
}