package com.example.getrequestbounus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val user:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var text=findViewById<TextView>(R.id.textView2)
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)



        apiInterface!!.getUsers().enqueue(object:Callback<ArrayList<PeopleItem>>{

                override fun onFailure(call: Call<ArrayList<PeopleItem>>, t: Throwable) {
                                call.cancel()
                           }
            override fun onResponse(
                call: Call<ArrayList<PeopleItem>>,
                response: Response<ArrayList<PeopleItem>>
            ) {
                val list = response.body()!!

                var users=""
                var number =0
                for(user in list){
                       number =number+1
                      val user = "${number} - ${user.name}\n"
                      users+=user
               }
                println(users)
                text.text = "$users"

                }
            })




    }


}