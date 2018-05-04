package com.lucasmarciano.twoactivities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    companion object {
        fun EXTRA_MESSAGE(): String = "com.lucasmarciano.twoactivities.extra.MESSAGE"
        fun TEXT_REQUEST(): Int = 1
        fun LOG_TAG(): String = "MainActivity"
        val TESTE = "uewygfwufyeguygfe"
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (text_header.visibility == View.VISIBLE){
            outState?.putBoolean("reply_visible", true)
            outState?.putString("reply_text", editText_main.text.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null){
            if(savedInstanceState.getBoolean("reply_visible")){
                text_header.visibility = View.VISIBLE
                text_reply.visibility = View.VISIBLE
                text_reply.text = savedInstanceState.getString("reply_text")
            }
        }

        Log.d(LOG_TAG(), "onCreate")
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == TEXT_REQUEST()) {
            if (resultCode == RESULT_OK) {
                text_header.visibility = View.VISIBLE
                text_reply.visibility = View.VISIBLE

                text_reply.text = data?.getStringExtra(SecondActivity.EXTRA_REPLY())
            }
        }
    }

    fun launchSecondActivity(view: View) {
        var mensagem = editText_main.text
        if (mensagem.toString().trim() != "") {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(EXTRA_MESSAGE(), mensagem.toString())
            startActivityForResult(intent, TEXT_REQUEST())
        } else {
            Toast.makeText(this, "Fill the field before to push this button.", Toast.LENGTH_LONG).show()
        }
    }
}
