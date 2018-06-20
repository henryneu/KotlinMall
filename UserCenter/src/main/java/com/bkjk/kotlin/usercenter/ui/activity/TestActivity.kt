package com.bkjk.kotlin.usercenter.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bkjk.kotlin.usercenter.R
import org.jetbrains.anko.*

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_test)

        // Anko 的 DSL 使用
        verticalLayout {
            padding = dip(30)
            editText {
                hint = "Name"
                textSize = 20f
            }
            editText {
                hint = "Psd"
                textSize = 20f
            }
            button {
                text = "确认"
            }.setOnClickListener {
                toast("${intent.getIntExtra("id", 0)}")
            }
        }
    }
}
