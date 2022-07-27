package com.example.compose_api.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose_api.models.AlbumModel
import com.example.compose_api.network.ApiService
import kotlinx.coroutines.launch

class AlbumViewModel : ViewModel() {

    var albumListResponse:List<AlbumModel> by mutableStateOf(listOf())
    private var errorMessage: String by mutableStateOf("")
    fun getDataList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val albumList = apiService.getData()
                albumListResponse = albumList
                println("///////////////////////////////////////////////////////////////////////////////////////// ${albumListResponse[0].thumbnailUrl}")
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}