package com.blueray.rowsandcolumns.basic_layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.window.core.layout.WindowWidthSizeClass
import com.blueray.rowsandcolumns.R
import com.blueray.rowsandcolumns.ui.theme.RowsAndColumnsTheme
import com.blueray.rowsandcolumns.ui.theme.getFontSize

private val tags = listOf(
    "City-Center",
    "Luxury",
    "Instant Booking",
    "Exclusive Deal",
    "Early Bird Discount",
    "Romantic Getaway",
    "24/7 Support"
)

private val offers =
    mapOf(
        R.drawable.bed to "2 Bed",
        R.drawable.breakfast to "Breakfast",
        R.drawable.cutlery to "Kitchen",
        R.drawable.pawprint to "Pet Friendly",
        R.drawable.serving_dish to "Dinner",
        R.drawable.snowflake to "Air Conditioning",
        R.drawable.television to "TV",
        R.drawable.wi_fi_icon to "Wifi"
    )

@Composable
fun HotelBookingScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            Box {
                Image(
                    painter = painterResource(R.drawable.living_room),
                    "Header",
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(
                            max = 250.dp
                        ),
                    contentScale = ContentScale.Crop
                )
                HotelFadedBanner(
                    Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                )
            }


        }
        item {
            HorizontalDivider(
                Modifier.padding(horizontal = 16.dp)
            )
        }
        item {
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
            ) {
                tags.forEach { tag ->
                    AssistChip(onClick = {}, label = {
                        Text(text = tag, color = Color.DarkGray)
                    })

                }
            }
        }

        item {
            HorizontalDivider(
                Modifier.padding(horizontal = 16.dp)
            )
        }

        item {
            Text(
                """
                The advertisement features a vibrant and inviting design, showcasing the Hotel California Strawberry nestled in the heart of Los Angeles. Surrounded by the iconic Hollywood Sign, Griffith Park, and stunning beaches, the hotel is perfectly located for guests to explore L.A.’s best attractions.
            """.trimIndent(),
                fontSize = 13.sp,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        item {
            Text(
                """
                What We Offer
            """.trimIndent(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                textAlign = TextAlign.Center
            )
        }

        item {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    16.dp,
                    alignment = Alignment.CenterHorizontally
                ),

                ) {

                items(offers.entries.toList()) { (drawableResId, label) ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .background(
                                Color.Gray.copy(
                                    alpha = 0.4f
                                )
                            )
                            .padding(8.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(drawableResId),
                            contentDescription = label,
                            modifier = Modifier.size(36.dp),
                            tint = Color.DarkGray
                        )
                        Text(
                            label,
                            fontSize = 13.sp,
                            color = Color.Black
                        )
                    }

                }
            }
        }

        item {
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .widthIn(max = 400.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Book Now")
            }
        }

    }

}


@Composable
fun HotelFadedBanner(modifier: Modifier = Modifier) {
    val windowClass = currentWindowAdaptiveInfo().windowSizeClass

    Row(
        modifier = modifier
            .background(
                Color.White.copy(
                    alpha = 0.5f
                )
            )
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp), modifier = Modifier.weight(1f)
        ) {
            Text(
                "Hotel California Strawberry",
                fontWeight = FontWeight.Bold,
                fontSize = getFontSize(windowClass),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Justify,
                color = Color.Black
            )

            LabeledIcon(
                icon = {
                    Icon(
                        imageVector = Icons.Default.LocationOn, "Location", tint = Color.DarkGray
                    )
                }, text = "Los Angeles, California"
            )

            LabeledIcon(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Star, "Location", tint = Color.Yellow
                    )
                }, text = "4.9 (14K reviews)"
            )
        }

        Text(
            buildAnnotatedString {
                val fontSizeMultiplier = when (windowClass.windowWidthSizeClass) {
                    WindowWidthSizeClass.COMPACT -> 1f
                    WindowWidthSizeClass.MEDIUM -> 1.2f
                    WindowWidthSizeClass.EXPANDED -> 1.5f
                    else -> 1f
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp * fontSizeMultiplier,
                        color = Color.Black
                    )
                ) {
                    // ADD TEXT HERE
                    append("420$/")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                ) {
                    append("night")
                }
            })
    }
}

@Composable
fun LabeledIcon(
    text: String, icon: @Composable () -> Unit, modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        icon()
        Text(text, fontSize = 13.sp, color = Color.Black)
    }
}

@Preview
@Composable
private fun HotelBookingScreenPrev() {
    RowsAndColumnsTheme {
        HotelBookingScreen()
    }
}

@Preview(
    device = Devices.NEXUS_10
)
@Composable
private fun HotelBookingTabletScreenPrev() {
    RowsAndColumnsTheme {
        HotelBookingScreen()
    }
}