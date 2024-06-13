package com.example.mykotlin.asm

import android.content.Intent
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mykotlin.R
import com.example.mykotlin.ui.theme.MyKotlinTheme
import com.example.mykotlin.ui.theme.TextColor1
import com.example.mykotlin.ui.theme.TextColor2
import com.example.mykotlin.ui.theme.TextColor3
import com.example.mykotlin.ui.theme.TextColor4

class Login2Activity : ComponentActivity() {
    private val nunitorsansNormalFont = FontFamily(Font(R.font.nunitorsans_normal))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyKotlinTheme {
                Body()
            }
        }
    }

    @Composable
    fun Body() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 18.dp)

        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.anh1),
                    contentDescription = "Sample Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(35.dp)
                        .width(80.dp)
                        .height(80.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .align(Alignment.CenterHorizontally)
                )
                Main()
            }

        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Main() {

        val context = LocalContext.current;
        val textState = remember { mutableStateOf("") }
        val textState2 = remember { mutableStateOf("") }



        Column {
            Text(
                text = "Hello!",
                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold,
                color = TextColor1,
                modifier = Modifier
                    .padding(horizontal = 30.dp, vertical = 1.dp)

            )

            Text(
                text = "Welcome back".uppercase(),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = TextColor2,
                modifier = Modifier
                    .padding(bottom = 30.dp, start = 30.dp, top = 10.dp)

            )
            Box(
                modifier = Modifier
                    .shadow(8.dp, shape = MaterialTheme.shapes.medium)


            ) {
                Column {

                    TextField(
                        value = textState.value,
                        onValueChange = { textState.value = it },
                        label = { Text("Email") },

                        modifier = Modifier
                            .padding(vertical = 17.dp, horizontal = 14.dp)
                            .fillMaxWidth()
                    )

                    TextField(
                        value = textState2.value,
                        onValueChange = { textState2.value = it },
                        label = { Text("Password") },

                        modifier = Modifier
                            .padding(vertical = 12.dp, horizontal = 14.dp)
                            .fillMaxWidth(),
                    )

                    Text(
                        text = "Forgot Password",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        color = TextColor2,
                        modifier = Modifier
                            .padding(bottom = 20.dp, top = 20.dp)
                            .align(Alignment.CenterHorizontally)

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

                        }
                    ) {
                        Text(text = "log in".uppercase(),
                            color = TextColor4,
                            fontSize = 18.sp)
                    }

                        TextButton(
                            modifier = Modifier
                                .padding(bottom = 30.dp)
                                .align(Alignment.CenterHorizontally),
                            onClick = {
                                startActivity(Intent(context,ResgiterActivity::class.java))
                            }
                        ) {
                            Text(text = "Sign up".uppercase(),
                                color = TextColor3,
                                fontSize = 18.sp)
                        }

                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        Body()
    }
}