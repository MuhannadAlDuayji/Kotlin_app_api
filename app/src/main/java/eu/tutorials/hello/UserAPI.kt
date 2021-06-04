package eu.tutorials.hello



import dagger.Provides
import retrofit2.Call
import retrofit2.http.GET

interface UserAPI {


    @GET("/api/users")
    fun  getUser(): Call<UserData>


}