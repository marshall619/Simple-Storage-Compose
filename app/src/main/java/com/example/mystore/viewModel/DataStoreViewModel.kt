package com.example.mystore.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystore.data.dataStore.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class DataStoreViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel(){

    companion object {
        const val USERNAME_KEY = "USERNAME_KEY"
        const val PASSWORD_KEY = "PASSWORD_KEY"
        const val LAUNCH_KEY = "LAUNCH_KEY"
        const val PHOTO_INDEX = "PHOTO_INDEX"
    }

    fun setUserName(value : String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.putString(USERNAME_KEY , value)
        }
    }

    fun getUserName() : String? = runBlocking {
        repository.getString(USERNAME_KEY)
    }

    fun setUserPassword(value : String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.putString(PASSWORD_KEY , value)
        }
    }

    fun getUserPassword() : String? = runBlocking {
        repository.getString(PASSWORD_KEY)
    }

    fun setLaunchState(value : Int){
        viewModelScope.launch(Dispatchers.IO) {
            repository.putInt(LAUNCH_KEY , value)
        }
    }

    fun getLaunchState() : Int? = runBlocking {
        repository.getInt(LAUNCH_KEY) ?: 0
    }

    fun setPhotoIndex(value : Int){
        viewModelScope.launch(Dispatchers.IO) {
            repository.putInt(LAUNCH_KEY , value)
        }
    }

    fun getPhotoIndex() : Int? = runBlocking {
        repository.getInt(LAUNCH_KEY) ?: 0
    }

}