package com.example.demo18302.asm2.bottomScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.decode.ImageSource
import com.example.mykotlin.R


class Home {
//    private val gelasioNormalFont = FontFamily(Font(R.font.gelasio_normal))



    data class Cate(
        val name: String,
        val image: Int
    )

    val cates = listOf(
        Cate(
            "Popular",
             R.drawable.nha
        ), Cate(
            "Chair",
            R.drawable.nha2
        ), Cate(
            "Table",
            R.drawable.xem2
        ), Cate(
            "Armchair",
            R.drawable.chuong
        ), Cate(
            "Bed",
            R.drawable.canhan
        ),Cate(
            "Lam",
            R.drawable.canhan2
        ),
    )

    data class Product(
        val name: String,
        val image: Int,
        val price:Float
    )

    val products = listOf(
        Product(
            "Black Simple Lamp",
            R.drawable.anhlab2,
            12f
        ),
        Product(
            "Minimal Stand",
            R.drawable.nha,
            25f
        ),
        Product(
            "Coffee Chair",
            R.drawable.nha2,
            20f
        ),
        Product(
            "Simple Desk",
            R.drawable.xem2,
            50f
        ), Product(
            "Black Simple Lamp",
            R.drawable.chuong,
            12f
        ),
        Product(
            "Minimal Stand",
            R.drawable.canhan,
            25f
        ),
        Product(
            "Coffee Chair",
            R.drawable.canhan2,
            20f
        ),
    )



    @Composable
    fun Container(goToScreen: (String) -> Unit) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 38.dp)
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
                            painter = painterResource(id = R.drawable.anh1),
                            contentDescription = "Sample Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .width(24.dp)
                                .height(24.dp)
                                .clip(RoundedCornerShape(8.dp))
                        )
                    Column( horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Make Home",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
//                            color = TextColor2,
//                            fontFamily = gelasioNormalFont,


                        )
                        Text(
                            text = "beautiful".uppercase(),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
//                            color = TextColor3,
//                            fontFamily = gelasioNormalFont,


                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.anh1),
                        contentDescription = "Sample Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .width(24.dp)
                            .height(24.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )


                }

                Main()
            }
        }
    }
        @Composable
        fun Main() {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 50.dp)
            ) {
                LazyRow(modifier = Modifier.padding(top = 15.dp)) {
                    items(cates.size) { index ->
                        CateItem(cates[index])
                    }

                }
                LazyColumn(modifier = Modifier.padding(top = 10.dp)) {
                    items((products.size + 1) / 2) {
                        rowIndex ->
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth().padding(top = 15.dp)
                            ) {
                                val index1 = rowIndex * 2
                                val index2 = index1 + 1
                                if (index1 < products.size) {
    //                                ProductItem(products[index1],goToScreen)
                                }
                                if (index2 < products.size) {
    //                                ProductItem(products[index2],goToScreen)
                                }
                            }
                    }
                }

                }
        }
            @Composable
            fun CateItem(cate: Cate) {
                Column( horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.padding(end = 10.dp)) {
                    Image(
                        painter = painterResource(id = cate.image),
                        contentDescription = cate.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .width(44.dp)
                            .height(44.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Text(
                        text = cate.name,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
//                        color = TextColor3,
//                        fontFamily = gelasioNormalFont,
                    )
        }
    }

    @Composable
    fun ProductItem(product: Product,goToScreen: (String) -> Unit) {
        Column(
            modifier = Modifier.padding(horizontal = 10.dp)) {
            Box(modifier = Modifier.clickable { goToScreen("detail/${product.name}") }) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = product.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(167.dp)
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Image(
                    painter = painterResource(id = R.drawable.anh1),
                    contentDescription = "Small Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .padding(10.dp)
                        .align(Alignment.BottomEnd)
                )
            }

            Text(
                text = product.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
//                color = TextColor1,
                        modifier = Modifier
                        .padding(top = 5.dp)
            )
            Text(
                text = "$ "+product.price,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
//                color = TextColor3,

                modifier = Modifier
                    .padding(top = 0.dp)
            )
        }
    }

}