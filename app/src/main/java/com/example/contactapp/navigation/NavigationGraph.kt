package com.example.contactapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.contactapp.model.Contact
import com.example.contactapp.ui.screen.DetailsScreen
import com.example.contactapp.ui.screen.HomeScreen

@Composable
fun NavigationGraph(
    navController:NavHostController
){
    NavHost(navController = navController, startDestination = Screens.Home.route) {

        composable(Screens.Home.route){
            HomeScreen(modifier = Modifier,navController, navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("contact",it)
                navController.navigate(Screens.Details.route)
            })
        }

        composable(Screens.Details.route){
            val contact = navController.previousBackStackEntry?.savedStateHandle?.get<Contact>("contact")?:Contact("","","","")
            DetailsScreen(navController,contact = contact)
        }


    }
}