package com.example.zaroyunu

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.zaroyunu.ui.theme.DiceRollerTheme

@Composable
fun OyunKurallari(navController: NavController) {
    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(color = Color.White, modifier = Modifier.fillMaxWidth()) {
            Text(text = "ThreeTeen", fontSize = 36.sp, textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.height(50.dp))
        val imageModifier = Modifier
            .size(150.dp)
            .background(Color.Yellow)
            .align(Alignment.CenterHorizontally)
        Image(
            painter = painterResource(R.drawable._593240364_2),
            contentDescription = "1",
            modifier = imageModifier
        )
        Spacer(modifier = Modifier.height(50.dp))
        Surface(color = Color.White, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Oyun Kuralları", fontSize = 24.sp, textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Oyununumuz ThreeTeen'nin kuralları çok kolay, " +
                    "3 kere zar atarsınız eğer bu zarların toplamı 13 olursa oyunu kazanırsınız " +
                    "eğer 13'ü geçerseniz kaybedersiniz, 13 ün altında kalırsanız sonraki zar atışını sistem yapar sistem atışı 13'ü geçerse kazanırsınız geçmezse kaybedersiniz. "
        )
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = {navController.navigate("LogicSayfasi")}, colors = ButtonDefaults.buttonColors(containerColor = Color.Black ) ) {
            Text(stringResource(R.string.BackTo))
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview3() {
    DiceRollerTheme {
       OyunKurallari(rememberNavController())
    }
}