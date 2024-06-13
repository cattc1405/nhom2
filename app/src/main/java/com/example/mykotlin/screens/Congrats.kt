package com.example.mykotlin.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mykotlin.R
import com.example.mykotlin.ui.theme.BgrXam4
import com.example.mykotlin.ui.theme.TextColor3
import com.example.mykotlin.ui.theme.TextColor4
import com.example.mykotlin.ui.theme.TextColor5


class Congrats {
    private val merriweatherregular = FontFamily(Font(R.font.merriweather_regular))
    private val nunitorsansNormalFont = FontFamily(Font(R.font.nunitorsans_normal))
//..
    @Composable
    fun Container(goToScreen :(String) ->Unit) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxSize()
        ) {


            Text(
                text = "Success!".uppercase(),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = TextColor3,
                fontFamily = merriweatherregular,
                modifier = Modifier
                    .padding(bottom = 20.dp)
            )
                Box(  modifier = Modifier
                    .height(255.dp)) {

                    Image(
                        painter = painterResource(id = R.drawable.successbgr),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        colorFilter = ColorFilter.tint(BgrXam4),
                        modifier = Modifier
                            .width(270.dp)
                            .height(230.dp)

                    )
                    Image(
                        painter = painterResource(id = R.drawable.successchair),
                        contentDescription = "",
                        modifier = Modifier
                            .width(230.dp)
                            .height(200.dp)
                            .padding(start = 50.dp, top = 25.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.successicon),
                        contentDescription = "",
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                            .align(Alignment.BottomCenter)
                    )


            }
            Text(
                text = "Your order will be delivered soon." ,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = TextColor5,
                fontFamily =nunitorsansNormalFont ,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text =
                        "Thank you for choosing our app!",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = TextColor5,
                fontFamily =nunitorsansNormalFont ,
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = TextColor3,
                    contentColor = TextColor4
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .height(75.dp)
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)

            ) {
                Text(text = "Track Your Order", fontSize = 18.sp)
            }
            Button(
                onClick = { goToScreen("home") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = TextColor4,
                    contentColor = TextColor3
                ),
                border = BorderStroke(2.dp, TextColor3),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .height(55.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "back to home".uppercase(),fontSize = 18.sp)
            }
        }
    }

}