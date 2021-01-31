package com.example.aivis

import android.net.Uri
import android.os.Environment
import java.io.*

class FileManager {
    fun recieve(
        dis: DataInputStream,
        filePath: String,
        fileName: String
    ): String {
        var result: String
        var fos: FileOutputStream? = null
        var bos: BufferedOutputStream? = null
        try {
            println("파일 수신 작업을 시작합니다.")
            // 파일을 생성하고 출력 스트림 생성
            //filePath = Environment
            val file = File("$filePath/$fileName")
            fos = FileOutputStream(file)
            bos = BufferedOutputStream(fos)
            // 파일 수신 시작
            var len = 0
            val size = 4096
            val data = ByteArray(size)
            while (true) {

                len = dis.readInt()
                println("number of bytes: $len")
                if (len == -1) {
                    break
                } else {
                    dis.read(data, 0, len)
                    bos.write(data, 0, len)
                }
            }
            bos.flush()
            result = "SUCCESS"
            println("파일 수신 작업을 완료하였습니다.")
        } catch (e: IOException) {
            e.printStackTrace()
            result = "ERROR"
        } finally {
            try {
                bos!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            try {
                fos!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return result
    }

    fun send(
        dos: DataOutputStream,
        filePath: String,
        fileName: String
    ): String {
        var result: String
        var fis: FileInputStream? = null
        var bis: BufferedInputStream? = null
        try {
            println("파일 전송 작업을 시작합니다.")
            // 파일을 읽고 입력 스트림 생성
            val file = File(filePath,fileName)
            fis = FileInputStream(file)
            bis = BufferedInputStream(fis)
            // 파일 전송 시작
            var len = 0
            val size = 4096
            val data = ByteArray(size)
            while (true) {
                len = bis.read(data)
                println("number of bytes: $len")
                if (len == -1) {
                    dos.writeInt(len)
                    break
                } else {
                    dos.writeInt(len)
                    dos.write(data, 0, len)
                }
            }
            dos.flush()
            result = "SUCCESS"
            println("파일 전송 작업을 완료하였습니다.")
        } catch (e: IOException) {
            e.printStackTrace()
            result = "ERROR"
        } finally {
            try {
                bis!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            try {
                fis!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return result
    }

    fun send(
        dos: DataOutputStream,
        pathname: String
    ): String {
        var result: String
        var fis: FileInputStream? = null
        var bis: BufferedInputStream? = null
        try {
            println("파일 전송 작업을 시작합니다.")
            // 파일을 읽고 입력 스트림 생성
            val file = File(pathname)
            fis = FileInputStream(file)
            bis = BufferedInputStream(fis)
            // 파일 전송 시작
            var len = 0
            val size = 4096
            val data = ByteArray(size)
            while (true) {
                len = bis.read(data)
                println("number of bytes: $len")
                if (len == -1) {
                    dos.writeInt(len)
                    break
                } else {
                    dos.writeInt(len)
                    dos.write(data, 0, len)
                }
            }
            dos.flush()
            result = "SUCCESS"
            println("파일 전송 작업을 완료하였습니다.")
        } catch (e: IOException) {
            e.printStackTrace()
            result = "ERROR"
        } finally {
            try {
                bis!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            try {
                fis!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return result
    }


    fun printText(fileName: String) {
        var fis: FileInputStream? = null
        var isr: InputStreamReader? = null
        var bufReader: BufferedReader? = null
        try {
            val file = File("$fileName")
            fis = FileInputStream(file)
            isr = InputStreamReader(fis, "UTF-8")
            bufReader = BufferedReader(isr)
            var line: String? = null
            while (bufReader.readLine().also { line = it } != null) {
                println(line)
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                bufReader!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            try {
                isr!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            try {
                fis!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}