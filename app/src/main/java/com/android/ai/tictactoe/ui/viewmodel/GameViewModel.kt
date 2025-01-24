package com.android.ai.tictactoe.ui.viewmodel

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.android.ai.tictactoe.R
import com.android.ai.tictactoe.data.model.Cell
import com.android.ai.tictactoe.ui.theme.themeIcon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GameViewModel : ViewModel() {
    private val _board = MutableStateFlow(MutableList<Cell?>(9) { null })
    val board: StateFlow<List<Cell?>> = _board

//    init {
//        _board.value = _board.value.toMutableList().apply {
//            this[3] = Cell(R.drawable.x)
//            this[8] = Cell(R.drawable.x)
//        }
//    }

    fun updateBoard(index: Int, cell: Cell) {
        _board.value = _board.value.toMutableList().apply {
            this[index] = Cell(side = cell.side, player = cell.player, color = cell.color)
        }
    }

    fun resetBoard(){
        _board.value = MutableList<Cell?>(9) { null }
    }

    fun checkWin(): Boolean{
        val board = _board.value
        val winningPositions = listOf(
            listOf(0, 1, 2), // Row 1
            listOf(3, 4, 5), // Row 2
            listOf(6, 7, 8), // Row 3
            listOf(0, 3, 6), // Column 1
            listOf(1, 4, 7), // Column 2
            listOf(2, 5, 8), // Column 3
            listOf(0, 4, 8), // Diagonal 1
            listOf(2, 4, 6)  // Diagonal 2
        )

        for (position in winningPositions){
            val (a, b, c) = position
            if (board[a] != null && board[a] == board[b] && board[a] == board[c]){
                _board.value = _board.value.toMutableList().apply {
                    this[a] = this[a]!!.copy(color = Color(0xC3297667))
                    this[b] = this[b]!!.copy(color = Color(0xC3297667))
                    this[c] = this[c]!!.copy(color = Color(0xC3297667))
                }
                return true
            }
        }
        return false
    }


}