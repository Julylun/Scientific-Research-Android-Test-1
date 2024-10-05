package com.example.nckh_test_1

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.asComposePaint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
private fun BoxShadowTest() {
    Box(modifier = Modifier
        .size(400.dp)
        .background(color = Color.Magenta), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .shadow(
                    blurAmount = 15.dp,
                    offsetX = 5.dp,
                    offsetY = 5.dp,
                    spread = 3.dp
                )
                .background(color = Color.Blue),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "A",
                fontSize = 150.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

fun Modifier.shadow(
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    blurAmount: Dp = 0.dp,
    spread: Dp = 0.dp,
    shadowColor: Color = Color.Black
): Modifier {
    return this.drawBehind {
        drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()

            if(blurAmount != 0.dp) {
                frameworkPaint.maskFilter = BlurMaskFilter(blurAmount.toPx(), BlurMaskFilter.Blur.NORMAL)
            }
            frameworkPaint.color = shadowColor.toArgb()

            val spreadPixel = spread.toPx()
            val left = (0f - spreadPixel) + offsetX.toPx()
            val top = (0f - spreadPixel) + offsetY.toPx()
            val right = size.width + spreadPixel + offsetX.toPx()
            val bottom = size.height + spreadPixel + offsetY.toPx()

            it.drawRect(
                left = left,
                top = top,
                right = right,
                bottom = bottom,
                paint = frameworkPaint.asComposePaint()
            )
        }
    }
}