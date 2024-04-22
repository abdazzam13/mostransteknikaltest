package com.example.mostransteknikaltest.retrofit

import com.example.mostransteknikaltest.model.CharacterResponse
import com.example.mostransteknikaltest.model.LocationResponse
import retrofit2.Call
import retrofit2.http.*

interface APIRouteServices {
    @GET("character")
    fun getCharacter() : Call<CharacterResponse>

    @GET("location")
    fun getLocation() : Call<LocationResponse>

    @GET("character/{id}")
    fun getCharacterById(@Path("id") id: Int) : Call<CharacterResponse>

}