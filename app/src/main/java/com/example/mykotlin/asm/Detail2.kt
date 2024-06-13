package com.example.demo18302.asm2

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mykotlin.R
import com.example.mykotlin.ui.theme.TextColor3
import com.example.mykotlin.ui.theme.TextColor5


class Detail {
    private val gelasioNormalFont = FontFamily(Font(R.font.gelasio_normal))

    @Composable
    fun Container(navController: NavController, string: String?) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.anh1),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(363.dp)
                        .height(450.dp)
                        .align(Alignment.BottomEnd)
                        .clip(AbsoluteRoundedCornerShape(bottomLeft = 40.dp))
                )
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(130.dp)
                        .align(Alignment.TopStart)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.xem2),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.TopStart)
                            .clickable {
                                navController.popBackStack()
                            }
                    )

                }

                Image(
                    painter = painterResource(id = R.drawable.chuong),
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
                    text = "Minimal Ancs",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
//                    color = TextColor3,
//                    fontFamily = gelasioNormalFont,
                    modifier = Modifier
                        .padding(top = 15.dp, bottom = 15.dp)

                )
                Text(
                    text = "$ 50",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
//                       color = TextColor3,
//                       fontFamily = gelasioNormalFont,
                    )

                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.nha),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)

                    )
                    Text(
                        text = "4.5",
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
                    text ="Product is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home. ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
//                    color = TextColor5,
//                    fontFamily = gelasioNormalFont,
                    modifier = Modifier
                        .padding(top = 5.dp)
                )

            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.End)
            ) {
                Text(text = "Floating Button")
            }
        }
    }
}