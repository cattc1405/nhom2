package com.example.mykotlin.helpers

import android.util.Log
import com.example.mykotlin.httpmodels.LoginRequestModel
import com.example.mykotlin.httpmodels.LoginResponseModel
import com.example.mykotlin.httpmodels.ProductDetailReponseModel
import com.example.mykotlin.httpmodels.ProductResponeModel
import com.example.mykotlin.httpmodels.RegisterRequestModel
import com.example.mykotlin.httpmodels.RegisterResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query


class RetrofitAPI {
    private val retrofit = RetrofitClient.getClient()
    private val iRetrofit = retrofit.create(IRetrofit::class.java)

    fun register(body: RegisterRequestModel, //gui di
                 callback: (RegisterResponseModel?) -> Unit){
        iRetrofit.register(body).enqueue(
            object : Callback<RegisterResponseModel> {
                override fun onResponse(call: Call<RegisterResponseModel>,
                                        response: Response<RegisterResponseModel>) {
                    if (response.isSuccessful) {
                        val registerResponseModel = response.body()
                        Log.d("ok", registerResponseModel.toString())

                        callback(registerResponseModel)
                    } else {
                        Log.d(">>>Failed to register", response.message())
                    }
                }

                override fun onFailure(call: Call<RegisterResponseModel>, t: Throwable) {
                    Log.d("Failed to register", t.message ?: "Unknown error")
                }
            })
    }

    fun login(body: LoginRequestModel, //gui di
                 callback: (LoginResponseModel?) -> Unit){
        iRetrofit.login(body).enqueue(
            object : Callback<LoginResponseModel> {
                override fun onResponse(call: Call<LoginResponseModel>,
                                        response: Response<LoginResponseModel>) {
                    if (response.isSuccessful) {
                        val result = response.body()
                        Log.d("ok", result.toString())

                        callback(result)
                    } else {
                        Log.d(">>>Failed to login", response.message())
                    }
                }

                override fun onFailure(call: Call<LoginResponseModel>, t: Throwable) {
                    Log.d("Failed to login", t.message ?: "Unknown error")
                }
            })
    }


    fun getProductsCategoryID(query: String?,
              callback: (ProductResponeModel?) -> Unit){
        iRetrofit.getProductsCategoryID(query).enqueue(
            object : Callback<ProductResponeModel> {
                override fun onResponse(call: Call<ProductResponeModel>,
                                        response: Response<ProductResponeModel>) {
                    if (response.isSuccessful) {
                        val result = response.body()
                        Log.d("ok", result.toString())

                        callback(result)
                    } else {
                        Log.d(">>>Failed to products", response.message())
                    }
                }

                override fun onFailure(call: Call<ProductResponeModel>, t: Throwable) {
                    Log.d("Failed to products", t.message ?: "Unknown error")
                }
            })
    }

    fun getProductByID(id: String?,
                              callback: (ProductDetailReponseModel?) -> Unit){
        iRetrofit.getProductByID(id).enqueue(
            object : Callback<ProductDetailReponseModel> {
                override fun onResponse(call: Call<ProductDetailReponseModel>,
                                        response: Response<ProductDetailReponseModel>) {
                    if (response.isSuccessful) {
                        val result = response.body()
                        Log.d("ok", result.toString())

                        callback(result)
                    } else {
                        Log.d(">>>Failed to detail", response.message())
                    }
                }

                override fun onFailure(call: Call<ProductDetailReponseModel>, t: Throwable) {
                    Log.d("Failed to detail", t.message ?: "Unknown error")
                }
            })
    }
}