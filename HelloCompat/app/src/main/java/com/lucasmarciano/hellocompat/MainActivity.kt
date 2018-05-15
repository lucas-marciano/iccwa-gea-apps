package com.lucasmarciano.hellocompat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.content.ContextCompat
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val listaCores = arrayOf("yellow", "fuchsia", "red", "silver", "gray", "olive", "purple", "maroon", "aqua", "lime")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState.let {
            if (it != null) {
                tv_hello_world.setTextColor(resources.getColor(it.getInt("color")))
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putInt("color", tv_hello_world.currentTextColor)
    }

    fun changeColor(view: View){
        val random: Random = Random()
        val color: String = listaCores[random.nextInt(10)]
        val colorResourseName: Int = resources.getIdentifier(color, "color", application.packageName)
        val colorRes: Int = ContextCompat.getColor(this, colorResourseName)

        tv_hello_world.setTextColor(colorRes)
    }
}
