package com.android.ai.tictactoe.data.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Cell(
    val color: Color,
    @DrawableRes val player: Int
)