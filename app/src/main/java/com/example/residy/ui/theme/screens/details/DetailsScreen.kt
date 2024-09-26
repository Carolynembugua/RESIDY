package com.example.residy.ui.theme.screens.details


import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.residy.R
import com.example.residy.navigation.ROUT_STARTUP
import com.example.residy.ui.theme.pastblue
import com.example.residy.ui.theme.screens.products.bottomNavItems


@Composable
fun DetailsScreen(navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Scaffold(
            bottomBar = {
                BottomAppBar() // Custom Bottom App Bar
            },
            content = { paddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center // Center content in Box
                ) {
                    // Main content centered in the screen
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        // Middle App Bar (formerly the Top Bar)



                    // Add the layered cards below the centered app bar
                        Spacer(modifier = Modifier.size(10.dp))

                        //Start of searchbar
                        var search by remember { mutableStateOf("") }

                        OutlinedTextField(
                            value = search,
                            onValueChange = {search = it},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp, end = 20.dp)
                                .height(100.dp),
                            shape = RoundedCornerShape(16.dp),
                            textStyle = LocalTextStyle.current.copy(
                                fontSize = 18.sp),


                            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "search") },// FOR ICON TO BE AT BEGINNING
                            placeholder = {
                                Text(
                                    text = " Find the perfect place ",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = FontFamily.Monospace,
                                    modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                                    textAlign = TextAlign.Justify

                                )



                            }
                        )
                        //end of outlined text field
                        Spacer(modifier = Modifier.height(15.dp))

                        Column(
                            modifier = Modifier.verticalScroll(rememberScrollState()), // Makes the column scrollable
                            verticalArrangement = Arrangement.spacedBy(16.dp)

                        ){

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                                    .padding(start = 10.dp, end = 10.dp),
                                shape = RoundedCornerShape(20.dp),
                            ){
                                Box(modifier = Modifier
                                    .paint(painterResource(id = R.drawable.img_10), contentScale = ContentScale.FillWidth),
                                ){
                                    Column {
                                        Text(
                                            text = "OPULENCE APARTMENTS ",
                                            fontSize = 20.sp,
                                            color = Color.Black,
                                            modifier = Modifier.padding(20.dp),
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily.Monospace
                                        )
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(
                                            text = "Karen,Nairobi",
                                            fontSize = 20.sp,
                                            color = Color.Black,
                                            modifier = Modifier.padding(start = 35.dp),

                                            )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Text(
                                            text = "ksh 55,000/month",
                                            fontSize = 20.sp,
                                            color = Color.Black,
                                            modifier = Modifier.padding(start = 170.dp),

                                            )

                                        Spacer(modifier = Modifier.height(10.dp))

                                        Button(
                                            onClick = { navController.navigate(ROUT_STARTUP) },
                                            modifier = Modifier
                                                .padding(top = 10.dp, start = 30.dp)
                                                .width(200.dp)
                                                .height(50.dp),


                                            colors = ButtonDefaults.buttonColors(Color.White)
                                        ) {
                                            Text(
                                                text = "Take a Look",
                                                color = Color.Black,
                                                fontSize = 20.sp,


                                                )

                                        }

                                    }


                                }
                            }
                            //end of card 1
                            Spacer(modifier = Modifier.height(10.dp))
                            //card2
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                                    .padding(start = 10.dp, end = 10.dp),
                                shape = RoundedCornerShape(20.dp),
                            ){
                                Box(modifier = Modifier
                                    .fillMaxWidth()
                                    .paint(painterResource(id = R.drawable.img_19), contentScale = ContentScale.FillWidth),
                                ){
                                    Column {
                                        Text(
                                            text = "SAVVY VILLA ",
                                            fontSize = 20.sp,
                                            color = Color.Black,
                                            modifier = Modifier.padding(20.dp),
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily.Monospace
                                        )
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(
                                            text = "Ngong rd,Nairobi",
                                            fontSize = 20.sp,
                                            color = Color.Black,
                                            modifier = Modifier.padding(start = 25.dp),

                                            )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Text(
                                            text = "ksh 55,000/month",
                                            fontSize = 20.sp,
                                            color = Color.Black,
                                            modifier = Modifier.padding(start = 170.dp),

                                            )
                                        Spacer(modifier = Modifier.height(10.dp))

                                        Button(
                                            onClick = { navController.navigate(ROUT_STARTUP) },
                                            modifier = Modifier
                                                .padding(top = 10.dp, start = 30.dp)
                                                .width(200.dp)
                                                .height(50.dp),


                                            colors = ButtonDefaults.buttonColors(Color.White)
                                        ) {
                                            Text(
                                                text = "Take a Look",
                                                color = Color.Black,
                                                fontSize = 20.sp,


                                                )

                                        }

                                    }



                                }
                            }
                            //end of card 2
                            Spacer(modifier = Modifier.height(10.dp))

                            //card 3
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                                    .padding(start = 10.dp, end = 10.dp),
                                shape = RoundedCornerShape(20.dp),
                            ){
                                Box(modifier = Modifier
                                    .fillMaxWidth()
                                    .paint(painterResource(id = R.drawable.img_20), contentScale = ContentScale.FillWidth),
                                ){
                                    Column {
                                        Text(
                                            text = " PARID  ",
                                            fontSize = 20.sp,
                                            color = Color.White,
                                            modifier = Modifier.padding(20.dp),
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily.Monospace
                                        )
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(
                                            text = "Kilimani,Nairobi",
                                            fontSize = 20.sp,
                                            color = Color.White,
                                            modifier = Modifier.padding(start = 25.dp),

                                            )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Text(
                                            text = "ksh 55,000/month",
                                            fontSize = 20.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.ExtraBold,
                                            modifier = Modifier.padding(start = 170.dp),)
                                        Spacer(modifier = Modifier.height(10.dp))

                                        Button(
                                            onClick = { navController.navigate(ROUT_STARTUP) },
                                            modifier = Modifier
                                                .padding(top = 10.dp, start = 35.dp)
                                                .width(200.dp)
                                                .height(50.dp),


                                            colors = ButtonDefaults.buttonColors(Color.White)
                                        ) {
                                            Text(
                                                text = "Take a Look",
                                                color = Color.Black,
                                                fontSize = 20.sp,


                                                )

                                        }

                                    }



                                }
                            }

                            //end of card 3
                            Spacer(modifier = Modifier.height(10.dp))

                            //card 4
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                                    .padding(start = 10.dp, end = 10.dp),
                                shape = RoundedCornerShape(20.dp),
                            ){
                                Box(modifier = Modifier
                                    .fillMaxWidth()
                                    .paint(painterResource(id = R.drawable.img_4), contentScale = ContentScale.FillWidth),
                                ){
                                    Column {
                                        Text(
                                            text = " XANNY ",
                                            fontSize = 20.sp,
                                            color = Color.Black,
                                            modifier = Modifier.padding(20.dp),
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily.Monospace
                                        )
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(
                                            text = "Karen,Nairobi",
                                            fontSize = 20.sp,
                                            color = Color.Black,
                                            modifier = Modifier.padding(start = 25.dp),

                                            )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Text(
                                            text = "ksh 55,000/month",
                                            fontSize = 20.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.ExtraBold,
                                            modifier = Modifier.padding(start = 170.dp),
                                        )
                                        Spacer(modifier = Modifier.height(10.dp))

                                        Button(
                                            onClick = { navController.navigate(ROUT_STARTUP) },
                                            modifier = Modifier
                                                .padding(top = 10.dp, start = 35.dp)
                                                .width(200.dp)
                                                .height(50.dp),


                                            colors = ButtonDefaults.buttonColors(Color.White)
                                        ) {
                                            Text(
                                                text = "Take a Look",
                                                color = Color.Black,
                                                fontSize = 20.sp,


                                                )

                                        }

                                    }



                                }
                            }
                        }
                        CenteredAppBar()

                        Spacer(modifier = Modifier.height(16.dp))



                    }
                }
            }
        )


    }



}
@Composable
fun CenteredAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Nearby, Recommend, Share Bar
        TopBarItem(text = "Nearby", selected = true)
        TopBarItem(text = "Recommend", selected = false)
        TopBarItem(text = "Share", selected = false)
    }
}

@Composable
fun TopBarItem(text: String, selected: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { /* Handle click */ }
    ) {
        Text(
            text = text,
            color = if (selected) Color.Black else Color.Gray,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        if (selected) {
            Box(
                modifier = Modifier
                    .width(24.dp)
                    .height(4.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(Color.Black)
            )
        }
    }
}

@Composable
fun BottomAppBar() {
    val mContext = LocalContext.current

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Black
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Place,
                    contentDescription = "Nearby",
                    tint = Color.Black
                )
            },
            selected = true,
            onClick = { /* Handle click */ }
        )

        Box(
            modifier = Modifier
                .size(60.dp)
                .padding(8.dp)
                .clip(CircleShape)
                .background(Color.Black)
                .clickable { /* Handle click */ },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Residy",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Share",
                    tint = Color.Black
                )
            },
            selected = false,
            onClick = {
                val shareIntent= Intent(Intent.ACTION_SEND)
                shareIntent.type="text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this housing")
                mContext.startActivity(Intent.createChooser(shareIntent, "Share"))
            }
        )
    }
}





@Composable
@Preview(showBackground = true)
fun DetailsScreenPreview(){
    DetailsScreen(rememberNavController())
}