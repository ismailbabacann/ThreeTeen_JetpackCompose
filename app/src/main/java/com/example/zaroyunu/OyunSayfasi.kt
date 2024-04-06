package com.example.zaroyunu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.zaroyunu.ui.theme.DiceRollerTheme


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    DiceRollerTheme {
        OyunSayfasi(rememberNavController())
    }
}

@Composable
fun OyunSayfasi(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Surface(color = Color.White, modifier = Modifier.fillMaxWidth()) {
            Text(text = "ThreeTeen", fontSize = 36.sp, textAlign = TextAlign.Center)
        }
    }
    var result by remember { mutableStateOf(0) }
    var toplamSayi by remember { mutableStateOf(0) }
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(150.dp))
        Text(text = "Gelen Sayı : ${result}")
        Image(
            painter = painterResource(imageResource), contentDescription = "1"
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            result = (1..6).random()
            toplamSayi += result
        }, colors = ButtonDefaults.buttonColors(containerColor = Color.Black)) {

            Text(stringResource(R.string.roll))
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Toplam Sayı : ${toplamSayi} " )
    }


}

