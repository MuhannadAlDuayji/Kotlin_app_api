package eu.tutorials.hello

import android.util.Log
import dagger.Component
import dagger.Provides
import retrofit2.Call
import javax.inject.Inject


class Repsrotery  @Inject constructor(var api: UserAPI) {

     fun getUser(): Call<UserData> {
        Log.d("Tag ConectR","in Repsrotery")
       return api.getUser()
    }
}