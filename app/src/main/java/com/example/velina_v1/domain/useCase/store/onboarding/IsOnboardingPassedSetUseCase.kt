package com.example.velina_v1.domain.useCase.store.onboarding

import com.example.velina_v1.domain.useCase.DataStoreRepositorySetValueUseCase

class IsOnboardingPassedSetUseCase(
    private val dataStoreRepositorySetValueUseCase: DataStoreRepositorySetValueUseCase) {
    suspend fun invoke(value: Boolean) {
        dataStoreRepositorySetValueUseCase(DataStoreKeys.isOnboardingPassed, true)
    }
}