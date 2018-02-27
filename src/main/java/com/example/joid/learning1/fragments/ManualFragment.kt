package com.example.joid.learning1.fragments

import com.example.joid.learning1.R


class ManualFragment: BaseFragment() {
    override val logTag: String
        get() = "Manual"

    override fun getLayout(): Int {
        return R.layout.fragment_manual
    }
}