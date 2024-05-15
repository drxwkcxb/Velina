package com.example.velina_v1.domain.useCase

import com.example.velina_v1.domain.repository.DataStoreRepository

class DataStoreRepositoryGetValueUseCase(private val repository: DataStoreRepository) {
    suspend operator fun invoke(key: String): Boolean? {
        return repository.getValue(key)
    }
}