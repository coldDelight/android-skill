package com.colddelight.android_skill.base

import androidx.lifecycle.ViewModel
import com.colddelight.android_skill.FetchState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.HttpException
import java.net.SocketException
import java.net.UnknownHostException

abstract class BaseViewModel : ViewModel() {
    private val _state = MutableStateFlow<Pair<Throwable, FetchState>?>(null)
    val state: StateFlow<Pair<Throwable, FetchState>?> = _state

    protected val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
        when (throwable) {
            is SocketException -> _state.value = (Pair(throwable,FetchState.BAD_INTERNET))
            is HttpException ->_state.value = (Pair(throwable,FetchState.PARSE_ERROR))
            is UnknownHostException -> _state.value = (Pair(throwable,FetchState.WRONG_CONNECTION))
            else -> _state.value = (Pair(throwable,FetchState.FAIL))
        }
    }
}