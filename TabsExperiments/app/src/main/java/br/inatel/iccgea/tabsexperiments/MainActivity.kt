package br.inatel.iccgea.tabsexperiments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import br.inatel.iccgea.tabsexperiments.fragments.TabFragment1
import br.inatel.iccgea.tabsexperiments.fragments.TabFragment2
import br.inatel.iccgea.tabsexperiments.fragments.TabFragment3
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        tab_layout.addTab(tab_layout.newTab().setText(R.string.label_fragment1))
        tab_layout.addTab(tab_layout.newTab().setText(R.string.label_fragment2))
        tab_layout.addTab(tab_layout.newTab().setText(R.string.label_fragment3))

        tab_layout.tabGravity = TabLayout.GRAVITY_FILL

        val pagerAdapter = PagerAdapter(supportFragmentManager, tab_layout.tabCount)
        pager.adapter = pagerAdapter
        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                pager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }

        })

    }


    class PagerAdapter(fm: FragmentManager, numberTabs: Int) : FragmentStatePagerAdapter(fm) {
        private val qtdTabs = numberTabs

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> TabFragment1()
                1 -> TabFragment2()
                2 -> TabFragment3()
                else -> TabFragment1()
            }
        }

        override fun getCount(): Int {
            return qtdTabs
        }
    }
}
