package com.tuuzed.androidx.loggersample

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tuuzed.androidx.logger.*
import com.tuuzed.androidx.logger.log4j.Log4jLogger
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        Log.setImpl(
            Log4jLogger(
                this,
                log4jRootLevel = LogLevel.ALL
            )
        )

        printLog()
    }

    @AfterPermissionGranted(1)
    fun printLog() {
        val perms = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        if (hasPermissionsCompat(*perms)) {
            LOGV(TAG, "v")
            LOGD(TAG, "d")
            LOGI(TAG, "i")
            LOGW(TAG, "w")
            LOGE(TAG, "e")
            LOGF(TAG, "f")
        } else {
            requestPermissionsCompat(perms, 1)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestPermissionsResultCompat(requestCode, permissions, grantResults, this)
    }

}
