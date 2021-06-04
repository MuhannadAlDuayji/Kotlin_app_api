package eu.tutorials.hello

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


const val BASE_URL ="https://reqres.in/"

@Module
@InstallIn(SingletonComponent::class)
object RetrofiData {

    @Singleton
    @Provides
    fun conectR  (): UserAPI = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserAPI::class.java)

    @Singleton
    @Provides
    fun gerRepsrotery(api: UserAPI):Repsrotery{
        return Repsrotery(api)
    }


}