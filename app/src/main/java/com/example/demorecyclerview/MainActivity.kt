package com.example.demorecyclerview

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.demorecyclerview.activity.Activity1
import com.example.demorecyclerview.activity.Activity2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_demo1.setOnClickListener(this)
        btn_demo2.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0) {
            btn_demo1 -> {
                startActivity(Intent(this, Activity1::class.java))
            }
            btn_demo2 ->{
                startActivity(Intent(this, Activity2::class.java))
            }
        }
    }
}