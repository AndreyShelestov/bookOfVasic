package com.example.joid.learning1.activities

import android.app.Activity
import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.joid.learning1.R
import kotlinx.android.synthetic.main.activity_main.*


abstract class BaseActivity : AppCompatActivity() {
    protected abstract val tag: String
    protected abstract fun getLayout(): Int
    protected abstract fun getActivityTitle(): Int

    companion object {
        private var robotoBold: Typeface? = null
        private var robotoRegular: Typeface? = null

        fun applyFonts(view: View, ctx: Context) {
            var vTag = ""
            if (view.tag is String) {
                vTag = view.tag as String
            }
            when (view) {
                is ViewGroup -> {
                    for (x in 0..view.childCount - 1) {
                        applyFonts(view.getChildAt(x), ctx)
                    }
                }
                is Button -> {
                    when (vTag) {
                        ctx.getString(R.string.tag_font_bold) -> {
                            view.typeface = robotoBold
                        }
                        else -> {
                            view.typeface = robotoRegular
                        }
                    }
                }
                is TextView -> {
                    when (vTag) {
                        ctx.getString(R.string.tag_font_bold) -> {
                            view.typeface = robotoBold
                        }
                        else -> {
                            view.typeface = robotoRegular
                        }
                    }
                }
                is EditText -> {
                    when (vTag) {
                        ctx.getString(R.string.tag_font_bold) -> {
                            view.typeface = robotoBold
                        }
                        else -> {
                            view.typeface = robotoRegular
                        }
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        setContentView(getLayout())
        setSupportActionBar(toolbar)
        Log.v(tag, "ON CREATE: ")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        Log.v(tag, "[ ON POST CREATE ]")
        applyFonts()
    }

    protected fun applyFonts() {
        initFonts()
        Log.v(tag, "Applying fonts [ START ]")
        val rootView = findViewById<View>(android.R.id.content)
        applyFonts(rootView, this)
        Log.v(tag, "Applying fonts [ END ]")
    }

    private fun initFonts() {
        if (robotoBold == null) {
            Log.v(tag, "Initializing font [ Exo2-Bold ]")
            robotoBold = Typeface.createFromAsset(assets, "fonts/robotocondensedbold.ttf")
        }
        if (robotoRegular == null) {
            Log.v(tag, "Initializing font [ Exo2-Regular ]")
            robotoRegular = Typeface.createFromAsset(assets,
                    "fonts/robotocondensedregular.ttf")
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(tag, "[ ON RESTART ]")
    }

    override fun onStart() {
        super.onStart()
        Log.v(tag, "[ ON START ]")
    }

    override fun onResume() {
        super.onResume()
        Log.v(tag, "[ ON RESUME ]")
        val animation = getAnimation(R.anim.top_to_bottom)

    }

    override fun onPostResume() {
        super.onPostResume()
        Log.v(tag, "[ ON POST RESUME ]")
    }

    override fun onPause() {
        super.onPause()
        val animation = getAnimation(R.anim.hide_to_top)

        Log.v(tag, "[ ON PAUSE ]")
    }

    protected fun getAnimation(animation: Int) {
        AnimationUtils.loadAnimation(this, animation)
    }

    fun Activity.getAnimation(animation: Int): Animation =
            AnimationUtils.loadAnimation(this, animation)

    override fun onStop() {
        super.onStop()
        Log.v(tag, "[ ON STOP ]")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(tag, "[ ON DESTROY ]")
    }
}

