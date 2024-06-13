package com.example.mykotlin
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.draw.paint
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
import com.example.mykotlin.R
import com.example.mykotlin.asm.Login2Activity
import com.example.mykotlin.ui.theme.MyKotlinTheme
import com.example.mykotlin.ui.theme.Pink40
import com.example.mykotlin.ui.theme.TextColor1
import com.example.mykotlin.ui.theme.TextColor2
import com.example.mykotlin.ui.theme.TextColor3
import com.example.mykotlin.ui.theme.TextColor4


class Splash : ComponentActivity() {

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
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.bgasm),
                    contentScale = ContentScale.FillBounds
                )
        ) {
            Main()
        }
    }

    @Composable
    fun Main() {
        val context = LocalContext.current;
        val textState = remember { mutableStateOf("") }

        Column {
            Text(
                text = "Make your".uppercase(),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = TextColor1,
                modifier = Modifier
                    .padding(horizontal = 30.dp)

            )
            Text(
                text = "Home beautiful".uppercase(),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = TextColor2,
//                fontFamily = gelasioNormalFont,
                modifier = Modifier
                    .padding(horizontal = 30.dp, vertical = 15.dp)

            )
            Text(
                text = "The best simple place where you discover most wonderful furnitures and make your home beautiful ",
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = TextColor2,
                fontFamily = nunitorsansNormalFont,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(horizontal = 59.dp, vertical = 20.dp)

            )

            TextButton(
                modifier = Modifier
                    .padding(vertical = 100.dp)
                    .align(Alignment.CenterHorizontally)
                    .width(150.dp)
                    .height(50.dp)
                    .background(
                        TextColor3,
                        shape = MaterialTheme.shapes.small
                    ),
                onClick = {
                    startActivity(Intent(context,Login2Activity::class.java))
                }
            ) {
                Text(text = "Get Started",
                    color = TextColor4,
                    fontSize = 18.sp)
            }

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        Body()
    }
}
