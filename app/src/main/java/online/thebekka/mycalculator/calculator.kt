package online.thebekka.mycalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_calculator.*
import kotlinx.android.synthetic.main.activity_calculator.view.*

class calculator : AppCompatActivity() {

    var tempVar1 = ""
    var tempVar2 = ""
    var tempOperation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        init()
    }

    fun init() {

        delete.setOnClickListener {
            tempOperation = ""
            tempVar1 = ""
            tempVar2 = ""
            updateUI()
        }

        result.setOnClickListener {
            // calculate
            makeCalculation()
        }
    }

    fun numButtonPress(view: View) {
        val button = view as Button

        if (tempOperation.isEmpty()) {
            // if the first number sopt is not taken then fill first spot
            if(tempVar1.contains(".") && button.text.toString().equals(".")){
                // can't write more dots
            }
            else
            {
                tempVar1 += button.text.toString()
            }
        } else if (!tempVar1.equals("")) {

            if(tempVar2.contains(".") && button.text.toString().equals(".")){
                // can't write more dots
            }
            else
            {
                tempVar2 += button.text.toString()
            }
        }
        updateUI()
    }

    fun calculationButtonPress(view: View) {

        val button = view as Button

        if((button.text.equals("+") || button.text.equals("*") || button.text.equals(":")) && tempVar1.isEmpty()){

        }else {

            if (button.text.equals("-") && tempVar2.isEmpty() && tempOperation.isEmpty() && tempVar1.isEmpty()) {

                tempVar1 = "-"
            } else {

                if (tempVar2.isNotEmpty()) {
                    makeCalculation()
                    tempOperation = button.text.toString()

                } else {
                    tempOperation = button.text.toString()

                }
            }
        }
        updateUI()
    }

    fun updateUI() {
        textView.text = tempVar1 + " " + tempOperation + " " + tempVar2;
    }

    fun makeCalculation() {
        if (tempVar1.isEmpty() || tempVar2.isEmpty() || tempOperation.isEmpty()) {
            //don't calculate


        } else {

            val x1 = tempVar1.toDouble()
            val x2 = tempVar2.toDouble()

            //calculate and update ui
            if (tempOperation.equals("+")) {
                val c: Double = x1 + x2
                tempVar1 = c.toString()

            } else if (tempOperation.equals("-")) {
                val c: Double = x1 - x2
                tempVar1 = c.toString()

            } else if (tempOperation.equals("*")) {
                val c: Double = x1 * x2
                tempVar1 = c.toString()

            } else if (tempOperation.equals(":")) {
                val c: Double = x1 / x2
                tempVar1 = c.toString()

            }

            tempVar2 = ""
            tempOperation = ""
            updateUI()
        }
    }
}