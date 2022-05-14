package com.codingwithrufat.futbolapplication.presentation.ui.match

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.codingwithrufat.futbolapplication.network.match_model.Data
import com.codingwithrufat.futbolapplication.repository.MatchRepository_Impl
import com.codingwithrufat.futbolapplication.util.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchDetailViewModel
@Inject constructor(
    private val matchrepositoryImpl: MatchRepository_Impl,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val data = MutableLiveData<Data?>()
    val loading = MutableLiveData<Boolean>()

    val response: LiveData<Data?>
        get() = data

    init {
        getMatch()
    }

    private fun getMatch() = viewModelScope.launch {
        matchrepositoryImpl.getMatchDetail(match_id = savedStateHandle.get<Int>("match_id")!!).let {
            if (it.isSuccessful) {
                data.postValue(it.body()?.data)
                loading.value = false
            } else {
                Log.d(TAG, "getMatch: ${it.errorBody()}")
            }
        }
    }

}