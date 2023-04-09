package com.colddelight.android_skill

import androidx.lifecycle.viewModelScope
import com.colddelight.android_skill.base.BaseViewModel
import com.colddelight.domain.model.DomainCharacterInfo
import com.colddelight.domain.usecase.CharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: CharacterUseCase,
) : BaseViewModel() {

    private val _characterState: MutableStateFlow<List<DomainCharacterInfo>?> =
        MutableStateFlow(null)
    val characterState: StateFlow<List<DomainCharacterInfo>?> = _characterState

    init {
        getPage()
    }

    private fun getPage() {
        viewModelScope.launch(exceptionHandler) {
            _characterState.value = useCase.invoke()
        }
    }

    suspend fun saveCharacter(info: DomainCharacterInfo) {
        viewModelScope.launch(exceptionHandler) {
            val imageData = loadImageData(info.image!!)
            val characterInfo = DomainCharacterInfo(info.name, info.species, imageLocal = imageData)
            useCase.saveCharacter(characterInfo)
        }
    }

    private suspend fun loadImageData(url: String): ByteArray = withContext(Dispatchers.IO) {
        URL(url).readBytes()
    }
}