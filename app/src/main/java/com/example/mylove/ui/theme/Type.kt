package com.example.mylove.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mylove.R


val LoveIsFont = FontFamily(
    Font(R.font.finty, FontWeight.Normal),
    Font(R.font.finty, FontWeight.Bold)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = LoveIsFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    displayMedium = TextStyle(
        fontFamily = LoveIsFont,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
)