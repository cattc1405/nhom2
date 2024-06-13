package com.example.mykotlin.helpers

import com.example.mykotlin.httpmodels.LoginRequestModel
import com.example.mykotlin.httpmodels.LoginResponseModel
import com.example.mykotlin.httpmodels.ProductDetailReponseModel
import com.example.mykotlin.httpmodels.ProductResponeModel
import com.example.mykotlin.httpmodels.RegisterRequestModel
import com.example.mykotlin.httpmodels.RegisterResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface IRetrofit {
    //khai bao cac api o day

    // dang ky tai khoan
    @POST("users/register")
    fun register(@Body body: RegisterRequestModel) :Call<RegisterResponseModel>

    // dang nhap tai khoan
    @POST("users/login")
    fun login(@Body body: LoginRequestModel) :Call<LoginResponseModel>

    // lay danh sach san pham theo danh muc
    @GET("products")
    fun getProductsCategoryID(@Query("category") category:String?): Call<ProductResponeModel>

    // lay chi tiet san pham
    @GET("products/{id}")
    fun getProductByID(@Path("id") id: String?): Call<ProductDetailReponseModel>
}