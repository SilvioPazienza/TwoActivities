package it.silviopazienza.twoactivities

import FourthActivity
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() { //gestione dell'evento relativa all'interfaccia grafica (button)
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = TAG
        Log.v(TAG, "onCreate")//messaggio generato dalla classe MainActivity. Siamo dentro all'onCreate
    }

    fun openSecondActivity(v: View) { //per essere un handler deve avere parametro di tipo view
        Log.v(TAG, "onClick first button") //scriviamo nel log che siamo all'interno del metodo che gestisce evento onClick
        val intent: Intent = Intent(this@MainActivity, SecondActivity::class.java) //primo paramatro->context;secondo parametro->activity che deve essere eseguita
        //lettura del messaggio
        val msg = editText.text.toString()//quello che vogliamo mettere nell'activity. Leggiamo dall'edit text
        //conversione in Double
        try {
            val num = msg.toDouble()
            //inseriamo all'interno dell'intent
            intent.putExtra("main_activity_data", num)
            /*startActivity(intent)*/
            startActivityForResult(intent, 1) //facciamo partire activity dicendo che aspettiamo un valore di ritorno
        } catch (e: NumberFormatException) { //potrebbe essere lanciata eccezione
            Toast.makeText(applicationContext, "$msg is not a number", Toast.LENGTH_SHORT).show()
        }
    }

    fun openThirdActivity(v: View) {
        Log.v(TAG, "onClick third button")
        val intent = Intent(this@MainActivity, ThirdActivity::class.java)
        val msg = editText.text.toString()
        try {
            val num = msg.toDouble()
            intent.putExtra("main_activity.data", num)
            startActivityForResult(intent, 2)
        } catch (e: NumberFormatException) {
            Toast.makeText(applicationContext, "$msg isn't a double", Toast.LENGTH_SHORT).show()
        }
    }

    fun openFourthActivity(v: View) {
        Log.v(TAG, "onClick")
        val intent = Intent(this@MainActivity, FourthActivity::class.java)
        val msg = editText.text.toString()
        try {
            val num = msg.toDouble()
            intent.putExtra("main_activity.data", num)
            startActivityForResult(intent, 3)
        } catch (e: NumberFormatException) {
            Toast.makeText(applicationContext, "$msg isn't a double", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if ((requestCode == 1) and (resultCode == Activity.RESULT_OK)) { //se requestCode è giusto ed è andato tutto a buon fine
            val returnValue = data?.getDoubleExtra("result", 0.0)//andare a leggere valore dall'intent
            //con setText assegno direttamente una stringa
            editText.setText("$returnValue")//al textview andiamo a scrivere quello che abbiamo letto dall'intent
        } else if ((requestCode == 2) and (resultCode == Activity.RESULT_OK)) {
            val returnValue = data?.getDoubleExtra("result", 0.0)
            editText.setText("$returnValue")
        } else if ((requestCode == 3) and (resultCode == Activity.RESULT_OK)) {
            val returnValue = data?.getDoubleExtra("result", 0.0)
            editText.setText("$returnValue")
        }
    }
}