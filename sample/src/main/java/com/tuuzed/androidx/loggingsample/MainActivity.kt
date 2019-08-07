package com.tuuzed.androidx.loggingsample

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tuuzed.androidx.logging.Logger
import com.tuuzed.androidx.logging.ktx.*
import com.tuuzed.androidx.logging.log4j.Log4jFileAppender
import com.tuuzed.androidx.logging.log4j.Log4jLoggerImpl
import com.tuuzed.androidx.logging.log4j.Log4jLogcatAppender
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions
import java.io.File
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    companion object {
        private const val REQUEST_CODE = 1
        private const val TAG = "MainActivity#Logging"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val logfile = File(getExternalFilesDir("log"), "log4j.txt")
        Logger.setImpl(
            Log4jLoggerImpl(
                Logger.VERBOSE,
                Log4jLogcatAppender(),
                Log4jFileAppender(logfile.absolutePath, true)
                    .immediateFlush(true)
                    .maxBackupCount(1)
                    .maximumFileSize(1024 * 1024) // 1MB
            )
        )
        printLog()

        thread {
            val log = logfile.readText(Charsets.UTF_8)
            runOnUiThread {
                text.text = log
            }
        }
    }

    @AfterPermissionGranted(REQUEST_CODE)
    fun printLog() {
        val perms = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        if (EasyPermissions.hasPermissions(this, *perms)) {
            LOG2V(TAG, "v")
            LOG2D(TAG, "d")
            LOG2I(TAG, "i")
            LOG2W(TAG, "w")
            LOG2E(TAG, "e")
            LOG2F(TAG, "f")
        } else {
            EasyPermissions.requestPermissions(this, "保存日志需要读写外置存储权限。", REQUEST_CODE, *perms)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

}
