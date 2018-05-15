package com.lucasmarciano.simplecalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.EditText





class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    var mCalculator: Calculator? = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun soma(view: View){
        compute(Calculator.Operator.ADD)
    }


    fun subitracao(view: View){
        compute(Calculator.Operator.SUB)
    }


    fun divisao(view: View){
        compute(Calculator.Operator.DIV)
    }


    fun multiplicacao(view: View){
        compute(Calculator.Operator.MUL)
    }


    private fun compute(operator: Calculator.Operator) {
        val operandOne: Double
        val operandTwo: Double
        try {
            operandOne = getOperand(number1)
            operandTwo = getOperand(number2)
        } catch (nfe: NumberFormatException) {
            Log.e(TAG, "NumberFormatException", nfe)
            tv_result.text = getString(R.string.computation_error)
            return
        }

        val result: String
        when (operator) {
            Calculator.Operator.ADD -> result = mCalculator?.add(operandOne, operandTwo).toString()
            Calculator.Operator.SUB -> result = mCalculator?.sub(operandOne, operandTwo).toString()
            Calculator.Operator.DIV -> result = mCalculator?.div(operandOne, operandTwo).toString()
            Calculator.Operator.MUL -> result = mCalculator?.mul(operandOne, operandTwo).toString()
        }
        tv_result.text = result
    }

    private fun getOperand(operandEditText: EditText): Double {
        val operandText = getOperandText(operandEditText)
        return java.lang.Double.valueOf(operandText)
    }

    private fun getOperandText(operandEditText: EditText): String {
        return operandEditText.text.toString()
    }
}
