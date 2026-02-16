package com.example.dashcam

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dashcam.ui.theme.DashCamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DashCamTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MotionCamApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MotionCamApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val database = AppDatabase.getDatabase(androidx.compose.ui.platform.LocalContext.current)
    
    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = modifier
    ) {
        composable("login") {
            LoginScreen(
                database = database,
                onLoginSuccess = { navController.navigate("camera") },
                onNavigateToRegister = { navController.navigate("register") }
            )
        }
        
        composable("register") {
            RegisterScreen(
                database = database,
                onRegisterSuccess = { navController.popBackStack() },
                onNavigateToLogin = { navController.popBackStack() }
            )
        }
        
        composable("camera") {
            CameraScreen(
                onNavigateToGallery = { navController.navigate("gallery") }
            )
        }
        
        composable("gallery") {
            GalleryScreen(
                onNavigateBack = { navController.popBackStack() },
                onVideoClick = { uri ->
                    navController.navigate("player/${Uri.encode(uri.toString())}")
                }
            )
        }
        
        composable(
            route = "player/{videoUri}",
            arguments = listOf(navArgument("videoUri") { type = NavType.StringType })
        ) { backStackEntry ->
            val videoUriString = backStackEntry.arguments?.getString("videoUri")
            videoUriString?.let {
                VideoPlayerScreen(
                    videoUri = Uri.parse(it),
                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}