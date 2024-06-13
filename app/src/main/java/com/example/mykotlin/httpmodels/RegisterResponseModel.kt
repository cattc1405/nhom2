package com.example.mykotlin.httpmodels

import com.fasterxml.jackson.annotation.JsonProperty

// tra ve sau khi dang ky
data class RegisterResponseModel(
    @JsonProperty("status") val status: Boolean,
)
