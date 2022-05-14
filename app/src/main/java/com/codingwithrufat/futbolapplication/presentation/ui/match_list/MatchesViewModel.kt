package com.codingwithrufat.futbolapplication.presentation.ui.match_list

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithrufat.futbolapplication.network.match_list_model.DataItem
import com.codingwithrufat.futbolapplication.repository.MatchListRepository_Impl
import com.codingwithrufat.futbolapplication.util.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchesViewModel
    @Inject constructor(private val matchListRepository_Impl: MatchListRepository_Impl)
    : ViewModel() {

    val data = MutableLiveData<List<DataItem?>>()
    val loading = MutableLiveData<Boolean>()

    val response: LiveData<List<DataItem?>>
    get() = data

    init {
        getMatchList()
    }

    private fun getMatchList() = viewModelScope.launch {
        matchListRepository_Impl.getMatches(8, 2021).let {
            Log.d(TAG, "getMatchList: Bura")
            if (it.isSuccessful){
                Log.d(TAG, "getMatchList: Sonra")
                data.postValue(it.body()?.data!!)
                loading.value = false
            }else {
                Log.d(TAG, "getMatchList: ${it.errorBody()}")
            }
        }
    }

}