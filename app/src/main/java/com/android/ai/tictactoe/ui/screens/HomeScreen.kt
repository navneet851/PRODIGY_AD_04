package com.android.ai.tictactoe.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.ai.tictactoe.R
import com.android.ai.tictactoe.ui.components.PlayerPrefCheckbox
import com.android.ai.tictactoe.ui.theme.themeIcon


@Preview(showBackground = false)
@Composable
fun HomeScreen() {
    var selectedMode by remember {
        mutableStateOf("Single")
    }
    var selectedSide by remember {
        mutableStateOf("Cross")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.tictactoe),
                contentDescription = "Tic Tac Toe",
                modifier = Modifier
                    .size(120.dp)
                    .padding(20.dp)
            )
        }


        Spacer(modifier = Modifier.padding(16.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Choose Player Mode",
            fontSize = 20.sp,
            fontWeight = FontWeight.W500,
            textAlign = TextAlign.Center
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            PlayerPrefCheckbox(
                image = R.drawable.solo,
                checked = selectedMode == "Single",
                onCheckedChange = {
                    selectedMode = "Single"
                }
            )
            PlayerPrefCheckbox(
                image = R.drawable.duo,
                checked = selectedMode == "Duo",
                onCheckedChange = {
                    selectedMode = "Duo"
                }
            )
        }

        Spacer(modifier = Modifier.padding(16.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Pic Your Side",
            fontSize = 18.sp,
            fontWeight = FontWeight.W500,
            textAlign = TextAlign.Center
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            PlayerPrefCheckbox(
                image = R.drawable.o,
                checked = selectedSide == "Circle",
                onCheckedChange = {
                    selectedSide = "Circle"
                }
            )
            PlayerPrefCheckbox(
                modifier = Modifier
                    .size(80.dp)
                    .padding(20.dp)
                ,
                image = R.drawable.x,
                checked = selectedSide == "Cross",
                onCheckedChange = {
                    selectedSide = "Cross"
                }
            )
        }

        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = themeIcon
            )
        ) {
            Text("Start")
        }

    }
}