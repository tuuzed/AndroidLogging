package com.tuuzed.androidx.loggersample

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.tuuzed.androidx.logger.LOGW
import java.lang.reflect.InvocationTargetException


fun Context.hasPermissionsCompat(vararg permissions: String) =
    RuntimePermissionCompat.hasPermissions(this, *permissions)

fun Activity.requestPermissionsCompat(
    permissions: Array<String>,
    @androidx.annotation.IntRange(from = 0) requestCode: Int
) = RuntimePermissionCompat.requestPermissions(this, permissions, requestCode)

fun Fragment.requestPermissionsCompat(
    permissions: Array<String>,
    @androidx.annotation.IntRange(from = 0) requestCode: Int
) = RuntimePermissionCompat.requestPermissions(this, permissions, requestCode)

fun Any.onRequestPermissionsResultCompat(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray,
    handler: Any = this
) = RuntimePermissionCompat.onRequestPermissionsResult(
    requestCode,
    permissions,
    grantResults,
    handler
)

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class AfterPermissionGranted(
    @androidx.annotation.IntRange(from = 0)
    val requestCode: Int
)

object RuntimePermissionCompat {

    private const val TAG = "RuntimePermission"

    fun hasPermissions(context: Context, vararg permissions: String): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {  // Android°æ±¾Ð¡ÓÚAndroid6.0
            return true
        } else {
            for (permission in permissions) {
                if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false
                }
            }
            return true
        }
    }

    fun requestPermissions(
        activity: Activity,
        permissions: Array<String>,
        @androidx.annotation.IntRange(from = 0) requestCode: Int
    ) {
        ActivityCompat.requestPermissions(activity, permissions, requestCode)
    }

    fun requestPermissions(
        fragment: Fragment,
        permissions: Array<String>,
        @androidx.annotation.IntRange(from = 0) requestCode: Int
    ) {
        fragment.requestPermissions(permissions, requestCode)
    }

    fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
        handler: Any
    ) {
        var result = true
        for (i in grantResults.indices) {
            val grantResult = grantResults[i]
            result = grantResult == PackageManager.PERMISSION_GRANTED
            if (!result) {
                LOGW(
                    TAG,
                    "onRequestPermissionsResult: »ñÈ¡²»µ½" + permissions[i] + "È¨ÏÞ"
                )
                break
            }
        }
        if (result) {
            val methods = handler.javaClass.declaredMethods ?: return
            for (method in methods) {
                val afterPermissionGranted = method.getAnnotation(AfterPermissionGranted::class.java)
                afterPermissionGranted?.let {
                    if (it.requestCode == requestCode) {
                        if (!method.isAccessible) {
                            method.isAccessible = true
                        }
                        try {
                            method.invoke(handler)
                        } catch (e: IllegalAccessException) {
                            LOGW(
                                TAG,
                                "onRequestPermissionsResult: ",
                                e
                            )
                        } catch (e: InvocationTargetException) {
                            LOGW(
                                TAG,
                                "onRequestPermissionsResult: ",
                                e
                            )
                        }
                    }
                }
            }
        }
    }
}


