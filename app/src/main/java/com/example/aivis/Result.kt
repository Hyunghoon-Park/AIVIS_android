package com.example.aivis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        setContentView(R.layout.activity_result)

        var text1 = intent.getStringExtra("result1")
        var text2 = intent.getStringExtra("result2")
        var text3 = intent.getStringExtra("result3")
        var text4 = intent.getStringExtra("result4")
        var text5 = intent.getStringExtra("result5")
        var text6 = intent.getStringExtra("result6")
        var text7 = intent.getStringExtra("result7")
        var text8 = intent.getStringExtra("result8")
        var text9 = intent.getStringExtra("result9")
        var text10 = intent.getStringExtra("result10")



        result1.append("${text1}")
        result2.append("${text3}")
        result3.append("${text5}")
        result4.append("${text7}")
        result5.append("${text9}")
        result6.append("${text2}")
        result7.append("${text4}")
        result8.append("${text6}")
        result9.append("${text8}")
        result10.append("${text10}")
    }
}
