package com.example.aivis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_second.*
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

class SecondActivity : AppCompatActivity() {

    //private val filepath = "sdcard/"
    private  val filepath = "/storage/emulated/0/"
    internal var myExternalFile: File?=null
    var fileName = "question.txt"
    var lineList = mutableListOf<String>()
    val INTERVIEW = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        register.setOnClickListener { view ->            var intent = Intent(this, registerIntroduce::class.java)
            startActivity(intent)
        }

        interview.setOnClickListener { view ->
            val intent = Intent(this, Interview::class.java)
            myExternalFile = File(getExternalFilesDir(filepath), fileName)

            val filename = fileName
            myExternalFile = File(filepath,filename)
            if(filename.toString()!=null && filename.toString().trim()!="") {
                var fileInputStream = FileInputStream(myExternalFile)
                var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
                var text: String? = null
                while ({ text = bufferedReader.readLine(); text }() != null) {
                    lineList.add(text.toString())
                }

                intent.putExtra("data1", lineList[0])
                intent.putExtra("data2", lineList[1])
                intent.putExtra("data3", lineList[2])
                intent.putExtra("data4", lineList[3])
                intent.putExtra("data5", lineList[4])
            }
                startActivity(intent)
        }
    }
}
