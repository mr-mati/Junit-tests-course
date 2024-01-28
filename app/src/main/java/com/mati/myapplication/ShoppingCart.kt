package com.mati.myapplication

class ShoppingCart {

    private val item = mutableListOf<Product>()

    fun addProduct(product: Product, quantity: Int) {
        if (quantity < 0)
        {
            throw IllegalAccessException("Error")
        }

        repeat(quantity) {
            item.add(product)
        }
    }

    fun getTotalCost(): Double {
        return item.sumOf { it.price }
    }

}