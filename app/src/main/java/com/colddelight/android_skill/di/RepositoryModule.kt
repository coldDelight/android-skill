package com.colddelight.android_skill.di

import com.colddelight.data.local.LocalDatabase
import com.colddelight.data.remote.dataSource.CharacterDataSource
import com.colddelight.data.repositoryImpl.CharacterRepositoryImpl
import com.colddelight.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideCharacterRepository(api: CharacterDataSource,db: LocalDatabase): CharacterRepository{
        return CharacterRepositoryImpl(api,db.characterDao)
    }
}