package com.android.ai.tictactoe.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Game(
    val mode : String,
    val side : String
)