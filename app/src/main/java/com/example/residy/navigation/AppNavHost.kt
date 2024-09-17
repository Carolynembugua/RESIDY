package com.example.residy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.residy.ui.theme.screens.about.AboutScreen
import com.example.residy.ui.theme.screens.details.DetailsScreen
import com.example.residy.ui.theme.screens.home.HomeScreen
import com.example.residy.ui.theme.screens.login.LoginScreen
import com.example.residy.ui.theme.screens.products.AddProductsScreen
import com.example.residy.ui.theme.screens.products.ViewProductsScreen
import com.example.residy.ui.theme.screens.signup.SignupScreen
import com.example.residy.ui.theme.screens.splash.SplashScreen
import com.example.residy.ui.theme.screens.startup.StartupScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination:String = ROUT_STARTUP
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(ROUT_ABOUT) {
            AboutScreen(navController = navController)
        }
        composable(ROUT_HOME) {
            HomeScreen(navController = navController)
        }
        composable(ROUT_SPLASH) {
            SplashScreen(navController = navController)
        }
        composable(ROUT_SIGNUP) {
            SignupScreen(navController = navController)
        }
        composable(ROUT_LOGIN) {
           LoginScreen(navController = navController)
        }
        composable(ADD_PRODUCTS_URL) {
            AddProductsScreen(navController = navController)
        }
        composable(VIEW_PRODUCTS_URL) {
            ViewProductsScreen(navController = navController)
        }
        composable(ROUT_STARTUP) {
           StartupScreen(navController = navController)
        }
        composable(ROUT_DETAILS){
            DetailsScreen(navController = navController)

        }



    }
}