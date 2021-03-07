package com.amercosovic.glassdoorapp.retrofit

import com.amercosovic.glassdoorapp.model.Company
import retrofit2.http.GET

// interface to make api call with suspend fun
interface ApiInterface {
    // function to fetch companies
    @GET("feed-json-sample/master/feed.json")
    suspend fun getCompanies(
    ): Company
}