package com.mati.myapplication

import assertk.assertFailure
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class ShoppingCartTest {

    lateinit var cart: ShoppingCart


    @BeforeEach
    fun startUp() {

        cart = ShoppingCart()

    }


    @Test
    fun `add multiple product, total price sum is correct`() {
        val product = Product(
            id = 0,
            name = "ice cream",
            price = 5.0
        )
        cart.addProduct(product, 3)


        //Action
        val priceSum = cart.getTotalCost()

        //Assertion
        assertThat(priceSum).isEqualTo(15.0)

    }

    @RepeatedTest(1000)
    fun `add product with negative quantity, throws Exception`() {
        val product = Product(
            id = 0,
            name = "ice cream",
            price = 5.0
        )

        assertFailure {
            cart.addProduct(product, -5)
        }

    }

}