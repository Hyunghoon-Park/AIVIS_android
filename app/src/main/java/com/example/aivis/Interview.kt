package com.example.aivis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_interview.*
import java.io.*

class Interview : AppCompatActivity() {

    private  val filepathMyvideo = "/storage/emulated/0/DCIM/MyVideo"
    private  val filepath = "/storage/emulated/0/"
    internal var myExternalFile: File?=null
    var lineList = mutableListOf<String>()
    var filename = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interview)

        var data1 = intent.getStringExtra("data1")
        var data2 = intent.getStringExtra("data2")
        var data3 = intent.getStringExtra("data3")
        var data4 = intent.getStringExtra("data4")
        var data5 = intent.getStringExtra("data5")

//        question1.text = "${data1}"
//        question2.text = "${data2}"
//        question3.text = "${data3}"
//        question4.text = "${data4}"
//        question5.text = "${data5}"
        question1.text = "Please introduce your development experience."
        question2.text = "Please explain the advantages of modularization."
        question3.text = "Please explain what kind of project you worked on and what role you played in the project."
        question4.text = "Please explain about your experiences that revealed your responsibility."
        question5.text = "Please explain about OSI 7th floor."

        start1.setOnClickListener { view->
            var intent = Intent(this, Startinterview::class.java)
            intent.putExtra("name","1")
            startActivity(intent)
        }
        start2.setOnClickListener { view->
            var intent = Intent(this, Startinterview::class.java)
            intent.putExtra("name","2")
            startActivity(intent)
        }
        start3.setOnClickListener { view->
            var intent = Intent(this, Startinterview::class.java)
            intent.putExtra("name","3")
            startActivity(intent)
        }
        start4.setOnClickListener { view->
            var intent = Intent(this, Startinterview::class.java)
            intent.putExtra("name","4")
            startActivity(intent)
        }
        start5.setOnClickListener { view->
            var intent = Intent(this, Startinterview::class.java)
            intent.putExtra("name","5")
            startActivity(intent)
        }

        button.setOnClickListener { view->
            Thread(Runnable {
                var dis: DataInputStream? = null
                var dos: DataOutputStream? = null
                try {
                    println("Try to Connect Server...")
                    //dis = DataInputStream(socket.getInputStream())
                    //dos = DataOutputStream(socket.getOutputStream())
                    println("Connect success")
                    dos!!.writeUTF("video")
                    dos!!.flush()
                    val a = FileManager()
                    while(true){
                        println(123)
                    }
                    a.send(dos!!, filepathMyvideo, "1.mp4")
                    a.send(dos!!, filepathMyvideo, "2.mp4")
                    a.send(dos!!, filepathMyvideo, "3.mp4")
                    a.send(dos!!, filepathMyvideo, "4.mp4")
                    a.send(dos!!, filepathMyvideo, "5.mp4")
                    val b = FileManager()
                    b.recieve(dis!!, "/sdcard", "eye1.txt")
                    b.recieve(dis!!, "/sdcard", "emotion1.txt")
                    b.recieve(dis!!, "/sdcard", "eye2.txt")
                    b.recieve(dis!!, "/sdcard", "emotion2.txt")
                    b.recieve(dis!!, "/sdcard", "eye3.txt")
                    b.recieve(dis!!, "/sdcard", "emotion3.txt")
                    b.recieve(dis!!, "/sdcard", "eye4.txt")
                    b.recieve(dis!!, "/sdcard", "emotion4.txt")
                    b.recieve(dis!!, "/sdcard", "eye5.txt")
                    b.recieve(dis!!, "/sdcard", "emotion5.txt")
                } catch (e: Exception) {
                    println("socket error occure")
                    e.printStackTrace()
                }
            }).start()
        }
        button2.setOnClickListener { view->
            var intent = Intent(this, Result::class.java)
            myExternalFile = File(getExternalFilesDir(filepath), "eye1.txt")
            filename = "eye1.txt"
            myExternalFile = File(filepath,filename)
            if(filename.toString()!=null && filename.toString().trim()!="") {
                var fileInputStream = FileInputStream(myExternalFile)
                var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
                var text: String? = null
                while ({ text = bufferedReader.readLine(); text }() != null) {
                    lineList.add(text.toString())
                }
            }
            myExternalFile = File(getExternalFilesDir(filepath), "emotion1.txt")
            filename = "emotion1.txt"
            myExternalFile = File(filepath,filename)
            if(filename.toString()!=null && filename.toString().trim()!="") {
                var fileInputStream = FileInputStream(myExternalFile)
                var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
                var text: String? = null
                while ({ text = bufferedReader.readLine(); text }() != null) {
                    lineList.add(text.toString())
                }
            }
            myExternalFile = File(getExternalFilesDir(filepath), "eye2.txt")
            filename = "eye2.txt"
            myExternalFile = File(filepath,filename)
            if(filename.toString()!=null && filename.toString().trim()!="") {
                var fileInputStream = FileInputStream(myExternalFile)
                var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
                var text: String? = null
                while ({ text = bufferedReader.readLine(); text }() != null) {
                    lineList.add(text.toString())
                }
            }
            myExternalFile = File(getExternalFilesDir(filepath), "emotion2.txt")
            filename = "emotion2.txt"
            myExternalFile = File(filepath,filename)
            if(filename.toString()!=null && filename.toString().trim()!="") {
                var fileInputStream = FileInputStream(myExternalFile)
                var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
                var text: String? = null
                while ({ text = bufferedReader.readLine(); text }() != null) {
                    lineList.add(text.toString())
                }
            }
            myExternalFile = File(getExternalFilesDir(filepath), "eye3.txt")
            filename = "eye3.txt"
            myExternalFile = File(filepath,filename)
            if(filename.toString()!=null && filename.toString().trim()!="") {
                var fileInputStream = FileInputStream(myExternalFile)
                var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
                var text: String? = null
                while ({ text = bufferedReader.readLine(); text }() != null) {
                    lineList.add(text.toString())
                }
            }
            myExternalFile = File(getExternalFilesDir(filepath), "emotion3.txt")
            filename = "emotion3.txt"
            myExternalFile = File(filepath,filename)
            if(filename.toString()!=null && filename.toString().trim()!="") {
                var fileInputStream = FileInputStream(myExternalFile)
                var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
                var text: String? = null
                while ({ text = bufferedReader.readLine(); text }() != null) {
                    lineList.add(text.toString())
                }
            }
            myExternalFile = File(getExternalFilesDir(filepath), "eye4.txt")
            filename = "eye4.txt"
            myExternalFile = File(filepath,filename)
            if(filename.toString()!=null && filename.toString().trim()!="") {
                var fileInputStream = FileInputStream(myExternalFile)
                var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
                var text: String? = null
                while ({ text = bufferedReader.readLine(); text }() != null) {
                    lineList.add(text.toString())
                }
            }
            myExternalFile = File(getExternalFilesDir(filepath), "emotion4.txt")
            filename = "emotion4.txt"
            myExternalFile = File(filepath,filename)
            if(filename.toString()!=null && filename.toString().trim()!="") {
                var fileInputStream = FileInputStream(myExternalFile)
                var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
                var text: String? = null
                while ({ text = bufferedReader.readLine(); text }() != null) {
                    lineList.add(text.toString())
                }
            }
            myExternalFile = File(getExternalFilesDir(filepath), "eye5.txt")
            filename = "eye5.txt"
            myExternalFile = File(filepath,filename)
            if(filename.toString()!=null && filename.toString().trim()!="") {
                var fileInputStream = FileInputStream(myExternalFile)
                var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
                var text: String? = null
                while ({ text = bufferedReader.readLine(); text }() != null) {
                    lineList.add(text.toString())
                }
            }
            myExternalFile = File(getExternalFilesDir(filepath), "emotion5.txt")
            filename = "emotion5.txt"
            myExternalFile = File(filepath,filename)
            if(filename.toString()!=null && filename.toString().trim()!="") {
                var fileInputStream = FileInputStream(myExternalFile)
                var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
                var text: String? = null
                while ({ text = bufferedReader.readLine(); text }() != null) {
                    lineList.add(text.toString())
                }
            }

            intent.putExtra("result1", lineList[0])
            intent.putExtra("result2", lineList[1])
            intent.putExtra("result3", lineList[2])
            intent.putExtra("result4", lineList[3])
            intent.putExtra("result5", lineList[4])
            intent.putExtra("result6", lineList[5])
            intent.putExtra("result7", lineList[6])
            intent.putExtra("result8", lineList[7])
            intent.putExtra("result9", lineList[8])
            intent.putExtra("result10", lineList[9])

            startActivity(intent)
        }
    }
}
