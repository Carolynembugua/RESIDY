package com.example.residy.ui.theme.screens.startup


import android.content.Intent
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.example.residy.R
import com.example.residy.navigation.ROUT_HOME


@Composable
fun StartupScreen(navController: NavController) {
    val translucentColor = Color(0x90FFFFFF) // White with 50% opacity
    val iconColor = Color.Black // Opaque black for the icon
    val circleBackgroundColor = Color.White // Solid color for the circle
    val badgeColor = Color.White // Background color for the badge
    // Define a color for the badge text
    val badgeTextColor = Color.Black // Text color for the badge
    val mContext = LocalContext.current



    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(painterResource(id = R.drawable.img_10), contentScale = ContentScale.FillHeight),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,


        ) {
        Card(
            modifier = Modifier
                .size(width = 400.dp, height = 500.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),// Set container color to transparent
            shape = RoundedCornerShape(20.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(translucentColor) // Apply the translucent background color
                    .padding(start = 10.dp, end = 10.dp)
                    .fillMaxSize()
            ) {
                Column {
                    Text(
                        text = "RESIDY",
                        modifier = Modifier
                            .padding(25.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp
                    )
                    Text(
                        text = "Opulence Apartment",
                        modifier = Modifier
                            .padding(start = 25.dp, bottom = 20.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp
                    )
                    Text(
                        text = "Kilimani,Nairobi",
                        modifier = Modifier
                            .padding(start = 25.dp, bottom = 15.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Black
                    )

                    Text(
                        text = "This apartments are situated near social amenities such as a school and a hospital  ",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier.padding(start = 25.dp, end = 25.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        CustomIconWithBadge(
                            iconResId = R.drawable.img_11, // Replace with your first icon
                            text = "Bedrooms",
                            notificationCount = 2
                        )
                        CustomIconWithBadge(
                            iconResId = R.drawable.img_12, // Replace with your second icon
                            text = "bathrooms",
                            notificationCount = 2
                        )
                        CustomIconWithBadge(
                            iconResId = R.drawable.img_13, // Replace with your second icon
                            text = "Gym",
                            notificationCount = 0
                        )
                        CustomIconWithBadge(
                            iconResId = R.drawable.img_14, // Replace with your second icon
                            text = "Parking",
                            notificationCount = 0
                        )


                    }
                    Column {
                        Row(
                            modifier = Modifier.padding(top = 10.dp, start = 10.dp)
                        ){
                            Text(
                                text = "ksh 55,000",
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier.padding(start = 20.dp, top = 10.dp )


                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Button(
                                onClick = {
                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0705562115".toUri()
                                    mContext.startActivity(callIntent)
                                          },
                                colors = ButtonDefaults.buttonColors(White),

                            ) {
                                Text(
                                    text = "Book Now",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Black

                                )
                            }

                        }
                    }
                }








            }
            }
        }
    }

@Composable
fun CustomIconWithBadge(iconResId: Int, text: String, notificationCount: Int) {
    Box(
        modifier = Modifier
            .wrapContentSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Circle with Icon
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(Color(0x50000000)) // translucent color
                    .padding(20.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = iconResId),
                    contentDescription = text,
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }

            // Text beneath the icon
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        // Notification Badge
        if (notificationCount > 0) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = 8.dp, y = (-8).dp)
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = notificationCount.toString(),
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}










@Composable
@Preview(showBackground = true)
fun StartupScreenPreview() {
    StartupScreen(rememberNavController())
}
