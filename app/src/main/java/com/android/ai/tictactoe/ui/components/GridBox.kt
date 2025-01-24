package com.android.ai.tictactoe.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.ai.tictactoe.R
import com.android.ai.tictactoe.data.model.Cell
import com.android.ai.tictactoe.ui.theme.themeIcon

@Composable
fun GridBox(
    cell: Cell
) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .padding(3.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(cell.color)
            .padding(8.dp)

    ){
        Image(
            painter = painterResource(cell.player),
            contentDescription = "turn",
            contentScale = ContentScale.Fit
        )
    }
}