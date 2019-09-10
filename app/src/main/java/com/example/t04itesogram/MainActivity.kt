package iteso.mx.materialdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.parse.ParseObject
import com.parse.ParseQuery
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mText: TextView
    private lateinit var mFetchButton: Button
    private lateinit var mNewActivityButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mText = find(R.id.activity_main_tv_text) // findViewById using anko
        mFetchButton = find(R.id.activity_main_btn_parse_fetch) // findViewById using anko
        mNewActivityButton = find(R.id.activity_main_btn_new_activity) // findViewById using anko

        mNewActivityButton.setOnClickListener {
            startActivity<ActivityNoMaterial>()
        }

        mFetchButton.setOnClickListener {
            val query = ParseQuery<ParseObject>("Test")
            query.whereEqualTo("objectId", "vASKfewZ1J")
            query.getFirstInBackground { obj, e ->
                if (e == null)
                    mText.text = obj["key"] as String
                else
                    error { "Error $e" }  // Log.e using anko
            }
        }
    }
}
