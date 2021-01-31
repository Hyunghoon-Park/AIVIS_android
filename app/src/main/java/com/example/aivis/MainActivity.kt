package com.example.aivis

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.File
import java.net.Socket

class MainActivity : AppCompatActivity() {

    private val TAG = "TAG"
    val IP = "192.168.137.1"
    val port = 8888
    var ID = ""
    var PW = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ActivityCompat.requestPermissions(this,  arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
        login.setOnClickListener { view ->
            ID = editText.text.toString()    //로그인창에있는 string 받아옴
            PW = editText2.text.toString()    //비밀번호창에있는 string 받아옴
            var tmp : String = "";
            Thread(Runnable{
                lateinit var socket : Socket
                var dos: DataOutputStream? = null
                var dis: DataInputStream? = null
                socket = Socket(IP, port)
                try {
                    println("Try to Connect Server...")
                    dos = DataOutputStream(socket.getOutputStream())
                    dis = DataInputStream(socket.getInputStream())
                    println("Connect success")
                    dos!!.writeUTF("login")
                    dos!!.writeUTF(ID)
                    dos!!.flush()
                    dos!!.writeUTF(PW)
                    dos!!.flush()
                    tmp = dis!!.readUTF()     //성공시 valid 실패면 failed
                    socket.close()
                } catch (e: Exception) {
                    println("socket error occure")
                    e.printStackTrace()
                }
            }).start()
            if(tmp == "valid") {
                var intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }
        }

    }
}