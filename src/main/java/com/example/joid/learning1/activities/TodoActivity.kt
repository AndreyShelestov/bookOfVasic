package com.example.joid.learning1.activities

import com.example.joid.learning1.R


class TodoActivity : ItemActivity() {
    override val tag: String
        get() = "Todo Activity"

    override fun getLayout(): Int = R.layout.activity_todo
    override fun getActivityTitle(): Int = R.string.app_name
}