package com.android.ai.tictactoe.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import  androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.android.ai.tictactoe.data.model.Game
import com.android.ai.tictactoe.ui.screens.GameScreen
import com.android.ai.tictactoe.ui.screens.HomeScreen
import kotlinx.serialization.Serializable

@Composable
fun NavHost() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home"){
        composable("home"){
            HomeScreen(navController)
        }
        composable<Game>{
            val game = it.toRoute<Game>()
            GameScreen(navController, game)
        }
    }
}

