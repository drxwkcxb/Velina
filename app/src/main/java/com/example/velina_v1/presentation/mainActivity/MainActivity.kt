package com.example.velina_v1.presentation.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.velina_v1.R
import com.example.velina_v1.presentation.mainActivity.viewModel.MainActivityViewModel
import com.example.velina_v1.presentation.theme.Velina_v1Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        window.decorView.systemUiVisibility = 0
        setContent {
            Velina_v1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)){
                        if (viewModel.isOnboardingPassed) {
                            Spacer(modifier = Modifier.padding(innerPadding))
                        } else {
                            MaterialTheme {
                                Surface {
                                    OnboardingTeamsScreen(cardDataList = cardDataList)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SplashView() {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Welcome to Velina - \nYour F1 Data Center",
                color = colorResource(id = R.color.white),
                lineHeight = 30.sp,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = 115.dp, y = 35.dp)
                    .size(234.dp)
                    .border(
                        width = 2.dp,
                        color = colorResource(id = R.color.white),
                        shape = CircleShape
                    )
            )
            Box(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .offset(x = -130.dp, y = 180.dp)
                    .size(234.dp)
                    .border(
                        width = 2.dp,
                        color = colorResource(id = R.color.white),
                        shape = CircleShape
                    )
            )
            Box(
                modifier = Modifier
                    // Redo with BottomStart
                    .align(Alignment.CenterStart)
                    .offset(x = 0.dp, y = 280.dp)
                    .size(234.dp)
                    .border(
                        width = 2.dp,
                        color = colorResource(id = R.color.white),
                        shape = CircleShape
                    )
            )
            Image(painter = painterResource(id = R.drawable.suzuka),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(x = 125.dp, y = 55.dp)
                    .paint(painter = painterResource(id = R.color.white))
                )
            Image(painter = painterResource(id = R.drawable.greatbritain),
                contentDescription ="",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = -150.dp, y = -130.dp)
                    .rotate(280f)
                    .paint(painter = painterResource(id = R.color.white))
            )
        }
}
data class CardData(val imageResource: Int, val accentColor: Color = Color.White, val teamName: String)

val FerrariRed = Color(0xffd00133)
val RedbullBlue = Color(0xff002f65)
val VcarbBlue = Color(0xff1534cc)
val WilliamsBlue = Color(0xff041e43)
val HaasWhite = Color(0xfff8f9ff)
val MercedesBlue = Color(0xff1dc5b4)
val AlpinePink = Color(0xfff296c7)
val StakeGreen = Color(0xff18e555)
val AstonmartinGreen = Color(0xff01584f)
val MclarenOrange = Color(0xffff9900)

val cardDataList = listOf(
    CardData(imageResource = R.drawable.mclarenlogo, accentColor = MclarenOrange, teamName = "McLaren" ),
    CardData(imageResource = R.drawable.ferrarilogo, accentColor = FerrariRed, teamName = "Scuderia Ferrari"),
    CardData(imageResource = R.drawable.redbulllogo, accentColor = RedbullBlue, teamName = "RedBull"),
    CardData(imageResource = R.drawable.astonmartinlogo, accentColor = AstonmartinGreen, teamName = "Aston Martin"),
    CardData(imageResource = R.drawable.haascard, accentColor = HaasWhite, teamName = "Haas"),
    CardData(imageResource = R.drawable.alpinelogo, accentColor = AlpinePink, teamName = "Alpine"),
    CardData(imageResource = R.drawable.williamslogo, accentColor = WilliamsBlue, teamName = "Williams"),
    CardData(imageResource = R.drawable.mercedeslogo, accentColor = MercedesBlue, teamName = "Mercedes"),
    CardData(imageResource = R.drawable.vcarblogo, accentColor = VcarbBlue, teamName = "VCARB"),
    CardData(imageResource = R.drawable.stakelogo, accentColor = StakeGreen, teamName = "Stake")
)
data class DriverTeamData(val teamImage: Int, val teamName: String,
                          val driverImage1: Int,val driver1Name: String,
                          val driverImage2: Int,val driver2Name: String, )
val driverDataList = listOf(
    DriverTeamData(teamImage = R.drawable.redbullcircle, teamName = "RedBull",
        driverImage1 = R.drawable.maxcircle,
        driver1Name = "Max Verstappen",
        driverImage2 = R.drawable.perezcircle,
        driver2Name = "Sergio Perez"),
    DriverTeamData(teamImage = R.drawable.ferraricircle, teamName = "Scuderia Ferrari",
        driverImage1 = R.drawable.leclerccircle,
        driver1Name = "Charles Leclerc",
        driverImage2 = R.drawable.sainzcircle,
        driver2Name = "Carlos Sainz"),
    DriverTeamData(teamImage = R.drawable.mclarencircle, teamName = "McLaren",
        driverImage1 = R.drawable.norriscircle,
        driver1Name = "Lando Norris",
        driverImage2 = R.drawable.oscarcircle,
        driver2Name = "Oscar Piastri"),
    DriverTeamData(teamImage = R.drawable.astoncircle, teamName = "Aston Martin",
        driverImage1 = R.drawable.alonsocircle,
        driver1Name = "Fernando Alonzo",
        driverImage2 = R.drawable.strollcircle,
        driver2Name = "Lance Stroll"),
    DriverTeamData(teamImage = R.drawable.mercedescircle, teamName = "Mercedes",
        driverImage1 = R.drawable.russelcircle,
        driver1Name = "George Russel",
        driverImage2 = R.drawable.lewiscircle,
        driver2Name = "Lewis Hamilton"),
    DriverTeamData(teamImage = R.drawable.vcarbcircle, teamName = "VCARB",
        driverImage1 = R.drawable.yukicircle,
        driver1Name = "Yuki Tsunoda",
        driverImage2 = R.drawable.danielcircle,
        driver2Name = "Daniel Ricciardo"),
    DriverTeamData(teamImage = R.drawable.haascircle, teamName = "Haas",
        driverImage1 = R.drawable.nicocircle,
        driver1Name = "Nico Hulkenberg",
        driverImage2 = R.drawable.kevincircle,
        driver2Name = "Kevin Magnussen"),
    DriverTeamData(teamImage = R.drawable.alpinecircle, teamName = "Alpine",
        driverImage1 = R.drawable.oconcircle,
        driver1Name = "Esteban Ocon",
        driverImage2 = R.drawable.gasly,
        driver2Name = "Pierre Gasly"),

    DriverTeamData(teamImage = R.drawable.williamscircle, teamName = "Williams",
        driverImage1 = R.drawable.logancircle,
        driver1Name = "Logan Sargeant",
        driverImage2 = R.drawable.alboncircle,
        driver2Name = "Alex Albon"),

    DriverTeamData(teamImage = R.drawable.stakecircle, teamName = "Stake",
        driverImage1 = R.drawable.shoucircle,
        driver1Name = "Zhou Guanyu",
        driverImage2 = R.drawable.bottascircle,
        driver2Name = "Valtteri Bottas")
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingTeamsScreen(cardDataList: List<CardData>) {
    val pagerState = rememberPagerState {
        10
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .offset(x = 37.dp, y = 25.dp),
        contentAlignment = Alignment.Center,
        ) {
        Text(text = "Welcome to Velina - \nYour F1 Data Center",
            color = colorResource(id = R.color.white),
            lineHeight = 30.sp,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(x = -30.dp, y = 0.dp)
        )
        Text(text = "Pick your favourite team!",
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(x = -26.dp, y = 80.dp))

    HorizontalPager(state = pagerState) { page ->
        val cardData = cardDataList[page]
        Card(
            modifier = Modifier
                .width(300.dp)
                .padding(16.dp)
                .background(color = Color.Transparent)
                .offset(x = 0.dp, y = 40.dp),
        ) {
            Column {
                Image(
                    painter = painterResource(id = cardData.imageResource),
                    contentDescription = "Card Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .clip(RoundedCornerShape(15.dp))
                )
                Text(modifier = Modifier.align(Alignment.CenterHorizontally),
                    color = cardData.accentColor,
                    text = cardData.teamName,
                    fontSize = 24.sp)
                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                        .align(Alignment.CenterHorizontally)
                )
                TextButton(
                    onClick = { /* Handle button click */ },
                    colors = ButtonDefaults.textButtonColors(cardData.accentColor),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(120.dp, 48.dp)
                ) {
                    Text(
                        "Done!"
                    )
                }
            }
        }
    }
    }
}
@Composable
fun OnboardingDriversScreen() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.redbullcircle), // Replace with your actual drawable resource ID
            contentDescription = null, // Provide a meaningful description for accessibility
            modifier = Modifier
                .size(100.dp) // Adjust size as needed
                .clip(CircleShape)
                .background(Color.Gray) // Optional background color
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = driver)
            // Add more text or composables as needed
        }
    }
    LazyColumn {
        items(driverDataList.) { item ->
            OnboardingDriversScreen(item)
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}