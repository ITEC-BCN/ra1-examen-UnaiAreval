package com.example.adivinaapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.adivinaapp.R

@Composable
fun MenuScreen(navCont: NavController) {

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (title, image, startGame) = createRefs()

        Text(
            "Adivina el número de Unai Arévalo",
            modifier = Modifier
                .constrainAs(title){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top, margin = 100.dp)
                }
        )

        Image(
            painter = painterResource(R.drawable.ic_game),
            contentDescription = "Menu Image",
            modifier = Modifier
                .size(80.dp)
                .constrainAs(image){
                  start.linkTo(parent.start)
                  end.linkTo(parent.end)
                  top.linkTo(title.bottom, margin = 40.dp)
                }

        )

        Button(
            onClick = { navCont.navigate("Game") },
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(startGame){
                    end.linkTo(parent.end, margin = 20.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                    top.linkTo(image.bottom, margin = 40.dp)
                }
        ) {
            Text("Iniciar Partida")
        }
    }
}