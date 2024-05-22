package com.example.velina_v1.presentation.mainActivity.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.velina_v1.domain.useCase.store.store.IsOnboardingPassedGetUseCase
import com.example.velina_v1.domain.useCase.store.store.IsOnboardingPassedSetUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val isOnboardingPassedGetUseCase: IsOnboardingPassedGetUseCase,
    private val isOnboardingPassedSetUseCase: IsOnboardingPassedSetUseCase,
) : ViewModel() {
    var isOnboardingPassed: Boolean = false
        private set

    init {
        getIsOnboardingPassedStatus()
    }

    private fun getIsOnboardingPassedStatus() {
        viewModelScope.launch {
            isOnboardingPassed = isOnboardingPassedGetUseCase()
        }
    }
}