package com.daniel.farre.yogasolotest.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniel.farre.yogasolotest.domain.Posture
import com.daniel.farre.yogasolotest.domain.PosturesService
import kotlinx.coroutines.launch

class PosturesViewModel(private val posturesService: PosturesService) : ViewModel() {

    private val posturesPrivate: MutableLiveData<List<Posture>> = MutableLiveData()
    val postures: LiveData<List<Posture>> = posturesPrivate

    private val errorsPrivate: MutableLiveData<Throwable> = MutableLiveData()
    val errors: LiveData<Throwable> = errorsPrivate

    fun getPostures(){
        viewModelScope.launch {
            runCatching {
                posturesPrivate.postValue(posturesService.getPostures())
            }.getOrElse {
                errorsPrivate.value = it
            }
        }
    }
}