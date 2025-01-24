package com.android.ai.tictactoe.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.android.ai.tictactoe.R
import com.android.ai.tictactoe.data.model.Game
import com.android.ai.tictactoe.ui.components.GridBox
import com.android.ai.tictactoe.ui.theme.themeBackground
import com.android.ai.tictactoe.ui.viewmodel.GameViewModel

@Composable
fun GameScreen(navController: NavHostController, game: Game) {

    val gameViewModel : GameViewModel = viewModel()
    val board by gameViewModel.board.collectAsState()
    Row(
        modifier = Modifier
            .padding(20.dp, 50.dp)
    ) {
        Icon(
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

        ) {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(10))
                    .background(Color(0x8BA07640))
                    .padding(5.dp)
                ,
                painter = painterResource(R.drawable.o),
                contentDescription = "opponent"
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "Player 2",
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
            items(board.size){
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(80.dp)
                        .border(1.dp, Color.LightGray)
                ){
                    if(board[it] != null){
                        GridBox(board[it]!!)
                    }
                }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier

        ) {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(10))
                    .background(Color(0x8BA07640))
                    .padding(5.dp)
                ,
                painter = painterResource(R.drawable.x),
                contentDescription = "opponent"
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "Player 1",
                fontSize = 17.sp,
                fontWeight = FontWeight.W500

            )
        }
    }
}