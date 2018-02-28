package com.example.joid.learning1.activities

import android.os.Bundle
import com.example.joid.learning1.R
import kotlinx.android.synthetic.main.activity_todo.*


class TodoActivity : ItemActivity() {
    companion object {
        val EXTRA_TIME = "EXTRA_TIME"
        val EXTRA_DATE = "EXTRA_DATE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = intent.extras
        data?.let {
            val date = data.getString(EXTRA_DATE, "")
            val time = data.getString(EXTRA_TIME, "")
            pick_date.text = date
            pick_time.text = time
        }
    }

    override val tag: String
        get() = "Todo Activity"

    override fun getLayout(): Int = R.layout.activity_todo
    override fun getActivityTitle(): Int = R.string.app_name
}