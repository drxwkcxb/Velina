package com.example.velina_v1.domain.useCase

import com.example.velina_v1.domain.repository.DataStoreRepository

class DataStoreRepositorySetValueUseCase(private val repository: DataStoreRepository) {
    suspend operator fun invoke(key: String, value: Boolean) {
        repository.setValue(key, value)
    }

}