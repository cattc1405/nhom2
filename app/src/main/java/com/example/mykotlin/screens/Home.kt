package com.example.mykotlin.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import com.example.mykotlin.screens.Profile

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.mykotlin.R
import com.example.mykotlin.model.Cart
import com.example.mykotlin.model.UserInfo
import com.example.mykotlin.ui.theme.TextColor3
import com.example.mykotlin.ui.theme.TextColor4

data class TabBarItem(
    val title: String,
    val selectedIcon: Int,
    val unselectedIcon: Int,
)

class Home {
    @Composable
    fun Container (
        saveUserInfo: (UserInfo) -> Unit,
        goToSreen: (String) -> Unit,
        cartInfo: List<Cart>,
        updateCart: (Cart) -> Unit,
        clearCart: ()->Unit
        ){
        Column {
//            Text(text = "home")
//            Button(onClick = {
//                //call api logout
//                // logout thanh cong
//                saveUserInfo(UserInfo(null, null, null, null))
//            }) {
//                Text(text = "Logout")
//            }
//
//            // chuyen man hinh chi tiet
//
//            Button(onClick = {
//                val value = 123
//                goToSreen("detail/$value")
//            }) {
//                Text(text = "detail chi tiết")
//            }
            MainTabs(
                saveUserInfo = { saveUserInfo(it) },
                goToSreen = goToSreen,
                cartInfo = cartInfo,
                updateCart = { updateCart(it)},
                clearCart = clearCart
            )

        }

    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun MainTabs(
        saveUserInfo: (UserInfo) -> Unit,
        goToSreen: (String) -> Unit,
        cartInfo: List<Cart>,
        updateCart: (Cart) -> Unit,
        clearCart: ()->Unit
    ) {
        // setting up the individual tabs
        val homeTab = TabBarItem(
            title = "Home",
            selectedIcon = R.drawable.home_selected,
            unselectedIcon = R.drawable.home
        )
        val alertsTab = TabBarItem(
            title = "Alerts",
            selectedIcon = R.drawable.bell_selected,
            unselectedIcon = R.drawable.bell
        )
        val settingsTab = TabBarItem(
            title = "Settings",
            selectedIcon = R.drawable.marker_selected,
            unselectedIcon = R.drawable.marker
        )
        val moreTab = TabBarItem(
            title = "More",
            selectedIcon = R.drawable.person_selected,
            unselectedIcon = R.drawable.person
        )

        // creating a list of all the tabs
        val tabBarItems = listOf(homeTab, alertsTab, settingsTab, moreTab)
        // creating our navController
        val navController = rememberNavController()

        //khoi tao cac man hinh
        var alertScreen = Alerts()
        var homeScreen = HomeTab()
//        var moreScreen = Profile()

        //tinh tong tien gio hang
        var sum = 0f
        for (item in cartInfo){
            if (item.product.price != null){
                sum += item.product.price * item.quantity
            }
        }

        Scaffold(bottomBar = { TabView(tabBarItems, navController) }) {
            NavHost(navController = navController, startDestination = homeTab.title) {
                composable(homeTab.title) {
                    homeScreen.Container(goToSreen = {goToSreen(it)})
                }
                composable(alertsTab.title) {
                    alertScreen.Container()
                }
                composable(settingsTab.title) {
//                    Text(settingsTab.title)
                    //hien thi gio hang

                    val textState = remember { mutableStateOf("") }


                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 10.dp)
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

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 15.dp, horizontal = 30.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.Top,

                                    )
                                {

                                    Row(
                                        modifier = Modifier
                                            .height(38.dp)
                                            .shadow(8.dp, shape = MaterialTheme.shapes.medium)
                                            .background(
                                                Color.White,
                                                shape = RoundedCornerShape(16.dp)
                                            ),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.back),
                                            modifier = Modifier
                                                .size(38.dp)
                                                .background(
                                                    Color.White,
                                                    shape = RoundedCornerShape(12.dp)
                                                )
                                                .clickable {

                                                },
                                            contentDescription = ""
                                        )


                                    }
                                    Text(
                                        text = "My cart",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,

                                        )

                                    Text(
                                        text = "      ",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,

                                        )
                                }

                                Spacer(modifier = Modifier.size(100.dp))

                            }

                            Box {

                                Column {
                                    Box(modifier = Modifier.fillMaxSize()){
                                    Row(
                                        modifier = Modifier.padding(
                                            start = 10.dp,
                                            end = 10.dp,

                                            )
                                    ) {
                                        LazyColumn {
                                            items(cartInfo) { item ->
                                                Row(
                                                    modifier = Modifier.padding(
                                                        start = 10.dp,
                                                        end = 10.dp,
                                                        bottom = 15.dp
                                                    )

                                                ) {

                                                    AsyncImage(
                                                        model = item.product.image,
                                                        contentDescription = "",
                                                        contentScale = ContentScale.Crop,
                                                        modifier = Modifier
                                                            .width(100.dp)
                                                            .height(100.dp)
                                                            .clip(RoundedCornerShape(8.dp))
                                                    )
                                                    Box(
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .padding(start = 15.dp)
                                                    ) {

                                                        Column {

                                                            Text(
                                                                text = "Name: ${item.product.name}",
                                                                fontSize = 14.sp,
                                                                fontWeight = FontWeight.Medium,
                                                            )

                                                            Text(
                                                                text = "$ ${item.product.price}",
                                                                fontSize = 16.sp,
                                                                fontWeight = FontWeight.Bold,
                                                                modifier = Modifier
                                                                    .padding(vertical = 12.dp)
                                                            )

                                                            Row(
                                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                                modifier = Modifier
                                                                    .width(100.dp)
                                                            ) {

                                                                Image(
                                                                    painter = painterResource(id = R.drawable.tru),
                                                                    contentDescription = "",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .width(30.dp)
                                                                        .height(30.dp)
                                                                        .clip(RoundedCornerShape(4.dp))
                                                                        .padding(start = 5.dp)
                                                                        .clickable {
                                                                            updateCart(
                                                                                Cart(
                                                                                    item.product,
                                                                                    -1
                                                                                )
                                                                            )
                                                                        },

                                                                    )

                                                                Text(
                                                                    text = "${item.quantity}",
                                                                    fontSize = 18.sp,
                                                                    fontWeight = FontWeight.Bold,
                                                                    modifier = Modifier
                                                                        .padding(horizontal = 5.dp)
                                                                )
                                                                Image(
                                                                    painter = painterResource(id = R.drawable.cong),
                                                                    contentDescription = "",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .width(30.dp)
                                                                        .height(30.dp)
                                                                        .clip(RoundedCornerShape(4.dp))
                                                                        .padding(start = 5.dp)
                                                                        .clickable {
                                                                            updateCart(
                                                                                Cart(
                                                                                    item.product,
                                                                                    1
                                                                                )
                                                                            )
                                                                        },

                                                                    )

                                                            }
                                                        }
                                                    }

                                                }}
                                            }
                                        }
                                    }

                                    Column {


                                    Row(
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 10.dp, horizontal = 10.dp)
                                    ) {
                                        Text(
                                            text = "Total:",
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,

                                            )
                                        Text(
                                            text = "$ $sum",
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,

                                            )
                                    }
                                    Button(
                                        onClick = {
                                            clearCart()
                                            goToSreen("congrats")
                                        },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = TextColor3,
                                            contentColor = TextColor4
                                        ),
                                        shape = RoundedCornerShape(8.dp),
                                        modifier = Modifier
                                            .height(55.dp)
                                            .fillMaxWidth()


                                    ) {
                                        Text(text = "Check out", fontSize = 20.sp)
                                    }
                                }
                                }

                            }
                        }
                    }

                }

                composable(moreTab.title) {
//                    Button(onClick = {
//                        saveUserInfo(UserInfo(null, null, null, null))
//                    }) {
//
//                    }
        Profile2().Container( saveUserInfo)
                }
            }
        }
    }
//m

    @Composable
    fun TabView(tabBarItems: List<TabBarItem>, navController: NavController) {
        var selectedTabIndex by rememberSaveable {
            mutableIntStateOf(0)
        }
        NavigationBar {
            tabBarItems.forEachIndexed { index, tabBarItem ->
                NavigationBarItem(
                    selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                        navController.navigate(tabBarItem.title)
                    },
                    icon = {
                        TabBarIconView(
                            isSelected = selectedTabIndex == index,
                            selectedIcon = tabBarItem.selectedIcon,
                            unselectedIcon = tabBarItem.unselectedIcon,
                            title = tabBarItem.title,
                        )
                    })
//                    label = { Text(tabBarItem.title) })
            }
        }
    }

    @Composable
    fun TabBarIconView(
        isSelected: Boolean,
        selectedIcon: Int,
        unselectedIcon: Int,
        title: String,
    ) {
        Image(
            painter = painterResource(id = if (isSelected) selectedIcon else unselectedIcon),
            modifier = Modifier
                .width(24.dp)
                .height(24.dp),
            contentDescription = title
        )
    }
}