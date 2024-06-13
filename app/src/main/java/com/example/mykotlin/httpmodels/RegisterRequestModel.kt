package com.example.mykotlin.httpmodels

import com.fasterxml.jackson.annotation.JsonProperty

//gui di khi dang ky
data class RegisterRequestModel(
    //gui di dung theo api
    @JsonProperty("name") val name: String,
    @JsonProperty("email") val email: String,
    @JsonProperty("password") val password: String,
)
