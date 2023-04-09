package com.colddelight.android_skill.di


import com.colddelight.data.remote.dataSource.CharacterDataSource
import com.colddelight.data.remote.dataSourceImpl.CharacterDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideCharacterDataSource(
        retrofit: Retrofit
    ): CharacterDataSource {
        return CharacterDataSourceImpl(retrofit)
    }
}