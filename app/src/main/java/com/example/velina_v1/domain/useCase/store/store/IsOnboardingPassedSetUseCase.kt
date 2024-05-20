package com.example.velina_v1.domain.useCase.store.store

import com.example.velina_v1.domain.useCase.DataStoreRepositorySetValueUseCase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject


class IsOnboardingPassedSetUseCase @Inject constructor(
    private val dataStoreRepositorySetValueUseCase: DataStoreRepositorySetValueUseCase
) {
    suspend operator fun invoke(key: String) {
        return dataStoreRepositorySetValueUseCase(key, true)
    }
}