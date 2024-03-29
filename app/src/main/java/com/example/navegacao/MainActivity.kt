package com.example.navegacao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navegacao.screens.InformacaoPedidosScreen
import com.example.navegacao.screens.LoginScreen
import com.example.navegacao.screens.MenuScreen
import com.example.navegacao.screens.PedidosScreen
import com.example.navegacao.screens.PerfilScreen
import com.example.navegacao.ui.theme.NavegaçãoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavegaçãoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login",
                    ) {
                        composable(
                            route = "login",
                            enterTransition = {
                                slideIntoContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.End,
                                    tween(1000)
                                )
                            },
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                                    tween(1000)
                                )
                            }
                        ) {
                            LoginScreen(navController)
                        }
                        composable(
                            route = "menu",
                        ) {
                            MenuScreen(navController)
                        }

                        // Exemplo de passagem de um parametro pela rota
                        composable(
                            route = "perfil/{nome}",
                            enterTransition = {
                                slideIntoContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                                    tween(1000)
                                )
                            },
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.End,
                                    tween(1000)
                                ) + fadeOut(animationSpec = tween(1000))
                            }

                            ) {
                            val nome = it.arguments?.getString("nome")
                            PerfilScreen(navController, nome!!) // double bang
                        }

                        // Exemplo de passagem de um parametro NÃO obrigatório pela rota
                        composable(
                            route = "pedidos?numPedido={numPedido}",
                            arguments = listOf(
                                navArgument(name = "numPedido") {
                                    defaultValue = "sem valor"
                                }
                            ),
                            enterTransition = {
                                slideIntoContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                                    tween(1000)
                                )
                            },
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.End,
                                    tween(1000)
                                ) + fadeOut(animationSpec = tween(1000))
                            }
                        ) {
                            PedidosScreen(
                                navController,
                                it.arguments?.getString("numPedido")!!
                            )
                        }

                        // Exemplo de passagem de uma lista de argumentos pela rota
                        composable(
                            route = "informacaoPedido/{numPedido}/{nome}",
                            arguments = listOf(
                                navArgument("numPedido") {
                                    type = NavType.StringType
                                },
                                navArgument("nome") {
                                    type = NavType.StringType
                                }
                            ),
                            enterTransition = {
                                slideIntoContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                    tween(1000)
                                )
                            },
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Down,
                                    tween(1000)
                                ) + fadeOut(animationSpec = tween(1000))
                            }
                        ) {
                            val numPedido = it.arguments?.getString("numPedido")
                            val nome = it.arguments?.getString("nome")
                            InformacaoPedidosScreen(navController, numPedido!!, nome!!)
                        }
                    }
                }
            }
        }
    }
}
