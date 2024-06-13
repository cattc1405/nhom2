package com.example.mykotlin.httpmodels

import com.fasterxml.jackson.annotation.JsonProperty

data class UserModel(
    @JsonProperty("_id") val _id: String?,
    @JsonProperty("name") val name: String?,
    @JsonProperty("email") val email: String?,
    @JsonProperty("carts") val carts: Any?,
    @JsonProperty("__v") val __v: Int?,
)

data class LoginResponseModel(
    @JsonProperty("status") val status: Boolean?,
    @JsonProperty("user") val user: UserModel?,
)
