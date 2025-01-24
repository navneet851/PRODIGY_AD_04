package com.android.ai.tictactoe.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.android.ai.tictactoe.R
import com.android.ai.tictactoe.data.model.Cell
import com.android.ai.tictactoe.data.model.Game
import com.android.ai.tictactoe.ui.components.GridBox
import com.android.ai.tictactoe.ui.theme.themeBackground
import com.android.ai.tictactoe.ui.theme.themeIcon
import com.android.ai.tictactoe.ui.viewmodel.GameViewModel
import kotlinx.coroutines.launch

@Composable
fun GameScreen(navController: NavHostController, game: Game) {

    val gameViewModel: GameViewModel = viewModel()
    val board by gameViewModel.board.collectAsState()

    var playerTurn by rememberSaveable {
        mutableStateOf(game.side)
    }
    val gameSide by rememberSaveable {
        mutableStateOf(game.side)
    }
    var playerTurnIndicator by rememberSaveable {
        mutableStateOf(true)
    }
    val gameMode by rememberSaveable {
        mutableStateOf(game.mode)
    }
    var winningState by remember {
        mutableStateOf(false)
    }
    val coroutineScope = rememberCoroutineScope()
    Row(
        modifier = Modifier
            .padding(20.dp, 50.dp)
    ) {
        Icon(
            modifier = Modifier
                .clickable {
                    navController.navigate("home")
                },
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "back"
        )
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(10))
                .background(if (!playerTurnIndicator) Color(0x9C50C9B3) else Color.Transparent)
                .padding(5.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(10))
                    .background(Color(0x741A443C))
                    .padding(5.dp),
                painter = painterResource(if (gameSide == "Cross") R.drawable.o else R.drawable.x),
                contentDescription = "opponent"
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = if (gameMode == "Single") "Bot" else "Player 2",
                fontSize = 17.sp,
                fontWeight = FontWeight.W500

            )
        }

        LazyVerticalGrid(
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.Center,
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .padding(50.dp)

        ) {
            items(board.size) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(80.dp)
                        .border(1.dp, Color.LightGray)
                        .clickable {
                            coroutineScope.launch {
                                if (board[it] == null) {
                                    gameViewModel.updateBoard(
                                        it,
                                        if (playerTurn == "Cross") Cell(
                                            "Cross",
                                            R.drawable.x
                                        ) else Cell("Circle", R.drawable.o)
                                    )
                                    playerTurn = if (playerTurn == "Cross") {
                                        "Circle"
                                    } else {
                                        "Cross"
                                    }
                                    playerTurnIndicator = !playerTurnIndicator
                                    winningState = gameViewModel.checkWin()
                                }
                            }


                        }
                ) {
                    if (board[it] != null) {
                        GridBox(board[it]!!)
                    }
                }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(10))
                .background(if (playerTurnIndicator) Color(0x9C50C9B3) else Color.Transparent)
                .padding(5.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(10))
                    .background(Color(0x741A443C))
                    .padding(5.dp),
                painter = painterResource(if (gameSide == "Cross") R.drawable.x else R.drawable.o),
                contentDescription = "player"
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = if (gameMode == "Single") "You" else "Player 1",
                fontSize = 17.sp,
                fontWeight = FontWeight.W500

            )
        }
    }

    if (winningState) {
        Dialog(
            onDismissRequest = {
                winningState = false
                navController.navigate("home")
            }
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                if (!playerTurnIndicator) {
                    Text(
                        text = if (gameMode == "Single") "You Win!" else "Player 1 Win!",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.W500

                    )
                } else {
                    Text(
                        text =  if (gameMode == "Single") "Bot Win!" else "Player 2 Win!",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.W500

                    )
                }
                Button(
                    onClick = {
                        gameViewModel.resetBoard()
                        playerTurn = game.side
                        playerTurnIndicator = true
                        winningState = false
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = themeIcon
                    )
                ) {
                    Text("New Game")
                }
                Button(
                    onClick = {
                        winningState = false
                        navController.navigate("home")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = themeIcon
                    )
                ) {
                    Text("Main Menu")
                }
            }
        }

    }
}