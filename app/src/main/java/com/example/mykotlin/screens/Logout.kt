package com.example.mykotlin.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.mykotlin.R
import com.example.mykotlin.model.UserInfo
import com.example.mykotlin.ui.theme.BgrXam3
import com.example.mykotlin.ui.theme.TextColor3
import com.example.mykotlin.ui.theme.TextColor4
import com.example.mykotlin.ui.theme.TextColor5

class Profile2 {

    private val gelasioNormalFont = FontFamily(Font(R.font.gelasio_normal))
    private val merriweatherregular = FontFamily(Font(R.font.merriweather_regular))
    private val nunitorsansNormalFont = FontFamily(Font(R.font.nunitorsans_normal))


    @Composable
    fun Container(saveUserInfo: (UserInfo) -> Unit) {
        Column ( modifier = Modifier
            .fillMaxSize()

            .background(BgrXam3)){


            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 28.dp)
                    .background(BgrXam3)
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
                            .fillMaxWidth().height(50.dp)
                    ) {


                        Image(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .width(24.dp)
                                .height(24.dp)
                                .clip(RoundedCornerShape(8.dp))
                        )
                        Text(
                            text = "Profile",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextColor3,
                            fontFamily = merriweatherregular,
                        )

                        Image(
                            painter = painterResource(id = R.drawable.logout),
                            contentDescription = " ",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .width(24.dp)
                                .height(24.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .clickable {
                                                            saveUserInfo(UserInfo(null, null, null, null))

                                }
                        )




                    }

                    Main()
                }
            }}
    }
    @Composable
    fun Main() {
        Column {
            Row ( modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp)
                .height(80.dp)){
                Image(
                    painter = painterResource(id = R.drawable.blong),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)
                        .clip(RoundedCornerShape(40.dp))
                )
                Column (verticalArrangement = Arrangement.Center,modifier = Modifier
                    .padding(start = 15.dp)
                    .fillMaxHeight()){
                    Text(
                        text = "Bruno Pham",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextColor3,
                        fontFamily = merriweatherregular,

                        )
                    Text(
                        text = "bruno203@gmail.com",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = TextColor3,
                        fontFamily = merriweatherregular,
                        modifier = Modifier
                            .padding(top = 5.dp)
                    )
                }
            }
            Box ( modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp)
                .height(80.dp)
                .background(TextColor4)
                .shadow(0.2.dp, RoundedCornerShape(1.dp))
                .clip(RoundedCornerShape(8.dp))){

                Column (verticalArrangement = Arrangement.Center,modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 10.dp)){
                    Text(
                        text = "My Orders",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextColor3,
                        fontFamily =nunitorsansNormalFont ,

                        )
                    Text(
                        text = "Already have 10 orders",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Thin,
                        color = TextColor5,
                        fontFamily = merriweatherregular,
                        modifier = Modifier
                            .padding(top = 0.dp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.blackrightarrow),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .align(Alignment.CenterEnd)
                        .padding(end = 10.dp)
                )
            }

            Box ( modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
                .height(80.dp)
                .background(TextColor4)
                .shadow(0.2.dp, RoundedCornerShape(1.dp))
                .clip(RoundedCornerShape(8.dp))){

                Column (verticalArrangement = Arrangement.Center,modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 10.dp)){
                    Text(
                        text = "Shipping Addresses",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextColor3,
                        fontFamily =nunitorsansNormalFont ,

                        )
                    Text(
                        text = "4 Addresses",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Thin,
                        color = TextColor5,
                        fontFamily = merriweatherregular,
                        modifier = Modifier
                            .padding(top = 0.dp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.blackrightarrow),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .align(Alignment.CenterEnd)
                        .padding(end = 10.dp)
                )
            }
            Box ( modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
                .height(80.dp)
                .background(TextColor4)
                .shadow(0.2.dp, RoundedCornerShape(1.dp))
                .clip(RoundedCornerShape(8.dp))){

                Column (verticalArrangement = Arrangement.Center,modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 10.dp)){
                    Text(
                        text = "Payment Method",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextColor3,
                        fontFamily =nunitorsansNormalFont ,

                        )
                    Text(
                        text = "You have 2 cards",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Thin,
                        color = TextColor5,
                        fontFamily = merriweatherregular,
                        modifier = Modifier
                            .padding(top = 0.dp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.blackrightarrow),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .align(Alignment.CenterEnd)
                        .padding(end = 10.dp)
                )
            }
            Box ( modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
                .height(80.dp)
                .background(TextColor4)
                .shadow(0.2.dp, RoundedCornerShape(1.dp))
                .clip(RoundedCornerShape(8.dp))){

                Column (verticalArrangement = Arrangement.Center,modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 10.dp)){
                    Text(
                        text = "My Reviews",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextColor3,
                        fontFamily =nunitorsansNormalFont ,

                        )
                    Text(
                        text = "Reviews for 5 item",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Thin,
                        color = TextColor5,
                        fontFamily = merriweatherregular,
                        modifier = Modifier
                            .padding(top = 0.dp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.blackrightarrow),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .align(Alignment.CenterEnd)
                        .padding(end = 10.dp)
                )
            }
            Box ( modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
                .height(80.dp)
                .background(TextColor4)
                .shadow(0.2.dp, RoundedCornerShape(1.dp))
                .clip(RoundedCornerShape(8.dp))){

                Column (verticalArrangement = Arrangement.Center,modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 10.dp)){
                    Text(
                        text = "Setting",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextColor3,
                        fontFamily =nunitorsansNormalFont ,

                        )
                    Text(
                        text = "Notification, Password, FAQ, Contact",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Thin,
                        color = TextColor5,
                        fontFamily = merriweatherregular,
                        modifier = Modifier
                            .padding(top = 0.dp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.blackrightarrow),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .align(Alignment.CenterEnd)
                        .padding(end = 10.dp)
                )
            }
        }
    }
}