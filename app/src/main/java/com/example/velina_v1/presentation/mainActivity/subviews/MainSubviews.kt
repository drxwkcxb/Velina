package com.example.velina_v1.presentation.mainActivity.subviews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
private fun SplashView(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Text(
            text = "Centered Text",
            textAlign = TextAlign.Center, // Horizontally center the text
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.White)
                .wrapContentHeight(Alignment.CenterVertically), // Vertically center the text
        )
    }
}