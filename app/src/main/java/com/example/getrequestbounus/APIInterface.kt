package com.example.getrequestbounus

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("people/")
    fun getUsers() : Call<ArrayList<PeopleItem>>
}