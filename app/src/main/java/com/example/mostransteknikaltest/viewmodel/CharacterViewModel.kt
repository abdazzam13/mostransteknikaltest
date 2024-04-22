package com.example.mostransteknikaltest.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mostransteknikaltest.model.Character
import com.example.mostransteknikaltest.model.CharacterResponse
import com.example.mostransteknikaltest.retrofit.APIConfiguration
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterViewModel (application: Application): ViewModel() {
    val characterList = MutableLiveData<ArrayList<Character>>()
    private val list = ArrayList<Character>()
    val context = application

    fun getCharacter(){
        val client = APIConfiguration.getAPIServices().getCharacter()
        client.enqueue(object : Callback<CharacterResponse> {
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                if (response.isSuccessful) {
                    val resBody = response.body()
                    if (resBody !== null) {
                        val characters = resBody.results
                        if (characters != null) {
                            for (character in characters){
                                if (character != null) {
                                    list.add(Character(character.name!!,character.species!!, character.gender!!, character.image!!))
                                }
                            }
                        }
                        characterList.postValue(list)

                    }
                }
            }
            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Log.e("HistoryViewModel", "onFailure: ${t.message}")
            }
        })
    }

    fun getCharacters(): LiveData<ArrayList<Character>> {
        return characterList
    }

}