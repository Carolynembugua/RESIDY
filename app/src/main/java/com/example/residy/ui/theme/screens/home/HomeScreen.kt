package com.example.residy.ui.theme.screens.home


import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.residy.R
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import com.example.residy.navigation.ROUT_STARTUP
import com.example.residy.ui.theme.blue



@Composable
fun HomeScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "RESIDY",
            fontSize = 20.sp,
            fontWeight = FontWeight.Black,


        )


        //Start of searchbar
        var search by remember { mutableStateOf("") }
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = search,
            onValueChange = {search = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(150.dp),// Increase the height of the TextField
            shape = RoundedCornerShape(16.dp), // Make the borders curved with a corner radius
            textStyle = LocalTextStyle.current.copy(
                fontSize = 30.sp),
            singleLine = false,


            trailingIcon = {
                Icon(imageVector = Icons.Default.Search,
                    contentDescription = "search",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 10.dp)
                )},//leading FOR ICON TO BE AT BEGINNING
            placeholder = {
                Text(
                    text = " Find the perfect place ",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Black,
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier.padding(start = 10.dp)

                )


            }

        )
        var selected by remember { mutableIntStateOf(0) }
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
                        CenteredAppBar()

                        Spacer(modifier = Modifier.height(16.dp))

                        // Add the layered cards below the centered app bar
                        LayeredCards()
                    }
                }
            }
        )
        Spacer(modifier = Modifier.height(20.dp))

    }
}
@Composable
fun CenteredAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
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
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "Nearby",
                    tint = Color.Black
                )
            },
            selected = true,
            onClick = {  }
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
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                mContext.startActivity(Intent.createChooser(shareIntent, "Share"))
            }
        )
    }
}
@Composable
fun LayeredCards() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center


    ) {
        CardItem(

            modifier = Modifier
                .offset(x = (-40).dp, y = 40.dp),
            backgroundColor =  Color(0xFFE3F2FD)
        )
        CardItem(
            modifier = Modifier
                .offset(x = (-20).dp, y = 20.dp),
            backgroundColor = Color(0xFFC5CAE9)
        )
        CardItem(
            modifier = Modifier
                .offset(x = 0.dp, y = 0.dp),
            backgroundColor = Color(0xFF3F51B5),
            isMainCard = true

        )
    }
}



@Composable
fun CardItem(

    modifier: Modifier = Modifier,
    backgroundColor: Color,
    isMainCard: Boolean = false
) {
    Card(
        modifier = modifier
            .fillMaxWidth(0.9f)
            .height(300.dp)
            .clip(RoundedCornerShape(24.dp)),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            if (isMainCard) {
                Box(modifier = Modifier.fillMaxSize(),
                ){
                    Image(
                        painter = painterResource(id = R.drawable.img_10),
                        contentDescription = "" ,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(24.dp)) // Clip the image to match the card shape
                    )

                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Opulence ",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 16.dp),
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "Apartments ",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Left

                    )
                    Text(
                        text = "$5,680 / Month",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = {


                        },
                        modifier = Modifier.padding(16.dp),
                        colors = ButtonDefaults.buttonColors(blue)
                    ) {
                        Text(
                            text = "Take a look"
                        )
                    }
                }
            }
        }
    }
}





@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){

    HomeScreen(rememberNavController())

}