package com.example.zaroyunu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.zaroyunu.ui.theme.DiceRollerTheme

@Composable
fun Anasayfa(navController: NavController){
    Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly){
        Surface (color = Color.White) {
            Image(
                painter = painterResource(R.drawable._593240364_2)
                , contentDescription = "1", contentScale = ContentScale.Fit
            )
        }
        Surface (color = Color.White) {
            Text(text = stringResource(R.string.baslık), fontSize = 36.sp )
        }
        Button(onClick = {navController.navigate("OyunKurallari")}, colors = ButtonDefaults.buttonColors(containerColor = Color.Black )) {
            Text(stringResource(R.string.oyunKuralları))
        }
        Button(onClick = {navController.navigate("OyunSayfasi")}, colors = ButtonDefaults.buttonColors(containerColor = Color.Black )) {
            Text(stringResource(R.string.oyunaBasla))
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview4() {
    DiceRollerTheme {
        Anasayfa(rememberNavController())
    }
}