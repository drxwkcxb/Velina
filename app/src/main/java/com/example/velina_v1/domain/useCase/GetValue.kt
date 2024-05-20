package com.example.velina_v1.domain.useCase

import com.example.velina_v1.domain.repository.DataStoreRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton



class DataStoreRepositoryGetValueUseCase @Inject constructor(
    private val repository: DataStoreRepository
) {
    suspend operator fun invoke(key: String): Boolean? {
        return repository.getValue(key)
    }
}