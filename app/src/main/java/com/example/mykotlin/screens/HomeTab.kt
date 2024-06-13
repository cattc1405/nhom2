package com.example.mykotlin.screens

import android.util.Log
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.mykotlin.R
import com.example.mykotlin.helpers.RetrofitAPI
import com.example.mykotlin.httpmodels.ProductModel
import com.example.mykotlin.httpmodels.ProductResponeModel
import com.example.mykotlin.ui.theme.TextColor1
import com.example.mykotlin.ui.theme.TextColor2
import com.example.mykotlin.ui.theme.TextColor3

class HomeTab {
    private val gelasioNormalFont = FontFamily(Font(R.font.gelasio_normal))

    data class Cate(
        val name: String,
        val image: Int
    )

    val cates = listOf(
        Cate(
            "Popular",
            R.drawable.mot
        ), Cate(
            "Chair",
            R.drawable.hai
        ), Cate(
            "Table",
            R.drawable.ba
        ), Cate(
            "Armchair",
            R.drawable.bon
        ), Cate(
            "Bed",
            R.drawable.nam
        ),Cate(
            "Lam",
            R.drawable.bon
        ),
    )

    @Composable
    fun Container(goToSreen: (String) -> Unit) {
        var listProducts by remember {
            mutableStateOf(listOf<ProductModel>())
        }

        fun getProductsCallback(response: ProductResponeModel?) {
            val products = response?.products
            listProducts = products ?: listOf()
        }

        fun getProductsByCategoryId() {
            val category: String = "65b07ddcfc13ae4836b4cb08"
            val api = RetrofitAPI()
            try {
                api.getProductsCategoryID(category, ::getProductsCallback)
            } catch (e: Exception) {
                Log.d(">>>>TAG", "getProductsByCategoryId: ${e.message}")
            }
        }

        getProductsByCategoryId()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 20.dp)
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
                        painter = painterResource(id = R.drawable.sett),
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
                            color = TextColor2,
                            fontFamily = gelasioNormalFont,


                        )
                        Text(
                            text = "beautiful".uppercase(),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextColor3,
                            fontFamily = gelasioNormalFont,


                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.cart),
                        contentDescription = "Sample Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .width(24.dp)
                            .height(24.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { goToSreen("cart") }
                    )


                }
                Column {

                    LazyRow(modifier = Modifier.padding(top = 15.dp)) {
                        items(cates.size) { index ->
                            CateItem(cates[index])
                        }

                    }




                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        contentPadding = androidx.compose.foundation.layout.PaddingValues(2.dp)
                    ) {
                        items(listProducts.size) { index ->
                            ProductItem(listProducts[index],goToSreen)
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
                        color = TextColor3,
                        fontFamily = gelasioNormalFont,
            )
        }
    }

} @Composable
fun ProductItem(product: ProductModel,goToScreen: (String) -> Unit) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(product.image)
            .size(Size.ORIGINAL)
            .build()
    )
    Column(
        modifier = Modifier.padding(horizontal = 10.dp)) {
        Box(modifier = Modifier.clickable { goToScreen("detail/${product._id}") }) {
            Image(
                painter = painter,
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(167.dp)
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Image(
                painter = painterResource(id = R.drawable.smallbag),
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
            text = product.name ?:"",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = TextColor1,

            modifier = Modifier
                .padding(top = 5.dp)
        )
        Text(
            text = "$ "+product.price ?:"",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = TextColor3,

            modifier = Modifier
                .padding(top = 0.dp)
        )
    }
}


