package com.ShapeShifter420.dt_test

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ShapeShifter420.dt_test.Interfaces.ILogger


class SecondActivity : AppCompatActivity() {
    private val logTag = "Activity2Log"
    private var count = 0
    private val logger: ILogger = Logger
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val countTextView = findViewById<TextView>(R.id.textView)
        count = intent.extras?.getInt(MainActivity.countKey) ?: 0
        countTextView.text = (count * count).toString()
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            finish()
        }
        logger.log(logTag, "Create")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(MainActivity.countKey, count)
        //logger.log(logTag,"SaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt(MainActivity.countKey)
        //logger.log(logTag,"RestoreInstanceState")
    }

    override fun onStart() {
        super.onStart()
        logger.log(logTag, "Start")
    }

    override fun onResume() {
        super.onResume()
        logger.log(logTag, "Resume")

    }

    override fun onPause() {
        super.onPause()
        logger.log(logTag, "Pause")
    }

    override fun onStop() {
        super.onStop()
        logger.log(logTag, "Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logger.log(logTag, "Destroy")
    }
}
