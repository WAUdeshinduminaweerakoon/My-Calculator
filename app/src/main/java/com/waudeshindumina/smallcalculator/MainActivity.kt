package com.waudeshindumina.smallcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var decimalPoint = false
    private var numberType = false
    private var programmeStarted = false
    private var startedMinus =false
    var inPressedEqual = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickDigit(view: View) {
        InputText.append((view as Button).text)
        numberType = true

    }
    fun onClear(view: View){
        InputText.text = ""

    }
    fun DecimalPoint(view :View){
        if(!decimalPoint){
            InputText.append((view as Button).text)
            decimalPoint = true
        }
    }

    fun isOperatorAdd(): Boolean {

        var inputTextTyped = InputText.text.toString()

        var minuses = inputTextTyped.split("-")//97-78

        startedMinus = minuses.size <3


        return if(inputTextTyped.startsWith("-") && startedMinus){
            false
        }else{
            (inputTextTyped.contains("-") || inputTextTyped.contains("+")||
                    inputTextTyped.contains("*")|| inputTextTyped.contains("/"))
        }

    }

    fun onOperator(view: View){
        if(!isOperatorAdd()&& numberType || !programmeStarted){
            InputText.append((view as Button).text)
            decimalPoint = false
            numberType = false
            programmeStarted = true
        }
    }

    fun onEqual(view: View) {

        if(numberType){
            var inputTextView = InputText.text.toString()

            var prefix = ""
            try {
                if(inputTextView.startsWith("-")){
                    prefix = "-"
                        inputTextView =inputTextView.substring(1)
                    }

                if(inputTextView.contains("-")){
                    var splitValues = inputTextView.split("-")

                    var one = splitValues[0]
                    var two = splitValues[1]

                    if(prefix.isNotEmpty()){
                        one = prefix +one
                    }

                    InputText.text=(one.toDouble()-two.toDouble()).toString()
                }

                if(inputTextView.contains("+")){
                    var splitValues = inputTextView.split("+")

                    var one = splitValues[0]
                    var two = splitValues[1]

                    if(prefix.isNotEmpty()){
                        one = prefix +one
                    }

                    InputText.text=(one.toDouble()+ two.toDouble()).toString()
                }
                if(inputTextView.contains("*")){
                    var splitValues = inputTextView.split("*")

                    var one = splitValues[0]
                    var two = splitValues[1]

                    if(prefix.isNotEmpty()){
                        one = prefix +one
                    }

                    InputText.text=(one.toDouble()*two.toDouble()).toString()
                }

                if(inputTextView.contains("/")){
                    var splitValues = inputTextView.split("/")

                    var one = splitValues[0]
                    var two = splitValues[1]

                    if(prefix.isNotEmpty()){
                        one = prefix +one
                    }

                    InputText.text=(one.toDouble()/two.toDouble()).toString()
                }

            }catch (e:java.lang.ArithmeticException){
                e.printStackTrace()
            }
        }
    }

}












