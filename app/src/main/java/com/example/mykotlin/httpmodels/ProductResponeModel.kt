package com.example.mykotlin.httpmodels

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductModel(
    @JsonProperty("_id") val _id: String?,
    @JsonProperty("name") val name: String?,
    @JsonProperty("description") val description: String?,
    @JsonProperty("image") val image: String?,
    @JsonProperty("rating") val rating: Float?,
    @JsonProperty("voting") val voting: Int?,
    @JsonProperty("category") val category: String?,
    @JsonProperty("price") val price: Float?
    )

data class ProductResponeModel(
    @JsonProperty("status") val status: Boolean,
    @JsonProperty("products") val products: List<ProductModel>,
)
