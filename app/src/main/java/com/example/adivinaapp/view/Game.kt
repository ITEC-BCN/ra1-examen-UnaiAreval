package com.example.adivinaapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import kotlin.random.Random


@Composable
fun GameScreen(navCont: NavController) {
    val number = remember { mutableStateOf(Random.nextInt(1, 10)) }

    val triedNums = remember { mutableStateOf("") }
    val userNum = remember { mutableStateOf(1) }
    val gameFinalized = remember { mutableStateOf(false) }
    val errors = remember { mutableStateOf(0) }

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (secretNum, errorBox, numSet, goMenu, checkAndRestart, success) = createRefs()

        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(size = 20.dp))
                .border(
                    shape = RoundedCornerShape(size = 20.dp),
                    color = Color.Black,
                    width = 2.dp
                )
                .background(color = Color.White)
                .constrainAs(secretNum) {
                    bottom.linkTo(numSet.top, margin = 140.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ){
            if (gameFinalized.value) {
                Text("${number.value}", textAlign = TextAlign.Center, modifier = Modifier.align(alignment = Alignment.Center))
            } else {
                Text("?", textAlign = TextAlign.Center, modifier = Modifier.align(alignment = Alignment.Center))
            }
        }

        if (errors.value > 0) {
            Box(
                modifier = Modifier
                    .size(height = 80.dp, width = 200.dp)
                    .clip(RoundedCornerShape(size = 20.dp))
                    .border(
                        shape = RoundedCornerShape(size = 20.dp),
                        color = Color.Black,
                        width = 2.dp
                    )
                    .background(color = Color.White)
                    .constrainAs(errorBox) {
                        bottom.linkTo(numSet.top, margin = 20.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Text(
                    "Números utilitzats: ${triedNums.value} \n Nombre d'errors: ${errors.value}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(alignment = Alignment.Center)
                )
            }
        }

        //TextField(        Inside the onValueChange it don't recognize the 'it' value
        //    value = userNum.value,
        //    onValueChange = { userNum.value = it },
        //    label = Text("Introdueix el nombre"),
        //    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        //)
        ConstraintLayout(
            modifier = Modifier
                .size(width = 200.dp, height = 290.dp)
                .clip(RoundedCornerShape(size = 20.dp))
                .background(color = Color.White)
                .border(
                    shape = RoundedCornerShape(size = 20.dp),
                    color = Color.Black,
                    width = 5.dp
                )
                .constrainAs(numSet) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            val (askNum, one, two, three, four, five, six, seven, eight, nine, yourNumber) = createRefs()

            Box(
                modifier = Modifier
                    .size(width = 180.dp, height = 50.dp)
                    .clip(RoundedCornerShape(size = 20.dp))
                    .background(color = Color.LightGray)
                    .constrainAs(askNum) {
                        top.linkTo(parent.top, margin = 15.dp)
                        end.linkTo(parent.end, margin = 15.dp)
                        start.linkTo(parent.start, margin = 15.dp)
                    }
            ){ Text("Selecciona un número", textAlign =  TextAlign.Center, modifier = Modifier.align(alignment = Alignment.Center)) }

            Box(
                modifier = Modifier
                    .clickable { if (!gameFinalized.value) userNum.value = 1 }
                    .size(40.dp)
                    .clip(RoundedCornerShape(size = 20.dp))
                    .background(color = Color.LightGray)
                    .constrainAs(one) {
                        top.linkTo(askNum.bottom, margin = 15.dp)
                        start.linkTo(askNum.start)
                    }
            ){ Text("1", textAlign = TextAlign.Center, modifier = Modifier.align(alignment = Alignment.Center)) }

            Box(
                modifier = Modifier
                    .clickable {  if (!gameFinalized.value) userNum.value = 2 }
                    .size(40.dp)
                    .clip(RoundedCornerShape(size = 20.dp))
                    .background(color = Color.LightGray)
                    .constrainAs(two) {
                        top.linkTo(askNum.bottom, margin = 15.dp)
                        start.linkTo(one.end, margin = 15.dp)
                        end.linkTo(three.start, margin = 15.dp)
                    }
            ){ Text("2", textAlign = TextAlign.Center, modifier = Modifier.align(alignment = Alignment.Center)) }

            Box(
                modifier = Modifier
                    .clickable { if (!gameFinalized.value) userNum.value = 3 }
                    .size(40.dp)
                    .clip(RoundedCornerShape(size = 20.dp))
                    .background(color = Color.LightGray)
                    .constrainAs(three) {
                        top.linkTo(askNum.bottom, margin = 15.dp)
                        end.linkTo(askNum.end)
                    }
            ){ Text("3", textAlign = TextAlign.Center, modifier = Modifier.align(alignment = Alignment.Center)) }

            Box(
                modifier = Modifier
                    .clickable { if (!gameFinalized.value) userNum.value = 4 }
                    .size(40.dp)
                    .clip(RoundedCornerShape(size = 20.dp))
                    .background(color = Color.LightGray)
                    .constrainAs(four) {
                        top.linkTo(one.bottom, margin = 15.dp)
                        start.linkTo(askNum.start)
                    }
            ){ Text("4", textAlign = TextAlign.Center, modifier = Modifier.align(alignment = Alignment.Center)) }

            Box(
                modifier = Modifier
                    .clickable { if (!gameFinalized.value) userNum.value = 5 }
                    .size(40.dp)
                    .clip(RoundedCornerShape(size = 20.dp))
                    .background(color = Color.LightGray)
                    .constrainAs(five) {
                        top.linkTo(two.bottom, margin = 15.dp)
                        start.linkTo(four.end, margin = 15.dp)
                        end.linkTo(six.start, margin = 15.dp)
                    }
            ){ Text("5", textAlign = TextAlign.Center, modifier = Modifier.align(alignment = Alignment.Center)) }

            Box(
                modifier = Modifier
                    .clickable { if (!gameFinalized.value) userNum.value = 6 }
                    .size(40.dp)
                    .clip(RoundedCornerShape(size = 20.dp))
                    .background(color = Color.LightGray)
                    .constrainAs(six) {
                        top.linkTo(three.bottom, margin = 15.dp)
                        end.linkTo(askNum.end)
                    }
            ){ Text("6", textAlign = TextAlign.Center, modifier = Modifier.align(alignment = Alignment.Center)) }

            Box(
                modifier = Modifier
                    .clickable { if (!gameFinalized.value) userNum.value = 7 }
                    .size(40.dp)
                    .clip(RoundedCornerShape(size = 20.dp))
                    .background(color = Color.LightGray)
                    .constrainAs(seven) {
                        top.linkTo(four.bottom, margin = 15.dp)
                        start.linkTo(askNum.start)
                    }
            ){ Text("7", textAlign = TextAlign.Center, modifier = Modifier.align(alignment = Alignment.Center)) }

            Box(
                modifier = Modifier
                    .clickable { if (!gameFinalized.value) userNum.value = 8 }
                    .size(40.dp)
                    .clip(RoundedCornerShape(size = 20.dp))
                    .background(color = Color.LightGray)
                    .constrainAs(eight) {
                        top.linkTo(five.bottom, margin = 15.dp)
                        start.linkTo(seven.end, margin = 15.dp)
                        end.linkTo(nine.start, margin = 15.dp)
                    }
            ){ Text("8", textAlign = TextAlign.Center, modifier = Modifier.align(alignment = Alignment.Center)) }

            Box(
                modifier = Modifier
                    .clickable { if (!gameFinalized.value) userNum.value = 9 }
                    .size(40.dp)
                    .clip(RoundedCornerShape(size = 20.dp))
                    .background(color = Color.LightGray)
                    .constrainAs(nine) {
                        top.linkTo(six.bottom, margin = 15.dp)
                        end.linkTo(askNum.end)
                    }
            ){ Text("9", textAlign = TextAlign.Center, modifier = Modifier.align(alignment = Alignment.Center)) }

            Box(
                modifier = Modifier
                    .size(height = 45.dp, width = 110.dp)
                    .clip(RoundedCornerShape(size = 20.dp))
                    .border(
                        shape = RoundedCornerShape(size = 20.dp),
                        color = Color.Black,
                        width = 1.dp
                    )
                    .background(color = Color.LightGray)
                    .constrainAs(yourNumber) {
                        top.linkTo(eight.bottom, margin = 10.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom, margin = 15.dp)
                    }
            ){ Text("Número seleccionat: ${userNum.value}", textAlign = TextAlign.Center, modifier = Modifier.align(alignment = Alignment.Center)) }
        }

        if (errors.value < 9 && gameFinalized.value) {
            Text(
                "Has encertat!!!!!!",
                textAlign = TextAlign.Center,
                color = Color.Yellow,
                modifier = Modifier.constrainAs(success) {
                    top.linkTo(numSet.bottom, margin = 30.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
        }

        Button(
            onClick = {
                if (gameFinalized.value) navCont.navigate("Game")
                if (userNum.value != number.value) {
                    errors.value++
                    triedNums.value += "${userNum.value}, "
                }
                else gameFinalized.value = true
                if (errors.value > 9) gameFinalized.value = true
            },
            modifier = Modifier
                .constrainAs(checkAndRestart){
                    top.linkTo(numSet.bottom, margin = 50.dp)
                    start.linkTo(parent.start)
                    end.linkTo(goMenu.start)
                }
        ) {
            if (gameFinalized.value){
                Text("Tornar a jugar")
            } else {
                Text("Probar sort")
            }
        }

        Button(
            onClick = {
                navCont.navigate("Menu")
            },
            modifier = Modifier
                .constrainAs(goMenu){
                    top.linkTo(numSet.bottom, margin = 50.dp)
                    end.linkTo(parent.end)
                    start.linkTo(checkAndRestart.end)
                }
        ) {
            Text("Tornar al menu")
        }
    }
}