package com.wtech.quotesapp

import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class RequestManager(appContext:Context) {
    val retrofit=Retrofit.Builder()
        .baseUrl("https://type.fit/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun GetAllQuotes(listener: QuotesResponseListener) {
        val call=retrofit.create(callQuotes::class.java).callQuotes()
        call
            .enqueue(object :Callback<List<QuotesResponse>>{
                override fun onResponse(
                    call: Call<List<QuotesResponse>>,
                    response: Response<List<QuotesResponse>>,
                ) {
                    if(!response.isSuccessful){
                        listener.didError(response.message())
                    }
                    response.body()?.let { listener.didAfetch(it,response.message()) }
                }

                override fun onFailure(call: Call<List<QuotesResponse>>, t: Throwable) {
                    t.message?.let { listener.didError(it) }
                }

            })
    }

    private interface  callQuotes{
        @GET("api/quotes")
        fun callQuotes():Call<List<QuotesResponse>>

    }

}