package com.example.velina_v1.domain.useCase.store.store

import com.example.velina_v1.domain.useCase.DataStoreRepositoryGetValueUseCase
import javax.inject.Inject


class IsOnboardingPassedGetUseCase @Inject constructor(
    private val dataStoreRepositoryGetValueUseCase: DataStoreRepositoryGetValueUseCase
) {
    suspend operator fun invoke(): Boolean {
        return dataStoreRepositoryGetValueUseCase(DataStoreKeys.isOnboardingPassed) ?: false
    }
}