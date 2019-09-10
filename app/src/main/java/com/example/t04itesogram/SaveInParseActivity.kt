package com.example.t04itesogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.parse.ParseObject
import com.parse.ParseQuery
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class SaveInParseActivity : AppCompatActivity() {
    private lateinit var mText: TextView
    private lateinit var mTextAsked: TextView
    private lateinit var mSaveButton: Button
    private lateinit var mGetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_in_parse)

        mText = find(R.id.activity_save_tf_parse_value) // findViewById using anko
        mTextAsked = find(R.id.activity_save_tv_asked_value)
        mSaveButton = find(R.id.activity_save_btn_save_parse) // findViewById using anko
        mGetButton = find(R.id.activity_save_btn_get) // findViewById using anko

        mGetButton.setOnClickListener {
            val query = ParseQuery<ParseObject>("Tarea")
            query.whereEqualTo("expediente", "is688178")
            query.addDescendingOrder("createdAt")
            query.getFirstInBackground { obj, e ->
                if (e == null)
                    mTextAsked.text = obj["valor"] as String
                else
                    error { e }  // Log.e using anko
            }
        }

        mSaveButton.setOnClickListener {
            val value = mText.text.toString()

            val studentObject = ParseObject("Tarea")
            studentObject.put("expediente", "is688178")
            studentObject.put("valor",  value)
            studentObject.saveInBackground()

            mText.text = ""
        }
    }
}
