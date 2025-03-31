package com.example.quad

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

//@Preview
@Composable
fun ConstraintExample1(){
    ConstraintLayout(Modifier.fillMaxSize()) {

        val(boxRed , boxBlue , boxYellow, boxMagenta, boxGray) = createRefs()

        Box(modifier = Modifier.size(125.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        })
        Box(modifier = Modifier.size(125.dp).background(Color.DarkGray).constrainAs(boxGray){
            top.linkTo(boxRed.bottom)
            start.linkTo(boxRed.end)
        })

        Box(modifier = Modifier.size(125.dp).background(Color.Blue).constrainAs(boxBlue){
            top.linkTo(boxRed.bottom)
            end.linkTo(boxRed.start)
        })
        Box(modifier = Modifier.size(125.dp).background(Color.Yellow).constrainAs(boxYellow){
            bottom.linkTo(boxRed.top)
            end.linkTo(boxRed.start)
        })
        Box(modifier = Modifier.size(125.dp).background(Color.Magenta).constrainAs(boxMagenta){
            bottom.linkTo(boxRed.top)
            start.linkTo(boxRed.end)
        })
    }
}

//@Preview
@Composable
fun ConstraintEcampleGuide(){
    ConstraintLayout(Modifier.fillMaxSize()) {

        val boxRed = createRef()
        //se recomienda en porcentajes pra qque acepte todos los dispositivos
        //10%
        val topGuide = createGuidelineFromTop(0.1f);
        val startGuide = createGuidelineFromStart(0.25f);
        Box(Modifier.size(125.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(topGuide)
            start.linkTo(startGuide)
        })


    }
}

//@Preview
@Composable
fun constraintBarrier(){

    ConstraintLayout(Modifier.fillMaxSize()) {

        val (boxRed, boxYellow , boxGreen) = createRefs();
        val barrier = createEndBarrier(boxRed , boxGreen)

        Box(modifier = Modifier.size(125.dp).background(Color.Red).constrainAs(boxRed){
            start.linkTo(parent.start , margin = 16.dp)
        })
        Box(modifier = Modifier.size(75.dp).background(Color.Green).constrainAs(boxGreen){
            top.linkTo(boxRed.bottom)
            start.linkTo(parent.start , margin = 32.dp)
        })
        Box(Modifier.size(50.dp).background(Color.Yellow).constrainAs(boxYellow){
            start.linkTo(barrier)
        })

    }


}


@Preview
@Composable
fun constraintChainExample(){
    ConstraintLayout(Modifier.fillMaxSize()) {

        val (boxRed, boxYellow , boxGreen) = createRefs();


        Box(modifier = Modifier.size(75.dp).background(Color.Red).constrainAs(boxRed){
            start.linkTo(parent.start)
            end.linkTo(boxGreen.start)
        })
        Box(modifier = Modifier.size(75.dp).background(Color.Green).constrainAs(boxGreen){
            start.linkTo(boxRed.end)
            end.linkTo(boxYellow.start)

        })
        Box(Modifier.size(75.dp).background(Color.Yellow).constrainAs(boxYellow){
            start.linkTo(boxGreen.end)
            end.linkTo(parent.end)
        })

        //packed: los junta
        //createHorizontalChain(boxRed, boxGreen, boxYellow, chainStyle = ChainStyle.Packed)
        //spread: les da el mismo valor de espaciado a todos
        //createHorizontalChain(boxRed, boxGreen, boxYellow, chainStyle = ChainStyle.Spread)
        //spread: los separa los maximo posible
        createHorizontalChain(boxRed, boxGreen, boxYellow, chainStyle = ChainStyle.SpreadInside)

    }
}