package com.example.joid.learning1.fragments

import com.example.joid.learning1.R


class ItemsFragment : BaseFragment() {
    override val logTag = "Items fragment"
    override fun getLayout(): Int {
        return R.layout.fragment_items
    }
}
