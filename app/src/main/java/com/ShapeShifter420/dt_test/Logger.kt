package com.ShapeShifter420.dt_test

import android.util.Log
import com.ShapeShifter420.dt_test.Interfaces.ILogger

object Logger : ILogger {
    override fun log(tag: String, text: String) {
        Log.d(tag, text)
    }
}