package com.example.quad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.example.quad.ui.theme.QuadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //MyComplexLayout()
                    MyStateExample()
                }
            }
        }
    }
}



@Composable
fun MyStateExample(){
    var counter = remember{ mutableStateOf(0) } ;
    Column(Modifier.fillMaxSize() ,
                    verticalArrangement = Arrangement.Center ,
                    horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { counter.value += 1}) {
            Text("Pulsar")
        }
        Text(text = "He sido pulsado ${counter.value} veces")
    }

}

@Composable
fun MyComplexLayout(){
    Column (Modifier.fillMaxSize()){
        Box(Modifier.fillMaxWidth().weight(1f).background(Color.Cyan), contentAlignment = Alignment.Center){
            Text("Ejemplo1")
        }
        MySpacer(size = 30)
        //Spacer(modifier = Modifier.width(0.dp).height(30.dp))
        Row (Modifier.fillMaxWidth().weight(1f)){
            Box(modifier = Modifier.weight(1f).fillMaxHeight().background(Color.Yellow), contentAlignment = Alignment.Center){
                Text("Ejemplo2")
            }
            Box(modifier = Modifier.weight(1f).fillMaxHeight().background(Color.Blue), contentAlignment = Alignment.Center){
                Text("Hola mi perro")
            }
        }
        MySpacer(size = 80)
        Box(Modifier.fillMaxWidth().weight(1f).background(Color.Magenta), contentAlignment = Alignment.CenterEnd    ){
            Text("Ejemplo4")
        }
    }
}

@Composable
fun MySpacer(size: Int){
    Spacer(Modifier.height(size.dp))
}


@Composable
fun MyRow(){
    /*Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = "Ejemplo 1")
        Text(text = "Ejemplo 2")
        Text(text = "Ejemplo 3")
    }*/
    Row(Modifier.fillMaxSize().horizontalScroll(rememberScrollState())){
        Text(text = "Ejemplo 1" , modifier = Modifier.width( 100.dp))
        Text(text = "Ejemplo 1" , modifier = Modifier.width( 100.dp))
        Text(text = "Ejemplo 1" , modifier = Modifier.width( 100.dp))
        Text(text = "Ejemplo 1" , modifier = Modifier.width( 100.dp))
        Text(text = "Ejemplo 1" , modifier = Modifier.width( 100.dp))
        Text(text = "Ejemplo 1" , modifier = Modifier.width( 100.dp))
        Text(text = "Ejemplo 1" , modifier = Modifier.width( 100.dp))
        Text(text = "Ejemplo 1" , modifier = Modifier.width( 100.dp))
        Text(text = "Ejemplo 1" , modifier = Modifier.width( 100.dp))

    }


}

@Composable
fun MyColumn(){
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween ) {
        Text("Ejemplo 1", modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
        Text("Ejemplo 1", modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
        Text("Ejemplo 1", modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
        Text("Ejemplo 1", modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
        Text("Ejemplo 1", modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
        Text("Ejemplo 1", modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
        Text("Ejemplo 1", modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
        Text("Ejemplo 1", modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
        Text("Ejemplo 1", modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
        Text("Ejemplo 1", modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
        Text("Ejemplo 1", modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
        Text("Ejemplo 1", modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))



    }

}

@Composable
fun MyBox(name: String, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Box(modifier = Modifier.
                        width(200.dp).
                        height(200.dp).
                        background(Color.Cyan).
                        verticalScroll(rememberScrollState()),
                        contentAlignment = Alignment.Center
                        ){
            Text("Esto es un ejemplo")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuadTheme {
        MyComplexLayout()
    }
}