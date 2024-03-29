package com.example.navegacao.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PedidosScreen(navController: NavController, numPedido: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFAFA9A9))
            .padding(32.dp)
    ) {
        Text(
            text = "PEDIDOS - $numPedido",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            if (numPedido != "sem valor") {
                Button(
                    onClick = {
                        navController.navigate("informacaoPedido/4561/Arroz")
                    },
                    colors = ButtonDefaults.buttonColors(Color.White),
                ) {
                    Text(text = "Informação do pedido", fontSize = 20.sp, color = Color.Blue)
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            Button(
                onClick = { navController.navigate("menu") },
                colors = ButtonDefaults.buttonColors(Color.White),
            ) {
                Text(
                    text = "Voltar",
                    fontSize = 20.sp,
                    color = Color.Blue
                )
            }
        }

    }
}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//private fun PedidosScreenPreview() {
//    PedidosScreen()
//}