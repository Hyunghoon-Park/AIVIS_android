package com.example.aivis

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import com.example.aivis.R
import kotlinx.android.synthetic.main.activity_startinterview.*
import java.io.File


class Startinterview : AppCompatActivity() {

    lateinit var videoUri : Uri
    lateinit var videoPath : String
    val REQUEST_VIDEO_CAPTURE = 1
    val REQUEST_WRITE_EXTERNAL = 2
    lateinit var name : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startinterview)

        name = intent.getStringExtra("name")

        record_video.setOnClickListener {
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_WRITE_EXTERNAL)
            }else{
                recordVideo()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if(requestCode == REQUEST_WRITE_EXTERNAL) recordVideo()
    }
    private fun recordVideo() {
        val videoFile = createVideoFile()

        videoPath = videoFile.absolutePath

        if(videoFile != null){

            videoUri = FileProvider.getUriForFile(
                this,
                "com.example.aivis.fileprovider",
                videoFile
            )

            val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)

            intent.putExtra(MediaStore.EXTRA_OUTPUT, videoUri)

            startActivityForResult(intent, REQUEST_VIDEO_CAPTURE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_VIDEO_CAPTURE && resultCode == Activity.RESULT_OK){

            video_view.setVideoURI(videoUri)
            video_view.start()

            addToGallery()
        }
    }

    private fun addToGallery() {
        val mediaScan = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
        var file = File(videoPath)
        val uri = Uri.fromFile(file)
        mediaScan.setData(uri)
        this.sendBroadcast(mediaScan)
    }

    private fun createVideoFile(): File {
        val fileName = "Myvideo"

        val storageDir = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString() + "/MyVideo")

        if(!storageDir.exists()){
            storageDir.mkdir()
        }
        return File(storageDir, "${name}.mp4")
        return File.createTempFile(
            fileName,
            ".mp4",
            storageDir
        )
    }
}