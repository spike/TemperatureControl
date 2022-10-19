package com.github.spike.temperaturecontrol

import android.graphics.DashPathEffect
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.spike.temperaturecontrol.ui.theme.TemperatureControlTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemperatureControlTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    ShowTemperatureControl(Modifier)
                    
                }
            }
        }
    }
}

@Composable
fun ShowControl() {
    Canvas(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black)
    ) {
        val halfScreenWidth = size.width * .5f
    }
}
@Composable
fun ShowTemperatureControl(modifier: Modifier) {
    val pinkish = Color(0xFFE9235A)
    Row (modifier = modifier.padding(20.dp)
        .background(Color.Black)
    ) {
        Column() {
            Row() {
                Icon(Icons.Default.KeyboardArrowLeft,
                    contentDescription = "",
                    tint = pinkish
                )
                Text(
                    text = "Conditioning",
                    fontSize = 16.sp,
                    color = pinkish,
                    //color=Color.Red,
                    modifier = modifier
                )
            }
            Spacer(modifier.size(40.dp))
            Text(text = "TEMPERATURE, °F",
                fontSize= 16.sp,
                color=Color.White,
                modifier=modifier.padding(start=8.dp))
            Text(text = "72",
                fontSize= 90.sp,
                color=Color.White,
                modifier=modifier.padding(start=8.dp))
        }

        DrawRedCircle(modifier)
    }
}



@Composable
fun DrawRedCircle(modifier: Modifier) {
    val centerX = WEAR_PREVIEW_DEVICE_WIDTH_DP * 1.4f
    val centerY = (WEAR_PREVIEW_DEVICE_HEIGHT_DP).toFloat()
    Canvas(
        modifier = modifier
    ) {
        drawCircle(
            color = Color(0xFFE9235A),
            center = Offset(centerX, centerY + 56.0f),
            radius = WEAR_PREVIEW_DEVICE_HEIGHT_DP.toFloat() + 80.0f,
            style = Stroke(width = 4.dp.toPx()),
        )
        drawCircle(
            color = Color(0xFFE49CB1),
            center = Offset(centerX, centerY + 56.0f),
            radius = WEAR_PREVIEW_DEVICE_HEIGHT_DP.toFloat() + 36.0f,
            style = Stroke(width = 40f,
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(2f, 20f), 0f)
            )
        )
//        drawCircle(
//            color = Color(0xFFE49CB1),
//            center = Offset(centerX, centerY + 56.0f),
//            radius = WEAR_PREVIEW_DEVICE_HEIGHT_DP.toFloat(),
//            //  style = Stroke(width = 4.dp.toPx()),
//            style = Stroke(width = 60f,
//                pathEffect = PathEffect.dashPathEffect(floatArrayOf(2f, 120f), 0f)
//            )
//        )
    }
}



// Note: Preview in Android Studio doesn't support the round view yet (coming soon).
@Preview(
    widthDp = WEAR_PREVIEW_DEVICE_WIDTH_DP,
    heightDp = WEAR_PREVIEW_DEVICE_HEIGHT_DP,
    apiLevel = WEAR_PREVIEW_API_LEVEL,
    uiMode = WEAR_PREVIEW_UI_MODE,
    backgroundColor = WEAR_PREVIEW_BACKGROUND_COLOR_BLACK,
    showBackground = WEAR_PREVIEW_SHOW_BACKGROUND
)
@Composable
fun WatchPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        ShowTemperatureControl(Modifier)

    }
}