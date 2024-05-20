package com.example.velina_v1.domain.useCase.store.store

import com.example.velina_v1.domain.useCase.DataStoreRepositoryGetValueUseCase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject


class IsOnboardingPassedGetUseCase @Inject constructor(
    private val dataStoreRepositoryGetValueUseCase: DataStoreRepositoryGetValueUseCase
) {
    suspend operator fun invoke(key: String): Boolean? {
        return dataStoreRepositoryGetValueUseCase(key)
    }
}