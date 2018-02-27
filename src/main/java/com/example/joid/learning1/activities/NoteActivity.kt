package com.example.joid.learning1.activities

import com.example.joid.learning1.R


class NoteActivity : ItemActivity() {
    override val tag: String
        get() = "Note Activity"

    override fun getLayout(): Int = R.layout.activity_note
    override fun getActivityTitle(): Int = R.string.app_name
}