package com.example.mykotlin

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mykotlin.model.Cart
import com.example.mykotlin.model.UserInfo
import com.example.mykotlin.screens.Congrats
import com.example.mykotlin.screens.Detail
import com.example.mykotlin.screens.Home
import com.example.mykotlin.screens.Login
import com.example.mykotlin.screens.Signup
import com.example.mykotlin.screens.Welcome


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Body()
        }

    }
    @Composable
    fun Body(){
        val welcomeScreen = Welcome()
        val loginScreen = Login()
        val signupScreen = Signup()
        val homeScreen = Home()
        val congratsScreen = Congrats()
        val detailSreen = Detail()
        val cartScreen = com.example.mykotlin.screens.Cart()


        // hàm đọc thông tin user từ shared preferences
        fun readFromShared(): UserInfo {
            val sharedPref = getPreferences(Context.MODE_PRIVATE)
            return UserInfo(
                name = sharedPref.getString("name", null),
                email = sharedPref.getString("email", null),
                id = sharedPref.getString("id", null),
                password = null
            )
        }


        var userInfo by remember {
            mutableStateOf(readFromShared())
        }


        fun writeToShared(userFromLogin: UserInfo) {
            val sharedPref = getPreferences(Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("email", userFromLogin.email)
                putString("name", userFromLogin.name)
                putString("id", userFromLogin.id)
                apply()
            }
            userInfo = userFromLogin
        }

        val navController = rememberNavController()

        // hàm chuyển màn hình
        fun goToScreen(screen: String) {
            navController.navigate(screen)
        }

        // thong tin giỏ hàng
        var cartInfo by remember {
            mutableStateOf(listOf<Cart>())
        }


        // hàm cập nhật giỏ hàng
        fun updateCart(item: Cart) {
            // kiểm tra item có trong giỏ hàng chưa
            val index = cartInfo.indexOfFirst { it.product._id == item.product._id }
            if (index == -1) {
                // chưa có thì thêm vào
                cartInfo = cartInfo + item
            } else {
                // có rồi thì cập nhật số lượng
                // nếu số lượng giảm về 0 thì xóa item đó
                if (item.quantity + cartInfo[index].quantity == 0) {
                    cartInfo = cartInfo.filterIndexed { i, _ -> i != index }
                } else {
                    cartInfo = cartInfo.mapIndexed { i, cart ->
                        if (i == index) {
                            Cart(
                                product = cart.product,
                                quantity = cart.quantity + item.quantity
                            )
                        } else {
                            cart
                        }
                    }
                }
            }
        }
        fun clearCart() {
            cartInfo = listOf()
        }

        NavHost(
            navController = navController,
            startDestination = if (userInfo.email.isNullOrEmpty()) "welcome"
            else "home"
        ) {
            composable("welcome") {
                welcomeScreen.Container( goToSreen = {goToScreen(it) })
            }

            composable("login") {loginScreen.Container(
                saveUserInfo = { writeToShared(it) },
                goToSreen = {goToScreen(it)}
            )}
            composable("congrats") {congratsScreen.Container(
                goToScreen = {goToScreen(it)}
            )}
            composable("home") {homeScreen.Container(
                saveUserInfo = { writeToShared(it) },
                goToSreen = {goToScreen(it)},
                cartInfo = cartInfo,
                updateCart = { updateCart(it) },
                clearCart = ::clearCart
            )}

            composable("signup") {signupScreen.Container(
                goToScreen = {goToScreen(it)}
            )}

            composable(
                "detail/{value}",
                arguments = listOf(navArgument("value") { defaultValue = "0"} )
            ){ backStackEntry ->
                detailSreen.Container(
                    backStackEntry.arguments?.getString("value"), navController ,
                            updateCart = {updateCart(it)}

                )
            }
            composable("cart") {
                cartScreen.Container(
                    goToScreen = { goToScreen(it) },
                    clearCart = { clearCart() }
                )
            }
        }

    }


    //Preview
    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        Body()
    }
}
