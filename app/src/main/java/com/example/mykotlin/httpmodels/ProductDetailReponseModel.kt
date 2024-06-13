package com.example.mykotlin.httpmodels

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductDetailReponseModel(
    @JsonProperty("status") val status: Boolean,
    @JsonProperty("product") val product: ProductModel,
)
