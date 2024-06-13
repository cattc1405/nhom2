package com.example.mykotlin.screens

import android.content.Intent
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
import androidx.compose.ui.text.font.FontFamily
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mykotlin.R
import com.example.mykotlin.asm.ResgiterActivity
import com.example.mykotlin.helpers.RetrofitAPI
import com.example.mykotlin.httpmodels.LoginRequestModel
import com.example.mykotlin.httpmodels.LoginResponseModel
import com.example.mykotlin.model.UserInfo
import com.example.mykotlin.ui.theme.BgrXam2
import com.example.mykotlin.ui.theme.TextColor1
import com.example.mykotlin.ui.theme.TextColor2
import com.example.mykotlin.ui.theme.TextColor3
import com.example.mykotlin.ui.theme.TextColor4
import com.example.mykotlin.ui.theme.TextColor5

class Login {

    private val merriweatherregular = FontFamily(Font(R.font.merriweather_regular))
    private val nunitorsansNormalFont = FontFamily(Font(R.font.nunitorsans_normal))

    @Composable
    fun Container(saveUserInfo: (UserInfo) -> Unit,
                  goToSreen: (String) -> Unit) {




//
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(horizontal = 10.dp, vertical = 18.dp)
//
//        ) {
//            Column {
//                Image(
//                    painter = painterResource(id = R.drawable.anh1),
//                    contentDescription = "Sample Image",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .padding(35.dp)
//                        .width(80.dp)
//                        .height(80.dp)
//                        .clip(RoundedCornerShape(8.dp))
//                        .align(Alignment.CenterHorizontally)
//                )
//                Main(goToSreen = goToSreen, saveUserInfo = saveUserInfo)
//            }
//
//        }
//
//    }
//
//    @OptIn(ExperimentalMaterial3Api::class)
//    @Composable
//    fun Main(saveUserInfo: (UserInfo) -> Unit,
//             goToSreen: (String) -> Unit) {
//
//        val context = LocalContext.current
//        var email by remember {
//            mutableStateOf("")
//        }
//        var password by remember {
//            mutableStateOf("")
//        }
//
//        fun loginCallback( response: LoginResponseModel?){
//            //hien thong bao thanh cong
//            // quay ve login
//
//            if (response != null){
//                saveUserInfo(
//                    UserInfo(
//                    id = response.user?._id,
//                    name = response.user?.name,
//                    email = response.user?.email,
//                    password = null
//                    )
//                )
//                goToSreen("home")
//            }else{
//                Toast.makeText(context, "loi", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        fun onLoginClick(){
//            try {
//                val body: LoginRequestModel = LoginRequestModel(
//                    email = email,
//                    password = password
//                )
//                // call api
//                val api: RetrofitAPI = RetrofitAPI()
//                api.login(body, ::loginCallback )
////                loginCallback()
//            }catch (e:Exception){
//                // hien thi thong bao loi
//                Toast.makeText(context, "loi", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//
//        Column {
//            Text(
//                text = "Hello!",
//                fontSize = 24.sp,
////                fontWeight = FontWeight.Bold,
//                color = TextColor1,
//                modifier = Modifier
//                    .padding(horizontal = 30.dp, vertical = 1.dp)
//
//            )
//
//            Text(
//                text = "Welcome back".uppercase(),
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold,
//                color = TextColor2,
//                modifier = Modifier
//                    .padding(bottom = 30.dp, start = 30.dp, top = 10.dp)
//
//            )
//            Box(
//                modifier = Modifier
//                    .shadow(8.dp, shape = MaterialTheme.shapes.medium)
//
//
//            ) {
//
//                Column {
//
//                    TextField(
//                        value = email,
//                        onValueChange = { email = it },
//                        label = { Text("Email") },
//
//                        modifier = Modifier
//                            .padding(vertical = 17.dp, horizontal = 14.dp)
//                            .fillMaxWidth()
//                    )
//
//                    TextField(
//                        value = password,
//                        onValueChange = { password = it },
//                        label = { Text("Password") },
//
//                        modifier = Modifier
//                            .padding(vertical = 12.dp, horizontal = 14.dp)
//                            .fillMaxWidth(),
//                    )
//
//                    Text(
//                        text = "Forgot Password",
//                        fontSize = 20.sp,
//                        fontWeight = FontWeight.Normal,
//                        color = TextColor2,
//                        modifier = Modifier
//                            .padding(bottom = 20.dp, top = 20.dp)
//                            .align(Alignment.CenterHorizontally)
//
//                    )
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
//                            onLoginClick()
//                        }
//                    ) {
//                        Text(text = "log in".uppercase(),
//                            color = TextColor4,
//                            fontSize = 18.sp)
//                    }
//
//                    TextButton(
//                        modifier = Modifier
//                            .padding(bottom = 30.dp)
//                            .align(Alignment.CenterHorizontally),
//                        onClick = {
//                            goToSreen("signup")
//                        }
//                    ) {
//                        Text(text = "Sign up".uppercase(),
//                            color = TextColor3,
//                            fontSize = 18.sp)
//                    }
//
//                }
//            }
//        }
//    }
//}

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 38.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize().padding()
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

                Main(goToScreen=goToSreen,saveUserInfo=saveUserInfo)
            }
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Main(goToScreen: (String) -> Unit,
             saveUserInfo: (UserInfo) -> Unit) {

        var username by remember { mutableStateOf("nam1237@gmail.com") }
        var password by remember { mutableStateOf("") }


        val context = LocalContext.current
        val textState2 = remember { mutableStateOf("") }

        fun loginCallback( response: LoginResponseModel?){


            if (response != null){
                saveUserInfo(
                    UserInfo(
                        id = response.user?._id,
                        name = response.user?.name,
                        email = response.user?.email,
                        password = null
                    )
                )
                goToScreen("home")
            }else{
                Toast.makeText(context, "loi", Toast.LENGTH_SHORT).show()
            }
        }

        fun onLoginClick(){
            try {
                val body:LoginRequestModel=   LoginRequestModel(
                    email = username,
                    password = password
                )
                val api: RetrofitAPI = RetrofitAPI()
                api.login(body, ::loginCallback )

            }catch (e:Exception){
                Toast.makeText(context, "loi", Toast.LENGTH_SHORT).show()
            }
        }


        Column {
            Text(
                text = "Hello !",
                fontSize = 24.sp,
                color = TextColor1,
                fontFamily = merriweatherregular,
                modifier = Modifier
                    .padding(horizontal = 30.dp, vertical = 1.dp)
            )

            Text(
                text = "Welcome back".uppercase(),
                fontSize = 24.sp,
                fontFamily = merriweatherregular,
                fontWeight = FontWeight.Bold,
                color = TextColor2,
                modifier = Modifier
                    .padding(bottom = 30.dp, start = 30.dp, top = 10.dp)
            )
            Box(
                modifier = Modifier
                    .shadow(0.2.dp, RoundedCornerShape(1.dp))
                    .clip(RoundedCornerShape(8.dp))
                    .padding(16.dp)

            ) {
                Column {
                    Text(
                        text = "Email",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = nunitorsansNormalFont,
                        color = TextColor5,
                        modifier = Modifier
                            .padding(bottom = 5.dp, top = 40.dp, start = 20.dp)
                    )
                    TextField(
                        value = username,
                        onValueChange = {
                            username = it
                        },
//                            value = textState.value,
//                            onValueChange = { textState.value = it },
                        label = { Text("") },
                        modifier = Modifier
                            .padding(vertical = 0.dp, horizontal = 15.dp)
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
                        label = { Text("") },
                        modifier = Modifier
                            .padding(vertical = 0.dp, horizontal = 12.dp)
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = BgrXam2
                        )
                    )

                    Text(
                        text = "Forgot Password",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = nunitorsansNormalFont,
                        color = TextColor2,
                        modifier = Modifier
                            .padding(bottom = 15.dp, top = 25.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    TextButton(
                        modifier = Modifier
                            .padding(vertical = 20.dp, horizontal = 20.dp)
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .height(55.dp)
                            .background(
                                TextColor3,
                                shape = MaterialTheme.shapes.small
                            ),
                        onClick = { onLoginClick()                            }
                    ) {
                        Text(
                            text = "Log in",
                            color = TextColor4,
                            fontFamily = nunitorsansNormalFont,
                            fontSize = 18.sp

                        )
                    }

                    TextButton(
                        modifier = Modifier
                            .padding(bottom = 30.dp)
                            .align(Alignment.CenterHorizontally),
                        onClick = {
                            goToScreen("signup")
                        }
                    ) {
                        Text(
                            text = "Sign up".uppercase(),
                            color = TextColor3,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}