package eu.tutorials.hello

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.internal.wait
import java.lang.Exception
import java.lang.Thread.sleep
import javax.inject.Inject

class modelview
@ViewModelInject constructor(var
    repsrotery: Repsrotery
) :ViewModel() {
     val _conver= MutableLiveData<UserData?>()


   fun fitchData(callback:()->Unit) {
        Log.d("Tag V", "fitchData: beffore Thread")

        var dataUser:UserData?=null
        var g=viewModelScope.launch(IO) {
            try {

                Log.d("Tag V", "fitchData: Before repsrotery")
                 dataUser = repsrotery.getUser().execute().body()
                Log.d("Tag V", "fitchData: affter repsrotery")
                withContext(Main){
                    _conver.setValue(dataUser)
                    callback()
                }
                Log.d("Tag V", "fitchData: affter post value is it null  ? --> ${(dataUser==null)} ")
                Log.d("Tag V", "fitchData: In Thread ViewModel")
                /*withContext(Dispatchers.Main){
                    //Toast(this,"")
                }*/



        if(_conver.value!=null)
            Log.d("Tag V", "fitchData in if : ${_conver.value!!.data[0].first_name}")
        else {
            //${g.isCompleted}
            Log.d("Tag V", "fitchData in else : ")


        }
            }catch (e:Exception){
                Log.d("Tag V", "dataCoro in view model error fitchData: affter ${e.message}")
                Log.d("Tag V","in modelview")}
        }
        Log.d("Tag V", "dataCoro in view model aftter ")


        /*if(g.await()){


            Log.d("ConectV2","in modelview")
        }
        Log.d("Before Completed", "fitchData: ${g.isCompleted} ")*/

    }

    fun getData():UserData?{
        return _conver.value
    }


}