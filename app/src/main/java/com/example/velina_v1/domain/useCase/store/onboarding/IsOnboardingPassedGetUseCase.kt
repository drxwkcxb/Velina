package com.example.velina_v1.domain.useCase.store.onboarding

import androidx.compose.runtime.key
import com.example.velina_v1.domain.useCase.DataStoreRepositoryGetValueUseCase

class IsOnboardingPassedGetUseCase (
    private val dataStoreRepositoryGetValueUseCase: DataStoreRepositoryGetValueUseCase
) {
    suspend operator fun invoke(): Boolean {
        return dataStoreRepositoryGetValueUseCase(DataStoreKeys.isOnboardingPassed) ?: false
        }

}