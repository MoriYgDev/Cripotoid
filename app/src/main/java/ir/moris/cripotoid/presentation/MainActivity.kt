package ir.moris.cripotoid.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.moris.cripotoid.presentation.cripto_detail.CryptoDetailScreen
import ir.moris.cripotoid.presentation.cripto_list.CryptoListScreen
import ir.moris.cripotoid.presentation.ui.theme.CripotoidTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CripotoidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.CryptoListScreen.rout){
                        composable(route = Screen.CryptoListScreen.rout){
                            CryptoListScreen(navController = navController)
                        }
                        composable(route = Screen.CryptoDetailScreen.rout + "/{coinId}"){
                            CryptoDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
