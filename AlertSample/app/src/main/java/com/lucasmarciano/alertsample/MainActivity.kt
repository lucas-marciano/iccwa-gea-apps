package com.lucasmarciano.alertsample

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showAlert(view: View){
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle(R.string.alert_title_alert)
        alertDialog.setMessage(R.string.alert_message_alert)


        // Variáveis não utilizadas dentro da expressão podem ser substituídas por _
        alertDialog.setPositiveButton(R.string.alert_ok, {
            _: DialogInterface, _: Int -> Toast.makeText(this, R.string.alert_ok_message, Toast.LENGTH_LONG).show()
        })

        // Não se faz necessário setar o tipo da váriavel, no caso DialogInterface e Int
        alertDialog.setNeutralButton(R.string.alert_neutral, {
            dialog, which -> Toast.makeText(this, "Neutral clicked", Toast.LENGTH_LONG).show()
        })

        // Chamada normal mostrando o nome dos parametros e o tipo
        alertDialog.setNegativeButton(R.string.alert_cancel, {
            dialog: DialogInterface, which: Int -> Toast.makeText(this, R.string.alert_cancel_message, Toast.LENGTH_LONG).show()
        })
        alertDialog.show()
    }
}
