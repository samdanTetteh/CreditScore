package com.ijikod.mycreditscore.di

import com.ijikod.data.GetCreditScoreRepositoryImpl
import com.ijikod.data.api.CreditScoreApi
import com.ijikod.domain.repository.GetCreditScoreRepository
import com.ijikod.mycreditscore.BuildConfig
import com.ijikod.mycreditscore.common.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = BASE_URL

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor  = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()


    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): CreditScoreApi = retrofit.create(CreditScoreApi::class.java)

    @Provides
    @Singleton
    fun provideCreditScoreRepository(getCreditScoreRepositoryImpl: GetCreditScoreRepositoryImpl):
            GetCreditScoreRepository = getCreditScoreRepositoryImpl

}