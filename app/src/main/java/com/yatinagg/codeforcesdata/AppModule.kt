package com.yatinagg.codeforcesdata

import com.yatinagg.codeforcesdata.model.RetrofitService
import com.yatinagg.codeforcesdata.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideSubmissionRepository(): MainRepository =
        MainRepository(RetrofitService.getInstance())
}