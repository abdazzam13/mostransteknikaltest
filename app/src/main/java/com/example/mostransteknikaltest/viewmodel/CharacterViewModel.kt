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
    val characterDetail = MutableLiveData<Character>()
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
                                    list.add(Character(character.id!!, character.name!!,character.species!!, character.gender!!, character.image!!, character.location!!.name!!))
                                }
                            }
                        }
                        characterList.postValue(list)

                    }
                }
            }
            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Log.e("CharacterViewModel", "onFailure: ${t.message}")
            }
        })
    }
    fun getCharacterById(id: Int){
        Log.d("EXTRAID", id.toString())
        val client = APIConfiguration.getAPIServices().getCharacterById(id)
        Log.d("EXTRA", client.request().url.toString())
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
                                    characterDetail.postValue(Character(character.id!!, character.name!!,character.species!!, character.gender!!, character.image!!, character.location!!.name!!))
                                }
                            }
                        }
                    }
                }
            }
            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Log.e("CharacterViewModel", "onFailure: ${t.message}")
            }
        })
    }

    fun getCharacters(): LiveData<ArrayList<Character>> {
        return characterList
    }
    fun getCharactersById(): LiveData<Character> {
        return characterDetail
    }

}