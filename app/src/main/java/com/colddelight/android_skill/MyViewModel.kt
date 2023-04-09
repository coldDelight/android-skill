package com.colddelight.android_skill

import androidx.lifecycle.viewModelScope
import com.colddelight.android_skill.base.BaseViewModel
import com.colddelight.domain.model.DomainCharacterInfo
import com.colddelight.domain.usecase.CharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val useCase: CharacterUseCase
) : BaseViewModel() {
    private val _characterState: MutableStateFlow<List<DomainCharacterInfo>?> = MutableStateFlow(null)
    val characterState: StateFlow<List<DomainCharacterInfo>?> = _characterState

    init {
        getMyCharacter()
    }

    private fun getMyCharacter(){
        viewModelScope.launch (exceptionHandler){
            _characterState.value = useCase.getMyCharacter()
        }
    }
}