package com.example.velina_v1.presentation.mainActivity

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import com.example.velina_v1.R
import com.example.velina_v1.presentation.mainActivity.viewModel.MainActivityViewModel
import com.example.velina_v1.presentation.theme.Velina_v1Theme
import dagger.hilt.android.AndroidEntryPoint
import java.util.Vector

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        window.decorView.systemUiVisibility = 0
        setContent {
            Velina_v1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)){
                        if (viewModel.isOnboardingPassed) {
                            Spacer(modifier = Modifier.padding(innerPadding))
                        } else {
                            SplashView()
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SplashView() {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Welcome to Velina - \nYour F1 Data Center",
                color = colorResource(id = R.color.mainOrange ),
                lineHeight = 30.sp,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = 115.dp, y = 35.dp)
                    .size(234.dp)
                    .border(
                        width = 2.dp,
                        color = colorResource(id = R.color.mainOrange),
                        shape = CircleShape
                    )
            )
            Box(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .offset(x = -130.dp, y = 180.dp)
                    .size(234.dp)
                    .border(
                        width = 2.dp,
                        color = colorResource(id = R.color.mainOrange),
                        shape = CircleShape
                    )
            )
            Box(
                modifier = Modifier
                    // Redo with BottomStart
                    .align(Alignment.CenterStart)
                    .offset(x = 0.dp, y = 280.dp)
                    .size(234.dp)
                    .border(
                        width = 2.dp,
                        color = colorResource(id = R.color.mainOrange),
                        shape = CircleShape
                    )
            )
            Image(painter = painterResource(id = R.drawable.suzuka),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                )
        }
}