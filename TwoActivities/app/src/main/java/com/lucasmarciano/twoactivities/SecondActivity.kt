package com.lucasmarciano.twoactivities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object {
        fun EXTRA_REPLY() : String = "com.lucasmarciano.twoactivities.extra.REPLY"
        fun LOG_TAG(): String = "SecondActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        text_message.text = intent.getStringExtra(MainActivity.EXTRA_MESSAGE())
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG(), "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG(), "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG(), "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG(), "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG(), "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG(), "onDestroy")
    }

    fun sendReply(view: View){
        var mensagem = editText_second.text
        if(mensagem.toString().trim() != "") {
            val replyIntent = Intent()
            replyIntent.putExtra(EXTRA_REPLY(), mensagem.toString())
            setResult(RESULT_OK, replyIntent)
            Log.d(LOG_TAG(), "End SecondActivity")
            finish()
        }else{
            Toast.makeText(this, "Fill the field before to push this button.", Toast.LENGTH_LONG).show()
        }
    }
}
