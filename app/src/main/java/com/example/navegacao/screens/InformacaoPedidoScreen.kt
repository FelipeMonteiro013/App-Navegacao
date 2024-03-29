package com.example.navegacao.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
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
fun InformacaoPedidosScreen(
    navController: NavController,
    numPedido: String,
    nome: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFF9800))
            .padding(32.dp)
    ) {
        Text(
            text = "INFORMAÇÃO PEDIDO",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column {

                    Text(
                        text = "$numPedido | $nome", fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }


            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("pedidos?numPedido=4561") },
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