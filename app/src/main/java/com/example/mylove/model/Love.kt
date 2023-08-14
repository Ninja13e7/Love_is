package com.example.mylove.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Love(
    @StringRes val data: Int,
    @StringRes val itLove: Int,
    @StringRes val descriptionLove: Int,
    @DrawableRes val imageLove: Int
)
