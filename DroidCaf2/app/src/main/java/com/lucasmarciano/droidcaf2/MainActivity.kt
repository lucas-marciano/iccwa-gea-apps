package com.lucasmarciano.droidcaf2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = Uri.parse(resources.getString(R.string.resource_coord))
            if(intent.resolveActivity(packageManager) != null)
                startActivity(intent)
        }
    }

    fun selectedIceCream(view: View) {
        showToast(resources.getString(R.string.icecream_order_message))
        openActivity()
    }

    fun selectedFroyo(view: View) {
        showToast(resources.getString(R.string.froyo_order_message))
        openActivity()
    }

    fun selectedDonnut(view: View) {
        showToast(resources.getString(R.string.donnut_order_message))
        openActivity()
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun openActivity(){
        val intent = Intent(this, OrderActivity::class.java)
        startActivity(intent)
    }

    fun showSnackbar(message: String){
        Snackbar.make(main_container, message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_add_car -> {
                showSnackbar("Add car")
                true
            }
            R.id.action_status -> {
                showSnackbar("Status")
                true
            }
            R.id.action_favorities -> {
                showSnackbar("Favorities")
                true
            }
            R.id.action_contact -> {
                showSnackbar("Contact")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
