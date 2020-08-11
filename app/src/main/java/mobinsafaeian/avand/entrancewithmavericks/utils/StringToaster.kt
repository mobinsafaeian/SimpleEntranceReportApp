package mobinsafaeian.avand.entrancewithmavericks.utils

import android.content.Context
import android.widget.Toast

infix fun String.toast(context: Context) {
    Toast.makeText(context , this , Toast.LENGTH_SHORT).show()
}