package com.android.ai.tictactoe.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.ai.tictactoe.R
import com.android.ai.tictactoe.ui.components.PlayerPrefCheckbox


@Preview(showBackground = true)
@Composable
private fun HomeScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
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
                checked = false,
                onCheckedChange = {}
            )
            PlayerPrefCheckbox(
                image = R.drawable.duo,
                checked = false,
                onCheckedChange = {}
            )
        }

        Spacer(modifier = Modifier.padding(16.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Pic Your Side",
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
                image = R.drawable.o,
                checked = false,
                onCheckedChange = {}
            )
            PlayerPrefCheckbox(
                modifier = Modifier
                    .size(100.dp)
                    .padding(20.dp)
                ,
                image = R.drawable.x,
                checked = false,
                onCheckedChange = {}
            )
        }

        Button(
            onClick = {

            }
        ) {
            Text("Start Game")
        }

    }
}