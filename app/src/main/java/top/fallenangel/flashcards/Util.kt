package top.fallenangel.flashcards

import android.content.Context
import android.widget.Toast
import androidx.compose.ui.graphics.Color

fun Color(value: String): Color {
    val colorBit = value.chunked(2) { it.toString().toInt(radix = 16) }

    val red = colorBit[0]
    val green = colorBit[1]
    val blue = colorBit[2]
    val alpha = if (colorBit.lastIndex == 3) colorBit[3] else 255

    return Color(red, green, blue, alpha)
}

fun toast(text: String, context: Context) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}