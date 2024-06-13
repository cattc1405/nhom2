package com.example.mykotlin.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import com.example.demo18302.asm2.bottomScreens.Home
import com.example.mykotlin.R
import com.example.mykotlin.httpmodels.ProductModel
import com.example.mykotlin.model.Cart
import com.example.mykotlin.ui.theme.BgrXam3
import com.example.mykotlin.ui.theme.TextColor3
import com.example.mykotlin.ui.theme.TextColor4
import com.example.mykotlin.ui.theme.TextColor5

class Cart {

    private val gelasioNormalFont = FontFamily(Font(R.font.gelasio_normal))
    private val merriweatherregular = FontFamily(Font(R.font.merriweather_regular))


    data class Product(
        val id: String,
        val name: String,
        val image: Int,
        val price: Float
    ) val products = listOf(

        Product(
            "2",
            "Minimal Stand",
            R.drawable.nha,
            25f
        ),
        Product(
            "3",
            "Coffee Chair",
            R.drawable.anh1,
            20f
        ),
        Product(
            "4",
            "Simple Desk",
            R.drawable.star,
            50f
        )
    )




    @Composable
    fun Container(goToScreen: (String) -> Unit,clearCart: () -> Unit) {




        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "",
                        modifier = Modifier
                            .width(100.dp)
                            .height(100.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                goToScreen("home")
                            }
                    )


                    Text(
                        text = "My cart",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextColor3,
                        fontFamily = merriweatherregular,

                        )
                    Spacer(modifier = Modifier.size(100.dp))

                }

                Main(goToScreen = goToScreen,clearCart=clearCart)
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Main(goToScreen: (String) -> Unit,clearCart: () -> Unit) {

        var product by remember {
            mutableStateOf(
                ProductModel(
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
                )
            )
        }

        val textState = remember { mutableStateOf("") }
        val cartItems = remember { mutableStateOf(products) }

        Box(modifier = Modifier
            .fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                LazyColumn(modifier = Modifier.padding(bottom = 15.dp)) {
                    items(products.size) { index ->
                        ProductItem(products[index])
                    }
                }
            }

            Column(
                modifier = Modifier

                    .fillMaxWidth()
                    .padding(bottom = 15.dp)
                    .align(Alignment.BottomEnd)
            ) {

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                        .fillMaxWidth()
                ) {
                    TextField(

                        value = textState.value,
                        onValueChange = { textState.value = it },
                        label = { Text("Enter Your Promo Code") },
                        modifier = Modifier
                            .padding(vertical = 0.dp, horizontal = 15.dp)
                            .width(320.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = BgrXam3

                        )
                    )
                    Image(
                        painter = painterResource(id = R.drawable.nha2),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(54.dp)
                            .height(50.dp)
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp, horizontal = 10.dp)
                ) {
                    Text(
                        text = "Total:",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
//                        color = TextColor5

                    )
                    Text(
                        text = "$ 95.00",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextColor3

                    )
                }
                Button(
                    onClick = {
//                        clearCart()
                        goToScreen("congrats")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = TextColor3,
                        contentColor = TextColor4
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .height(55.dp)
                        .fillMaxWidth()


                ) {
                    Text(text = "Check out", fontSize = 20.sp)
                }
            }
        }
    }


    @Composable
    fun ProductItem(product: Product) {
        Column {

            Row(
                modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 15.dp)
            ) {

                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = product.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clip(RoundedCornerShape(8.dp))

                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp)
                ) {

                    Column {
                        Text(
                            text = product.name,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = TextColor5

                        )

                        Text(
                            text = "$ " + product.price,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
//                            color = TextColor3,
                            modifier = Modifier
                                .padding(vertical = 12.dp)
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                                .width(100.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.anh1),
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .width(30.dp)
                                    .height(30.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .padding(end = 5.dp)

                            )
                            Text(
                                text = "1",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextColor3,
                                fontFamily = gelasioNormalFont,
                                modifier = Modifier
                                    .padding(horizontal = 5.dp)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.cong),
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .width(30.dp)
                                    .height(30.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .padding(start = 5.dp)
                                    .clickable {

                                    },

                            )
                        }

                    }
                }
            }
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .background(TextColor3)
                    .weight(1f)
                    .fillMaxWidth()
            )
        }
    }
}