package com.ShapeShifter420.dt_test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ShapeShifter420.dt_test.Interfaces.ILogger

class MainActivity : AppCompatActivity() {
    companion object {
        const val countKey = "c_key"
    }

    private val logTag = "Activity1Log"
    private var count = 0
    private val logger: ILogger = Logger
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        count = savedInstanceState?.getInt(countKey, 0) ?: 0
        val countTextView = findViewById<TextView>(R.id.textView)
        countTextView.text = (count).toString()
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(countKey, count)
            startActivity(intent)
        }
        logger.log(logTag, "Create")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(countKey, count + 1)
        //logger.log(logTag,"SaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt(countKey)
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