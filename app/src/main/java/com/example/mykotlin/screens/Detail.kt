package com.example.mykotlin.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.mykotlin.R
import com.example.mykotlin.helpers.RetrofitAPI
import com.example.mykotlin.httpmodels.ProductDetailReponseModel
import com.example.mykotlin.httpmodels.ProductModel
import com.example.mykotlin.model.Cart
import com.example.mykotlin.ui.theme.TextColor1
import com.example.mykotlin.ui.theme.TextColor3
import com.example.mykotlin.ui.theme.TextColor4
import com.example.mykotlin.ui.theme.TextColor5


class Detail {
    private val gelasioNormalFont = FontFamily(Font(R.font.gelasio_normal))

    @Composable
    fun Container(value: String?,navController: NavController, updateCart: (Cart) -> Unit) {

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

        fun getProductCallback(result: ProductDetailReponseModel?) {
            if (result != null) {
                product = result.product
            }
        }

        fun getProductById() {
            try {
                val api = RetrofitAPI()
                api.getProductByID(value, ::getProductCallback)
            } catch (e: Exception) {

            }
        }
        getProductById()
        Box( modifier = Modifier
            .fillMaxSize()){


        Column {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = product.image,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(360.dp)
                        .height(400.dp)
                        .align(Alignment.BottomEnd)
                        .clip(AbsoluteRoundedCornerShape(bottomLeft = 40.dp))
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 35.dp, horizontal = 30.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top,

                    )
                {

                Row(
                    modifier = Modifier
                        .height(38.dp)
                        .shadow(8.dp, shape = MaterialTheme.shapes.medium)
                        .background(Color.White, shape = RoundedCornerShape(16.dp)),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.back),
                        modifier = Modifier
                            .size(38.dp)
                            .background(Color.White, shape = RoundedCornerShape(12.dp))
                            .clickable {
                                navController.popBackStack()
                            },
                        contentDescription = ""
                    )
                }
                }

                Image(
                    painter = painterResource(id = R.drawable.color),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(98.dp)
                        .height(192.dp)
                        .padding(start = 20.dp)
                        .align(Alignment.CenterStart)
                )
            }


            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
            ) {
                Text(
                    text = "${product.name}",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextColor3,
                    fontFamily = gelasioNormalFont,
                    modifier = Modifier
                        .padding(top = 15.dp, bottom = 15.dp)
                )
                Text(
                    text = "$ ${product.price}",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                       color = TextColor3,
                       fontFamily = gelasioNormalFont,
                )
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.star3),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)

                    )

                    Text(
                        text = "${product.rating}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextColor3,
                        fontFamily = gelasioNormalFont,
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                    )
                    Text(
                        text = "(50 reviews)",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextColor5,
                        fontFamily = gelasioNormalFont,

                        modifier = Modifier

                            .padding(start = 35.dp)
                    )
                }


                Text(
                    text = "Description: ${product.description}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = TextColor5,
                    fontFamily = gelasioNormalFont,
                    modifier = Modifier
                        .padding(top = 5.dp)
                )



            }
        }
            Button(
                onClick = {
                    var item = Cart(product, 1)
                    updateCart(item)
                },

            colors = ButtonDefaults.buttonColors(
                containerColor = TextColor3,
                contentColor = TextColor4

            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .shadow(8.dp, shape = MaterialTheme.shapes.medium)

                .height(55.dp)
                .fillMaxWidth()
                .padding(bottom = 16.dp, start = 10.dp,end=10.dp)
                .align(Alignment.BottomEnd)



            ) {
            Text(text = "Add to cart")
        }
        }
    }
}