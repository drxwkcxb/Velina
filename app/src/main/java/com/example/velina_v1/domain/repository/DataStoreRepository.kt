package com.example.velina_v1.domain.repository

interface DataStoreRepository {
     suspend fun setValue(key: String, value: Boolean)

     suspend fun getValue(key: String): Boolean?
}