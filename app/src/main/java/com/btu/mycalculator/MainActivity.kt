package com.btu.mycalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View.OnLongClickListener



class MainActivity : AppCompatActivity() {

    var resultString = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        buttonsWorkflow()
    }

    fun buttonsWorkflow (){

        button0.setOnClickListener{
            zeroErrorHandler()
            resultString += 0
            UiUpdate()
        }
        button1.setOnClickListener{
            zeroErrorHandler()
            resultString += 1
            UiUpdate()
        }
        button2.setOnClickListener{
            zeroErrorHandler()
            resultString += 2
            UiUpdate()
        }
        button3.setOnClickListener{
            zeroErrorHandler()
            resultString += 3
            UiUpdate()
        }
        button4.setOnClickListener{
            resultString += 4
            UiUpdate()
        }
        button5.setOnClickListener{
            zeroErrorHandler()
            resultString += 5
            UiUpdate()
        }
        button6.setOnClickListener{
            zeroErrorHandler()
            resultString += 6
            UiUpdate()
        }
        button7.setOnClickListener{
            zeroErrorHandler()
            resultString += 7
            UiUpdate()
        }
        button8.setOnClickListener{
            zeroErrorHandler()
            resultString += 8
            UiUpdate()
        }
        button9.setOnClickListener{
            zeroErrorHandler()
            resultString += 9
            UiUpdate()
        }

        minus.setOnClickListener {

            errorHandlers()

            if(resultString.contains("+")){
                var x = resultString.split("+")[0].toDouble()
                var y = resultString.split("+")[1].toDouble()

                resultString = (x + y).toString()

            }else  if(resultString.contains("-")){
                var x = resultString.split("-")[0].toDouble()
                var y = resultString.split("-")[1].toDouble()

                resultString = (x - y).toString()

            }else if(resultString.contains("*")){
                var x = resultString.split("*")[0].toDouble()
                var y = resultString.split("*")[1].toDouble()

                resultString = (x * y).toString()

            }else if(resultString.contains("/")){
                var x = resultString.split("/")[0].toDouble()
                var y = resultString.split("/")[1].toDouble()

                resultString = (x / y).toString()
            }

            resultString += "-"
            UiUpdate()
        }

        plus.setOnClickListener {

            errorHandlers()

            if(resultString.contains("+")){
                var x = resultString.split("+")[0].toDouble()
                var y = resultString.split("+")[1].toDouble()

                resultString = (x + y).toString()

            }else  if(resultString.contains("-")){
                var x = resultString.split("-")[0].toDouble()
                var y = resultString.split("-")[1].toDouble()

                resultString = (x - y).toString()

            }else if(resultString.contains("*")){
                var x = resultString.split("*")[0].toDouble()
                var y = resultString.split("*")[1].toDouble()

                resultString = (x * y).toString()

            }else if(resultString.contains("/")){
                var x = resultString.split("/")[0].toDouble()
                var y = resultString.split("/")[1].toDouble()

                resultString = (x / y).toString()

            }

            resultString += "+"
            UiUpdate()
        }

        multiply.setOnClickListener {

            errorHandlers()

            if(resultString.contains("+")){
                var x = resultString.split("+")[0].toDouble()
                var y = resultString.split("+")[1].toDouble()

                resultString = (x + y).toString()

            }else  if(resultString.contains("-")){
                var x = resultString.split("-")[0].toDouble()
                var y = resultString.split("-")[1].toDouble()

                resultString = (x - y).toString()

            }else if(resultString.contains("*")){
                var x = resultString.split("*")[0].toDouble()
                var y = resultString.split("*")[1].toDouble()

                resultString = (x * y).toString()

            }else if(resultString.contains("/")){
                var x = resultString.split("/")[0].toDouble()
                var y = resultString.split("/")[1].toDouble()

                resultString = (x / y).toString()

            }

            resultString += "*"
            UiUpdate()
        }

        divide.setOnClickListener {

            errorHandlers()

            if(resultString.contains("+")){
                var x = resultString.split("+")[0].toDouble()
                var y = resultString.split("+")[1].toDouble()

                resultString = (x + y).toString()

            }else  if(resultString.contains("-")){
                var x = resultString.split("-")[0].toDouble()
                var y = resultString.split("-")[1].toDouble()

                resultString = (x - y).toString()

            }else if(resultString.contains("*")){
                var x = resultString.split("*")[0].toDouble()
                var y = resultString.split("*")[1].toDouble()

                resultString = (x * y).toString()

            }else if(resultString.contains("/")){
                var x = resultString.split("/")[0].toDouble()
                var y = resultString.split("/")[1].toDouble()

                resultString = (x / y).toString()

            }

            resultString += "/"
            UiUpdate()
        }


        result.setOnClickListener {

            if( resultString[resultString.length - 1].toString() == "+" || resultString[resultString.length - 1].toString() == "-" || resultString[resultString.length - 1].toString() == "/" || resultString[resultString.length - 1].toString() == "*") {

            }
            else
            {

                if (resultString.contains("+")) {
                    var x = resultString.split("+")[0].toDouble()
                    var y = resultString.split("+")[1].toDouble()

                    resultString = (x + y).toString()

                } else if (resultString.contains("-")) {
                    var x = resultString.split("-")[0].toDouble()
                    var y = resultString.split("-")[1].toDouble()

                    resultString = (x - y).toString()

                } else if (resultString.contains("*")) {
                    var x = resultString.split("*")[0].toDouble()
                    var y = resultString.split("*")[1].toDouble()

                    resultString = (x * y).toString()

                } else if (resultString.contains("/")) {
                    var x = resultString.split("/")[0].toDouble()
                    var y = resultString.split("/")[1].toDouble()

                    resultString = (x / y).toString()

                }
            }
            UiUpdate()
        }

        clear.setOnClickListener {
            clearOneLetter()

            if(resultString.length <= 0){
                resultString = "0"
            }

            UiUpdate()
        }
    }

    fun  UiUpdate (){
        textView.text = resultString
    }

    fun clearOneLetter (){
        var temp_result = ""
        var temp_i = 0

        for (c in resultString){
            temp_i++
            if(temp_i != resultString.length) {
                temp_result += c
            }
        }

        resultString = temp_result
    }

    fun  errorHandlers (){
        if( resultString[resultString.length - 1].toString() == "+" || resultString[resultString.length - 1].toString() == "-" || resultString[resultString.length - 1].toString() == "/" || resultString[resultString.length - 1].toString() == "*"){
            clearOneLetter()
            UiUpdate()
        }
    }

    fun zeroErrorHandler (){
        if(resultString[0].toString() == "0") {
            resultString = ""
        }
    }
}
