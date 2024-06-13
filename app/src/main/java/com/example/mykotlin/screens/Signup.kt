package com.example.mykotlin.screens

import android.content.Intent
import androidx.compose.ui.text.font.Font
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mykotlin.R
import com.example.mykotlin.asm.Login2Activity
import com.example.mykotlin.helpers.RetrofitAPI
import com.example.mykotlin.httpmodels.RegisterRequestModel
import com.example.mykotlin.httpmodels.RegisterResponseModel
import com.example.mykotlin.ui.theme.BgrXam2
import com.example.mykotlin.ui.theme.TextColor2
import com.example.mykotlin.ui.theme.TextColor3
import com.example.mykotlin.ui.theme.TextColor4
import com.example.mykotlin.ui.theme.TextColor5

class Signup {
    private val nunitorsansNormalFont = FontFamily(Font(R.font.nunitorsans_normal))
    private val merriweather_regular = FontFamily(Font(R.font.merriweather_regular))

    @Composable
    fun Container(goToScreen:(String)->Unit) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 38.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Divider(
                        color = Color.Gray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 10.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.anh1),
                        contentDescription = "Sample Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .width(80.dp)
                            .height(80.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )

                    Divider(
                        color = Color.Gray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 10.dp)
                    )
                }

                Main(goToScreen=goToScreen)
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Main(goToScreen:(String)->Unit) {

        val context = LocalContext.current
        var email by remember { mutableStateOf("nam123@gmail.com") }
        var password by remember { mutableStateOf("1") }
        var name by remember { mutableStateOf("nguyen nam") }

        var passwordConfirm = remember { mutableStateOf("") }


        fun registerCallback(response: RegisterResponseModel?) {
            Toast.makeText(context, "Register success", Toast.LENGTH_SHORT).show()
            goToScreen("login")
        }

        fun onClickRegister() {
            try {
                val retrofitAPI = RetrofitAPI()
                val body = RegisterRequestModel(
                    name = name, email = email,
                    password = password
                )
                retrofitAPI.register(body = body, callback = { registerCallback(it) })
            } catch (e: Exception) {
                Log.d(">>>>>>", "Failed to register: ${e.message}")
            }
        }

        Column {

            Text(
                text = "Welcome".uppercase(),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = TextColor2,
                fontFamily = merriweather_regular,
                modifier = Modifier
                    .padding(start = 40.dp, top = 30.dp)

            )
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .shadow(0.2.dp, RoundedCornerShape(1.dp))
                    .clip(RoundedCornerShape(8.dp))
            ) {
                Column {
                    Text(
                        text = "Name",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = nunitorsansNormalFont,
                        color = TextColor5,
                        modifier = Modifier
                            .padding(bottom = 5.dp, top = 40.dp, start = 20.dp)
                    )
                    TextField(
                        value = name,
                        onValueChange = { name   = it },
                        label = { Text(text = "Anh cat") },

                        modifier = Modifier
                            .padding(vertical = 0.dp, horizontal = 12.dp)
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = BgrXam2
                        )

                    )
                    Text(
                        text = "Email",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = nunitorsansNormalFont,
                        color = TextColor5,
                        modifier = Modifier
                            .padding(bottom = 5.dp, top = 10.dp, start = 20.dp)
                    )
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(text="...@gmail.com") },

                        modifier = Modifier
                            .padding(vertical = 0.dp, horizontal = 12.dp)
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = BgrXam2
                        )
                    )
                    Text(
                        text = "Password",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = nunitorsansNormalFont,
                        color = TextColor5,
                        modifier = Modifier
                            .padding(bottom = 5.dp, top = 10.dp, start = 20.dp)
                    )
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text(text="*********") },
                        modifier = Modifier
                            .padding(vertical = 0.dp, horizontal = 12.dp)
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = BgrXam2
                        )
                    )
                    Text(
                        text = "Confirm Password",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = nunitorsansNormalFont,
                        color = TextColor5,
                        modifier = Modifier
                            .padding(bottom = 5.dp, top = 10.dp, start = 20.dp)
                    )
                    TextField(
                        value = passwordConfirm.value,
                        onValueChange = { passwordConfirm.value = it },
                        label = { Text("********") },
                        modifier = Modifier
                            .padding(vertical = 0.dp, horizontal = 12.dp)
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = BgrXam2
                        )
                    )

                    TextButton(
                        modifier = Modifier
                            .padding(vertical = 20.dp, horizontal = 20.dp,)
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .height(55.dp)
                            .background(
                                TextColor3,
                                shape = MaterialTheme.shapes.small
                            ),
                        onClick = {
                            onClickRegister()                        }
                    ) {
                        Text(text = "Sign up".uppercase(),
                            color = TextColor4,
                            fontSize = 18.sp)
                    }

                    Row(

                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)

                    ) {
                        Text(
                            text = "Already have accout?",
                            fontFamily = nunitorsansNormalFont,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = TextColor5,
                            modifier = Modifier
                                .padding(vertical = 11.dp)

                        )
                        TextButton(
                            modifier = Modifier
                                .padding(vertical = 1.dp, horizontal = 1.dp)

                            ,
                            onClick = {
                                goToScreen("login")                            }
                        ) {
                            Text(text = "Sign in".uppercase(),
                                color = TextColor3,
                                fontSize = 14.sp,
                                fontFamily = nunitorsansNormalFont)
                        }

                    }
                }
            }

        }
    }


}
//}
//    @Composable
//    fun Container (goToSreen: (String) -> Unit){
//        Body(goToSreen = goToSreen)
//    }
//
//    @Composable
//    fun Body(goToSreen: (String) -> Unit) {
//        val context = LocalContext.current
//        var email by remember { mutableStateOf("nam123@gmail.com") }
//        var password by remember { mutableStateOf("1") }
//        var name by remember { mutableStateOf("nguyen nam") }
//
//
//        fun registerCallback(response: RegisterResponseModel?) {
//            // hien thong bao thanh cong
//            Toast.makeText(context, "Register success", Toast.LENGTH_SHORT).show()
//            // quay ve login
//            goToSreen("login")
//        }
//
//        fun onClickRegister() {
//            try {
//                val retrofitAPI = RetrofitAPI()
//                val body = RegisterRequestModel(
//                    name = name, email = email,
//                    password = password
//                )
//                retrofitAPI.register(body = body, callback = { registerCallback(it) })
//            } catch (e: Exception) {
//                Log.d(">>>>>>", "Failed to register: ${e.message}")
//            }
//        }
//        Column {
//            Image(
//                painter = painterResource(id = R.drawable.anh1),
//                contentDescription = "Sample Image",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .padding(30.dp)
//                    .width(80.dp)
//                    .height(80.dp)
//                    .clip(RoundedCornerShape(8.dp))
//                    .align(Alignment.CenterHorizontally)
//            )
//
//
//        Column {
//
//            Text(
//                text = "Welcome".uppercase(),
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold,
//                color = TextColor2,
//                modifier = Modifier
//                    .padding(start = 18.dp, bottom = 30.dp)
//            )
//            Box(
//                modifier = Modifier
//                    .shadow(8.dp, shape = MaterialTheme.shapes.medium)
//
//            ) {
//                Column {
//                    TextField(
//                        value = email,
//                        onValueChange = { email = it },
//                        label = { Text(text = "Email") },
//
//                        modifier = Modifier
//                            .padding(vertical = 17.dp, horizontal = 12.dp)
//                            .fillMaxWidth()
////                            .background(TextColor4),
//
//                    )
//
//                    TextField(
//                        value = password,
//                        onValueChange = { password = it },
//                        label = { Text(text = "Password") },
//
//                        modifier = Modifier
//                            .padding(vertical = 12.dp, horizontal = 12.dp)
//                            .fillMaxWidth(),
////                        colors = TextFieldDefaults.textFieldColors(
////                            backgroundColor = TextColor4
////                        )
//
//                    )
//
//                    TextField(
//                        value = name,
//                        onValueChange = { name = it },
//                        label = { Text(text = "Name") },
//                        modifier = Modifier
//                            .padding(vertical = 12.dp, horizontal = 12.dp)
//                            .fillMaxWidth(),
////                colors = TextFieldDefaults.textFieldColors(
////                    textColor = TextColor1,
////                    backgroundColor = TextColor4
////                )
//                    )
//
////                    TextField(
////                        value = textState4.value,
////                        onValueChange = { textState4.value = it },
////                        label = { Text("Confirm Password") },
////                        modifier = Modifier
////                            .padding(vertical = 12.dp, horizontal = 12.dp)
////                            .fillMaxWidth(),
//////                colors = TextFieldDefaults.textFieldColors(
//////                    textColor = TextColor1,
//////                    backgroundColor = TextColor4
//////                )
////                    )
//
//                    TextButton(
//                        modifier = Modifier
//                            .padding(vertical = 20.dp, horizontal = 20.dp,)
//                            .align(Alignment.CenterHorizontally)
//                            .fillMaxWidth()
//                            .height(55.dp)
//                            .background(
//                                TextColor3,
//                                shape = MaterialTheme.shapes.small
//                            ),
//                        onClick = {
//                            onClickRegister()
//                        }
//                    ) {
//                        Text(
//                            text = "Sign up".uppercase(),
//                            color = TextColor4,
//                            fontSize = 18.sp
//                        )
//                    }
//
//                    Row(
//
//                        modifier = Modifier
//                            .align(Alignment.CenterHorizontally)
//
//                    ) {
//                        Text(
//                            text = "Already have accout?",
////                            fontFamily = nunitorsansNormalFont,
//                            fontSize = 20.sp,
//                            fontWeight = FontWeight.Bold,
//                            color = TextColor2,
//                            modifier = Modifier
//                                .padding(vertical = 11.dp)
//
//                        )
//                        TextButton(
//                            modifier = Modifier
//                                .padding(vertical = 1.dp, horizontal = 1.dp)
////                        .align(Alignment.CenterHorizontally)
//
//                            ,
//                            onClick = {
//                                goToSreen("login")
//                            }
//                        ) {
//                            Text(
//                                text = "login".uppercase(),
//                                color = TextColor3,
//                                fontSize = 18.sp
//                            )
//                        }
//
//                    }
//                }
//            }
//        }
//
//        }
//    }
//
//}