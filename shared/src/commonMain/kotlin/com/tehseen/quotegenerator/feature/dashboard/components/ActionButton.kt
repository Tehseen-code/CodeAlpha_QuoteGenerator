package com.tehseen.quotegenerator.feature.dashboard.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ActionButton(
    text: String,
    onClick: () ->Unit,
    isTransparent: Boolean = false
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isTransparent) Color.Transparent else Color(0xFF4F46E5)
        ),
        shape = RoundedCornerShape(24.dp),
        border = if (isTransparent) BorderStroke(1.dp, Color(0xFFCBD5E1)) else null,
        modifier = Modifier.fillMaxWidth().height(56.dp)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = if (isTransparent) Color(0xFF475569) else Color.White
        )
    }
}