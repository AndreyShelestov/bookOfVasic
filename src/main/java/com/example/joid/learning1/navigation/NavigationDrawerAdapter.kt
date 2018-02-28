package com.example.joid.learning1.navigation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.LinearLayout
import com.example.joid.learning1.R

/**
 * Created by joid on 28.02.18.
 */
class NavigationDrawerAdapter(
        val ctx: Context,
        val items: List<NavigationDrawerItem>
) : BaseAdapter() {
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = LayoutInflater.from(ctx)
        var view = p1
        if (view == null) {
            view = inflater.inflate(
                    R.layout.adapter_navigation_drawer, null
            ) as LinearLayout
        }

        val item = items[p0]
        val title = view.findViewById<Button>(R.id.drawer_item)
        val text = item.title
        title.setOnClickListener {
            item.onClick.run()
        }

        return view
    }

    override fun getItem(p0: Int): Any {
        return items[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0L
    }

    override fun getCount(): Int {
        return items.size
    }

}