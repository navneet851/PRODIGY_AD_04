package com.android.ai.tictactoe.data.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Cell(
    val side : String,
    @DrawableRes val player: Int,
    var color: Color = Color.Transparent
)