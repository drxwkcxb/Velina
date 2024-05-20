package com.example.velina_v1.data

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.velina_v1.domain.repository.DataStoreRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map


class DataStoreRepositoryImpl ( @ApplicationContext private val context: Context) : DataStoreRepository {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("preferences")

    init {
        Log.d("test", context.dataStore.toString())
    }
    override suspend fun setValue(key: String, value: Boolean) {
        val preferencesKey = booleanPreferencesKey("key")

        context.dataStore.edit { preferences ->
            preferences[preferencesKey] = value
        }
    }

    override suspend fun getValue(key: String): Boolean? {
        val preferencesKey = booleanPreferencesKey("key")

        return context.dataStore.data.map { preferences ->
            preferences[preferencesKey] ?: false
        }.first()
    }
}