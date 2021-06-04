package eu.tutorials.hello


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.NonCancellable.join

import java.lang.Thread.sleep


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    /*@Inject
    lateinit var cone:UserAPI*/




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("Tag M","Start MainAct ")
        lateinit var ggg:Any
        var opo=this

                var mo: modelview = ViewModelProvider(this).get(modelview::class.java)

//                var g = lifecycleScope.launch {
                    mo.fitchData(
                            //fun return
                            { -> Unit
                        if(true) {
                            Log.d("Tag M","Data not Null")
                            var op = mo.getData()

                                Toast.makeText(opo, "${op == null} null", Toast.LENGTH_LONG).show()

                            var string: String = "Hi"
                            if (op != null) {
                                string = op!!.data[0].first_name

                                    Toast.makeText(opo, "not null", Toast.LENGTH_LONG).show()

                                Log.d("Tag M","Data not Null  ${op.data[0].first_name}")
                            } else{
                                Log.d("Tag M","Data  Null for UserData ")
                            }

                                Toast.makeText(opo, "isCompleted", Toast.LENGTH_LONG).show()
                                Toast.makeText(opo, "Fitch done  $string", Toast.LENGTH_LONG).show()

                            rvUsersList.layoutManager = LinearLayoutManager(this)
                            try {
                                var itemAdapter = UserAdapter(this, mo.getData()!!.data.toTypedArray())
                                 rvUsersList.adapter = itemAdapter
                            } catch (e: Exception) {

                                    Toast.makeText(opo, "Error after recycler view", Toast.LENGTH_LONG).show()
                                    // rvUsersList.adapter = itemAdapter

                            }

                        } else {
                            Log.d("Tag M","Data  Null")

                                Toast.makeText(opo, "Error happen", Toast.LENGTH_LONG).show()

                        }
                    })

//                }
               /* runBlocking {
                   ggg= g.join()
                }*/

                Log.d("Tag M","After Corotines ")

                
                lateinit var itemAdapter: UserAdapter


    }

    fun finshData():Unit {

    }
}


