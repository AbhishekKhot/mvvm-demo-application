package com.example.movieapp.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.models.ShowsData
import com.example.movieapp.repository.ShowsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(private val repository: ShowsRepository): ViewModel() {
    private val _response = MutableLiveData<List<ShowsData>>()
    val showResponse: LiveData<List<ShowsData>>
        get() = _response

    init {
        getAllTvShows()
    }

    private fun getAllTvShows() = viewModelScope.launch {
        repository.shows().let { response ->
            if(response.isSuccessful){
                _response.postValue(response.body())
            }else{
                Log.e("tag","Error occurred: ${response.message()}")
            }
        }
    }

}