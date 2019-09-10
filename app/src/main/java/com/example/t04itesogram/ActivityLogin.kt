package com.example.t04itesogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class ActivityLogin : AppCompatActivity() {
    private lateinit var mNewActivityButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mNewActivityButton = find(R.id.activity_login_btn_login) // findViewById using anko

        mNewActivityButton.setOnClickListener {
            startActivity<SaveInParseActivity>()
        }

    }
}
