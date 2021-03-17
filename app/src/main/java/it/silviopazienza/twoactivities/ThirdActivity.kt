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
    var returnValue = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third2)

        title = TAG

        val data = intent.getDoubleExtra("main_activity.data", 0.0)
        returnValue = data * 2.0
        textView.text = "$data -> $returnValue"

        Log.v(TAG, "OnCreate")
    }

    fun closeActivity(v: View) {
        var resultIntent = Intent()
        resultIntent.putExtra("result", returnValue)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}