package aryan.apps.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import aryan.apps.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    MyApp(Modifier.padding(padding))
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "firstscreen",
        modifier = modifier
    ) {
        composable("firstscreen") {
            FirstScreen { name, age ->
                navController.navigate("secondscreen/$name/$age")
            }
        }
        composable("secondscreen/{name}/{age}") {
            val name = it.arguments?.getString("name") ?: "no name"
            val age = it.arguments?.getString("age") ?: "0"
            SecondScreen(name, (age.toIntOrNull() ?: 0)) {
                navController.navigate("thirdscreen")
            }
        }
        composable("thirdscreen") {
            ThirdScreen {
                navController.navigate("firstscreen")
            }
        }
    }
}