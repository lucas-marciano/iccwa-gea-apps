package br.inatel.iccgea.scorekeeper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AppCompatDelegate
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val SCORE_1: String = "score_1"
    private val SCORE_2: String = "score_2"

    private var value1: String = "0"
    private var value2: String = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            tv_points_team_1.text = savedInstanceState.getString(SCORE_1)
            tv_points_team_2.text = savedInstanceState.getString(SCORE_2)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO)
            menu?.findItem(R.id.night_mode)?.title = resources.getString(R.string.night_mode)
        else
            menu?.findItem(R.id.night_mode)?.title = resources.getString(R.string.day_mode)

        return true
    }


    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putString(SCORE_1, value1)
        outState?.putString(SCORE_2, value2)

        super.onSaveInstanceState(outState)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val appDelegate: Int = AppCompatDelegate.getDefaultNightMode()
        when (item?.itemId) {
            R.id.night_mode -> {
                if (appDelegate == AppCompatDelegate.MODE_NIGHT_YES)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                else
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else -> return super.onOptionsItemSelected(item)

        }
        recreate()
        return true

    }


    fun increaseScore(view: View) {
        when (view.id) {
            R.id.bt_plus_team_1 -> {
                val value = tv_points_team_1.text.toString().toInt() + 1
                tv_points_team_1.text = value.toString()
                value1 = value.toString()
            }
            R.id.bt_plus_team_2 -> {
                val value = tv_points_team_2.text.toString().toInt() + 1
                tv_points_team_2.text = value.toString()
                value2 = value.toString()
            }
        }
    }

    fun decreaseScore(view: View) {
        when (view.id) {
            R.id.bt_minus_team_1 -> {
                val value = tv_points_team_1.text.toString().toInt() - 1
                tv_points_team_1.text = value.toString()
                value1 = value.toString()
            }
            R.id.bt_minus_team_2 -> {
                val value = tv_points_team_2.text.toString().toInt() - 1
                tv_points_team_2.text = value.toString()
                value2 = value.toString()
            }
        }
    }
}
