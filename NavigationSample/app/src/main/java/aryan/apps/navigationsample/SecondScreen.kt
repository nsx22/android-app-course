package aryan.apps.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import aryan.apps.navigationsample.ui.theme.NavigationSampleTheme

@Composable
fun SecondScreen(name: String, age: Int, navigationToThirdScreen: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "This is the second screen",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            "Welcome $name. Your age is $age",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navigationToThirdScreen()
        }) {
            Text("Go to third screen")
        }
    }
}

@Preview
@Composable
fun SecondPreview() {
    NavigationSampleTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
            val p = padding
            SecondScreen("Aryan", 15, {})
        }
    }
}