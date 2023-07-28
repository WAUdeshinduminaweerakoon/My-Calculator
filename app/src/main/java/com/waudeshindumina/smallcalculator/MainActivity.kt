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

    fun inOperatorAdd(): Boolean {

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
        if(!inOperatorAdd()&& numberType || !programmeStarted){
            InputText.append((view as Button).text)
            decimalPoint = false
            numberType = false
            programmeStarted = true
        }
    }

}












