package com.example.mykotlin.model

import com.example.mykotlin.httpmodels.ProductModel

data class Cart(
    val product: ProductModel,
    val quantity: Int
)
