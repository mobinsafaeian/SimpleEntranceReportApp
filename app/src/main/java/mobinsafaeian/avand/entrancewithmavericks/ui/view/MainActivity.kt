package mobinsafaeian.avand.entrancewithmavericks.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mobinsafaeian.avand.entrancewithmavericks.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adding Fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container , MainFragment())
            .commit()

    }
}