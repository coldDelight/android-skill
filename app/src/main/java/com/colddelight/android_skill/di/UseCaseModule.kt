package com.colddelight.android_skill.di

import com.colddelight.domain.repository.CharacterRepository
import com.colddelight.domain.usecase.CharacterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideCharacterUseCase(repository: CharacterRepository): CharacterUseCase {
        return CharacterUseCase(repository)
    }
}