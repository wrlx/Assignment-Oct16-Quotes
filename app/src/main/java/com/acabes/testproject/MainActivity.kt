package com.acabes.testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteApi = RetrofitHelper.getInstance().create(ApiFetchable::class.java)
        GlobalScope.launch {
            val result = quoteApi.getData()
            if(result != null) {
                Log.d("ayush : ", result.body().toString())
            }
        }
    }
}