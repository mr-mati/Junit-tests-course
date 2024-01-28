package com.mati.myapplication

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @AfterEach
    fun startUp(){

    }

    @Test
    fun addition_isCorrect() {
        assertThat(2+3).isEqualTo(5)
    }
}