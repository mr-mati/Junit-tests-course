package com.mati.myapplication

import assertk.assertFailure
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ShoppingCartTest {

    lateinit var cart: ShoppingCart


    @BeforeEach
    fun startUp() {

        cart = ShoppingCart()

    }


    @ParameterizedTest
    @ValueSource(

        ints = [1, 2, 3, 4, 5]

    )
    fun `add multiple product, total price sum is correct`(quantity: Int) {
        val product = Product(
            id = 0,
            name = "ice cream",
            price = 5.0
        )
        cart.addProduct(product, quantity)


        //Action
        val priceSum = cart.getTotalCost()

        //Assertion
        assertThat(priceSum).isEqualTo(quantity * 5.0)

    }

    @RepeatedTest(10)
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