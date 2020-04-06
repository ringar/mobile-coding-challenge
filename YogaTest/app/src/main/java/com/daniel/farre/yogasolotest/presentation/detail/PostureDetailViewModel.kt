package com.daniel.farre.yogasolotest.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniel.farre.yogasolotest.domain.Posture
import com.daniel.farre.yogasolotest.domain.PosturesService
import kotlinx.coroutines.launch

class PostureDetailViewModel(private val posturesService: PosturesService) : ViewModel() {

    private val posturePrivate: MutableLiveData<Posture> = MutableLiveData()
    val posture: LiveData<Posture> = posturePrivate

    private val errorsPrivate: MutableLiveData<Throwable> = MutableLiveData()
    val errors: LiveData<Throwable> = errorsPrivate

    fun getPostureDetail(id: String){
        viewModelScope.launch {
            runCatching {
                posturePrivate.postValue(posturesService.getPostureDetail(id))
            }.getOrElse {
                errorsPrivate.value = it
            }
        }
    }
}