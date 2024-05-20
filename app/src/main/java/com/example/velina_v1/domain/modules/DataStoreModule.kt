package com.example.velina_v1.domain.modules

import android.content.Context
import com.example.velina_v1.data.DataStoreRepositoryImpl
import com.example.velina_v1.domain.repository.DataStoreRepository
import com.example.velina_v1.domain.useCase.DataStoreRepositoryGetValueUseCase
import com.example.velina_v1.domain.useCase.DataStoreRepositorySetValueUseCase
import com.example.velina_v1.domain.useCase.store.store.IsOnboardingPassedGetUseCase
import com.example.velina_v1.domain.useCase.store.store.IsOnboardingPassedSetUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataStoreModule {
    @Provides
    @Singleton
    fun provideDataStoreRepository(@ApplicationContext context: Context): DataStoreRepository {
        return DataStoreRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun provideDataStoreRepositoryGetValueUseCase(
        dataStoreRepository: DataStoreRepository
    ): DataStoreRepositoryGetValueUseCase {
        return DataStoreRepositoryGetValueUseCase(dataStoreRepository)
    }

    @Provides
    @Singleton
    fun provideDataStoreRepositorySetValueUseCase(
        dataStoreRepository: DataStoreRepository
    ): DataStoreRepositorySetValueUseCase {
        return DataStoreRepositorySetValueUseCase(dataStoreRepository)
    }

    @Provides
    @Singleton
    fun provideIsOnboardingPassedGetUseCase(
        dataStoreRepositoryGetValueUseCase: DataStoreRepositoryGetValueUseCase
    ): IsOnboardingPassedGetUseCase {
        return IsOnboardingPassedGetUseCase(dataStoreRepositoryGetValueUseCase)
    }

    @Provides
    @Singleton
    fun provideIsOnboardingPassedSetUseCase(
        dataStoreRepositorySetValueUseCase: DataStoreRepositorySetValueUseCase
    ): IsOnboardingPassedSetUseCase {
        return IsOnboardingPassedSetUseCase(dataStoreRepositorySetValueUseCase)
    }

}
