package com.example.joid.learning1.activities

import com.example.joid.learning1.R


open class ItemActivity : BaseActivity() {
    override val tag: String
        get() = "Item Activity"

    override fun getLayout(): Int {
        TODO()
    }
    override fun getActivityTitle(): Int = R.string.app_name
}