package `in`.nareshtech.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var num1: EditText? = null
    var num2: EditText? = null
    var b1 : Button? = null
    var b2: Button? = null
    var b3: Button? = null
    var b4: Button? = null
    var tv : TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num1 = findViewById(R.id.editTextNumber)
        num2 = findViewById(R.id.editTextNumber2)
        b1 = findViewById(R.id.button)
        b2 = findViewById(R.id.button2)
        b3 = findViewById(R.id.button3)
        b4 = findViewById(R.id.button4)
        tv = findViewById(R.id.textView)

        b2?.setOnClickListener({
            val n1: Int = (num1?.text.toString()).toInt();
            val n2: Int = (num2?.text.toString()).toInt();
            tv?.text = (n1-n2).toString();
        })
    }

    fun handleClick(view: View) {
        val a = (num1?.text.toString()).toInt();
        val b = (num2?.text.toString()).toInt();
        tv?.text = (a+b).toString();
    }
}