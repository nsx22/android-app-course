package aryan.apps.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import aryan.apps.navigationsample.ui.theme.NavigationSampleTheme

@Composable
fun FirstScreen(navigationToSecondScreen: (String, Int) -> Unit) {
    val name = remember {
        mutableStateOf("")
    }
    val age = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "This is the first screen",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name.value,
            onValueChange = {
                name.value = it
            },
            label = { Text("Enter name") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = age.value,
            onValueChange = {
                age.value = it
            },
            label = { Text("Age") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navigationToSecondScreen(name.value, age.value.toIntOrNull() ?: 0)
        }) {
            Text("Go to second screen")
        }
    }
}

@Preview
@Composable
fun FirstPreview() {
    NavigationSampleTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
            val p = padding
            FirstScreen({String, Int ->})
        }
    }
}
