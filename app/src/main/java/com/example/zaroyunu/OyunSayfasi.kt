package com.example.zaroyunu

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    DiceRollerTheme {
        OyunSayfasi(rememberNavController())
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OyunSayfasi(navController: NavController) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    var result by remember { mutableStateOf(0) }
    var toplamSayi by remember { mutableStateOf(0) }
    var basmaSayisi by remember { mutableStateOf(0) }
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        val imageModifier = Modifier
            .size(72.dp)
            .background(Color.Yellow)
            .align(Alignment.CenterHorizontally)
        Image(
            painter = painterResource(R.drawable._593240364_2),
            contentDescription = "1",
            modifier = imageModifier
        )
        Surface(color = Color.White, modifier = Modifier.fillMaxWidth()) {
            Text(text = "ThreeTeen", fontSize = 24.sp, textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.height(72.dp))
        Text(text = "Gelen Sayı : ${result}", fontSize = 32.sp)
        Image(
            painter = painterResource(imageResource), contentDescription = "1"
        )
        Text(text = "Toplam Sayı : ${toplamSayi} ", fontSize = 24.sp)
        Scaffold(
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },
            floatingActionButtonPosition = FabPosition.Center,
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    containerColor = Color.Black,
                text = { Text("Zar At")}, contentColor = Color.White,
                    icon = { Icon(Icons.Filled.AddCircle, contentDescription = "") },
                    onClick = {
                        result = (1..6).random()
                        toplamSayi += result
                        basmaSayisi++
                        if (basmaSayisi == 3)
                            if (toplamSayi >= 14) {
                                var sistemAtis = 0
                                navController.navigate("SonucEkrani/false/${sistemAtis}/${toplamSayi}")
                            if (toplamSayi == 13)
                                navController.navigate("SonucEkrani/true/${sistemAtis}/${toplamSayi}")
                            } else {
                                scope.launch {
                                    val newResult = snackbarHostState
                                        .showSnackbar(
                                            message = "13 'ün altında olduğun için son atışı sistem yapacak.Sistemin atışıyıla beraber 13 ya da az olursa kaybedersin,13'ü geçerse kazanırsın",
                                            actionLabel = "TAMAM",
                                            duration = SnackbarDuration.Indefinite
                                        )
                                    when (newResult) {
                                        SnackbarResult.ActionPerformed -> {
                                            result = (1..6).random()
                                            var sistemAtis = result
                                            toplamSayi += result
                                            if (toplamSayi >= 14) {
                                                navController.navigate("SonucEkrani/true/${sistemAtis}/${toplamSayi}")
                                            } else {
                                                navController.navigate("SonucEkrani/false/${sistemAtis}/${toplamSayi}")
                                            }
                                        }
                                        SnackbarResult.Dismissed -> {
                                            var sistemAtis = result
                                            if (toplamSayi == 13) {
                                                navController.navigate("SonucEkrani/true/${sistemAtis}/${toplamSayi}")
                                            } else {
                                                navController.navigate("SonucEkrani/false/${sistemAtis}/${toplamSayi}")
                                            }
                                        }
                                    }
                                }
                            }

                    }
                )
            }
        ) {

        }
    }
}





