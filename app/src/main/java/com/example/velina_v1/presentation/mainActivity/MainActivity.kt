package com.example.velina_v1.presentation.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.velina_v1.R
import com.example.velina_v1.presentation.mainActivity.viewModel.MainActivityViewModel
import com.example.velina_v1.presentation.theme.Velina_v1Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            Velina_v1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)){
                        if (viewModel.isOnboardingPassed) {
                            Greeting(
                                name = "Android"
                            )
                        } else {
                            OnboardingView()
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun OnboardingView() {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Welcome to Velina - Your F1 Data Center",
                color = colorResource(id = R.color.white ),
                style = MaterialTheme.typography.headlineLarge,
//                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(160.dp))

            Text(text = "Compose makes it easy to build beautiful UIs.",
//                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { /* Handle click */ }) {
                Text("Click Me")
            }
        }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Velina_v1Theme {
        Greeting("Android")
    }
}