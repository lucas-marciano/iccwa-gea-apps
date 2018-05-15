package com.lucasmarciano.simplecalc

import android.test.suitebuilder.annotation.SmallTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Before
import org.junit.Test

@RunWith(JUnit4::class)
@SmallTest
class CalculatorTest{
    private var mCalculator: Calculator? = null

    /**
     * Set up the environment for testing
     */
    @Before
    fun setUp() {
        mCalculator = Calculator()
    }

    /**
     * Test for simple addition
     */
    @Test
    fun addTwoNumbers() {
        val resultAdd = mCalculator!!.add(1.0, 1.0)
        assertThat(resultAdd, `is`(equalTo(2.0)))
//        assertThat(resultAdd, `is`(equalTo(3.0)))
    }

    @Test
    fun addTwoNumbersNegatives(){
        val resultAdd = mCalculator!!.add(-1.0, -2.0)
        assertThat(resultAdd, `is`(equalTo(-3.0)))
    }

    @Test
    fun addTwoFloatNumbers(){
        val resultAdd = mCalculator!!.add(1.111, 1.111)
        assertThat(resultAdd, `is`(equalTo(2.222)))
    }
}