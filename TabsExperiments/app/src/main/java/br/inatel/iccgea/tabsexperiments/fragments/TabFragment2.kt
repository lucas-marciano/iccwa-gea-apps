package br.inatel.iccgea.tabsexperiments.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.inatel.iccgea.tabsexperiments.R

/**
 * A simple [Fragment] subclass.
 *
 */
class TabFragment2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.tab_fragment2, container, false)
    }


}
