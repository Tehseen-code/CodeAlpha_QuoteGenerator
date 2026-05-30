package com.tehseen.quotegenerator.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import quotegenerator.shared.generated.resources.Res
import quotegenerator.shared.generated.resources.compose_multiplatform
import quotegenerator.shared.generated.resources.ic_splash_logo

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFF1A2332)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(Res.drawable.ic_splash_logo),
                contentDescription = "Core Splash Design",
                modifier = Modifier.size(130.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "QUOTECANVAS",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                letterSpacing = 2.sp
            )
        }
    }
}