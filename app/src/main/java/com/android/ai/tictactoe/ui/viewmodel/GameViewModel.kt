package com.android.ai.tictactoe.ui.viewmodel

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.android.ai.tictactoe.R
import com.android.ai.tictactoe.data.model.Cell
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GameViewModel : ViewModel() {
    private val _board = MutableStateFlow(MutableList<Cell?>(9) { null })
    val board: StateFlow<List<Cell?>> = _board

    init {
        _board.value[3] = Cell(Color.Red, R.drawable.x)
        _board.value[8] = Cell(Color.Red, R.drawable.x)
    }

//    fun updateBoard(index: Int, cell: Cell) {
//        _board.value[index] = Cell()
//    }


}