package com.example.zaroyunu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.zaroyunu.ui.theme.DiceRollerTheme

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview5() {
    DiceRollerTheme {

    }
}



@Composable
fun SonucEkrani(navController: NavController, gelenSonuc:Boolean , sistemAtis:Int ,toplamSayi:Int) {
    Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly){


        val imageModifier = Modifier
            .size(180.dp)
            .align(Alignment.CenterHorizontally)

        if (gelenSonuc){
            Text(text = "KAZANDINIZ!", fontSize = 36.sp)
            if (sistemAtis != 0)
            {
                Text(text = "Sistemin attığı son zardan gelen sayı: ${sistemAtis} ")
            }
            Text(text = "Toplam Sayı : ${toplamSayi}")
            Image(painter = painterResource(id = R.drawable.baseline_emoji_emotions_24),
                contentDescription = "açıklama",modifier = imageModifier)
        }
        else{
            Text(text = "KAYBETTİN!", fontSize = 36.sp)
            if (sistemAtis != 0)
            {
                Text(text = "Sistemin attığı son zardan gelen sayı: ${sistemAtis} ")
            }
            Text(text = "Toplam Sayı : ${toplamSayi}")
            Image(painter = painterResource(id = R.drawable.baseline_mood_bad_24),
                contentDescription = "açıklama",modifier = imageModifier)


        }

    }
}


