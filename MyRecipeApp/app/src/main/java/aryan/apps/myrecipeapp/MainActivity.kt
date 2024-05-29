package aryan.apps.myrecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import aryan.apps.myrecipeapp.ui.theme.MyRecipeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            MyRecipeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    RecipeApp(navController = navController, modifier = Modifier.padding(padding))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeAppPreview() {
    val navController = rememberNavController()
    MyRecipeAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
            RecipeApp(
                navController = navController,
                modifier = Modifier.padding(padding)
            )
        }
    }
}