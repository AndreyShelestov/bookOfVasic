package com.example.joid.learning1.activities

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.example.joid.learning1.R
import com.example.joid.learning1.model.MODE


abstract class ItemActivity : BaseActivity() {
    protected var mode = MODE.VIEW
    protected var success = Activity.RESULT_CANCELED
    override val tag: String
        get() = "Item Activity"

    override fun getLayout(): Int {
        TODO()
    }
    override fun getActivityTitle(): Int = R.string.app_name
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = intent.extras
        data?.let {
            val modeToSet = intent.getIntExtra(MODE.EXTRAS_KEY, MODE.VIEW.mode)
            mode = MODE.getByValue(modeToSet)
        }
        Log.v(tag, "Mode [$mode]")
    }

    override fun onDestroy() {
        super.onDestroy()
        setResult(success)
    }
}