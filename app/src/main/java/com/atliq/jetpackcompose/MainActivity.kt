package com.atliq.jetpackcompose

import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.PI
import kotlin.math.atan
import kotlin.math.atan2
import kotlin.math.roundToInt

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            val painter = painterResource(id = R.drawable.kermit)
//            val description = "Kermit playing in the snow"
//            val title = "Kermit playing in the snow"
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth(0.5f)
//                    .padding(16.dp)
//            ) {
//                ImageCard(
//                    painter = painter,
//                    contentDescription = description,
//                    title = title
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun ImageCard(
//    painter: Painter,
//    contentDescription: String,
//    title: String,
//    modifier: Modifier = Modifier
//) {
//    Card(
//        modifier = modifier.fillMaxWidth(),
//        shape = RoundedCornerShape(15.dp),
//        elevation = 5.dp
//    ) {
//        Box(modifier = Modifier.height(150.dp)) {
//            Image(
//                painter = painter,
//                contentDescription = contentDescription,
//                contentScale = ContentScale.Crop
//            )
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(
//                        brush = Brush.verticalGradient(
//                            colors = listOf(
//                                Color.Transparent,
//                                Color.Black
//                            ),
//                            startY = 300f
//                        )
//                    )
//            )
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(12.dp),
//                contentAlignment = Alignment.BottomStart
//            ) {
//                Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
//            }
//        }
//    }
//}

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val fontFamily = FontFamily(
//            Font(R.font.lexend_thin, FontWeight.Thin),
//            Font(R.font.lexend_light, FontWeight.Light),
//            Font(R.font.lexend_regular, FontWeight.Normal),
//            Font(R.font.lexend_medium, FontWeight.Medium),
//            Font(R.font.lexend_semibold, FontWeight.SemiBold),
//            Font(R.font.lexend_bold, FontWeight.Bold),
//            Font(R.font.lexend_extrabold, FontWeight.ExtraBold),
//        )
//
//        setContent {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color(0xFF101010))
//            ) {
//                Text(
//                    text = buildAnnotatedString {
//                        withStyle(
//                            style = SpanStyle(
//                                color = Color.Green,
//                                fontSize = 50.sp
//                            )
//                        ) {
//                            append("J")
//                        }
//                        append("etpack ")
//                        withStyle(
//                            style = SpanStyle(
//                                color = Color.Green,
//                                fontSize = 50.sp
//                            )
//                        ) {
//                            append("C")
//                        }
//                        append("ompose")
//                    },
//                    color = Color.White,
//                    fontSize = 30.sp,
//                    fontFamily = fontFamily,
//                    fontWeight = FontWeight.Bold,
//                    fontStyle = FontStyle.Italic,
//                    textAlign = TextAlign.Center,
//                    textDecoration = TextDecoration.Underline
//                )
//            }
//        }
//    }
//}

class MainActivity : ComponentActivity() {
    //    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            Column(Modifier.fillMaxSize()) {
//                val color = remember {
//                    mutableStateOf(Color.Yellow)
//                }
//                ColorBox(
//                    Modifier
//                        .weight(1f)
//                        .fillMaxSize()
//                ) {
//                    color.value = it
//                }
//                Box(
//                    modifier = Modifier
//                        .background(color.value)
//                        .weight(1f)
//                        .fillMaxSize()
//                )
//            }
//        }
//    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            val scaffoldState = rememberScaffoldState()
//            var textFieldState by remember {
//                mutableStateOf("")
//            }
//            val scope = rememberCoroutineScope()
//
//            Scaffold(
//                modifier = Modifier.fillMaxSize(),
//                scaffoldState = scaffoldState
//            ) {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center,
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(horizontal = 30.dp)
//                ) {
//                    TextField(
//                        value = textFieldState,
//                        label = {
//                            Text(text = "Enter Your Name")
//                        },
//                        onValueChange = {
//                            textFieldState = it
//                        },
//                        singleLine = false,
//                        modifier = Modifier.fillMaxWidth()
//                    )
//                    Spacer(modifier = Modifier.height(16.dp))
//                    Button(onClick = {
//                        scope.launch {
//                            scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
//                        }
//                    }) {
//                        Text(text = "Please greet me")
//                    }
//                }
//            }
//        }
//    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            LazyColumn {
//                itemsIndexed(
//                    listOf("This", "is", "Jetpack", "Compose")
//                ) {index, string ->
//                    Text(
//                        text = string,
//                        fontSize = 24.sp,
//                        fontWeight = FontWeight.Bold,
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 24.dp)
//                    )
//                }
//            }
//        }
//    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            val constraints = ConstraintSet {
//                val greenBox = createRefFor("greenbox")
//                val redBox = createRefFor("redbox")
//                val guideline = createGuidelineFromTop(0.5f)
//
//                constrain(greenBox) {
//                    top.linkTo(guideline)
//                    start.linkTo(parent.start)
//                    width = Dimension.value(100.dp)
//                    height = Dimension.value(100.dp)
//                }
//                constrain(redBox) {
//                    top.linkTo(parent.top)
//                    start.linkTo(greenBox.end)
//                    end.linkTo(parent.end)
//                    width = Dimension.value(100.dp)
//                    height = Dimension.value(100.dp)
//                }
//                createHorizontalChain(greenBox,redBox, chainStyle = ChainStyle.Packed)
//            }
//            ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
//                Box(
//                    modifier = Modifier
//                        .background(Color.Green)
//                        .layoutId("greenbox")
//                )
//                Box(
//                    modifier = Modifier
//                        .background(Color.Red)
//                        .layoutId("redbox")
//                )
//            }
//        }
//    }

    //    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            var sizeState by remember {
//                mutableStateOf(200.dp)
//            }
//            val size by animateDpAsState(
//                targetValue = sizeState,
//                tween(
//                    durationMillis =  1000,
//                    delayMillis = 300,
//                    easing = FastOutSlowInEasing
//                )
//                spring(
//                    Spring.DampingRatioHighBouncy
//                )
//            keyframes {
//                durationMillis = 5000
//                sizeState at 0 with LinearEasing
//                sizeState * 1.5f at 2000 with FastOutLinearInEasing
//                sizeState * 2f at 5000
//            }
//            )
//            val infiniteTransition = rememberInfiniteTransition()
//            val color by infiniteTransition.animateColor(
//                initialValue = Color.Red,
//                targetValue = Color.Green,
//                animationSpec = infiniteRepeatable(
//                    tween(
//                        durationMillis = 2000,
//                    ),
//                    repeatMode = RepeatMode.Reverse
//                )
//            )
//            Box(
//                modifier = Modifier
//                    .size(size)
//                    .background(color),
//                contentAlignment = Alignment.Center
//            ) {
//                Button(onClick = {
//                    sizeState += 50.dp
//                }) {
//                    Text(text = "Increase Size")
//                }
//            }
//
//        }
//    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            Box(
//                contentAlignment = Alignment.Center,
//                modifier = Modifier.fillMaxSize()
//            ) {
//                CircularProgressBar(percentage = 0.7f, number = 100)
//            }
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF101010))
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .border(1.dp, Color.Green, RoundedCornerShape(10.dp))
                        .padding(30.dp)
                ) {
                    var volume by remember {
                        mutableStateOf(0f)
                    }
                    val barCount = 20
                    MusicKnob(modifier = Modifier.size(100.dp)) {
                        volume = it
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    VolumeBar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp),
                        activeBars = (barCount * volume).roundToInt(),
                        barCount = barCount,
                    )
                }
            }
        }
    }

    @Composable
    fun VolumeBar(
        modifier: Modifier = Modifier,
        activeBars: Int = 0,
        barCount: Int = 10
    ) {
        BoxWithConstraints(
            contentAlignment = Alignment.Center,
            modifier = modifier
        ) {
            val barWidth = remember {
                constraints.maxWidth / (2f * barCount)
            }
            Canvas(modifier = modifier) {
                for(i in 0 until barCount) {
                    drawRoundRect(
                        color = if(i in 0..activeBars) Color.Green else Color.DarkGray,
                        topLeft = Offset(i * barWidth * 2f + barWidth / 2f, 0f),
                        size = Size(barWidth, constraints.maxHeight.toFloat()),
                        cornerRadius = CornerRadius(0f)
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun MusicKnob(
        modifier: Modifier = Modifier,
        limitingAngle: Float = 25f,
        onValueChange: (Float) -> Unit
    ) {
        var rotation by remember {
            mutableStateOf(limitingAngle)
        }
        var touchX by remember {
            mutableStateOf(0f)
        }
        var touchy by remember {
            mutableStateOf(0f)
        }
        var centerX by remember {
            mutableStateOf(0f)
        }
        var centerY by remember {
            mutableStateOf(0f)
        }

        Image(
            painter = painterResource(id = R.drawable.music_knob),
            contentDescription = "Music knob",
            modifier = modifier
                .fillMaxSize()
                .onGloballyPositioned {
                    val windowBounds = it.boundsInWindow()
                    centerX = windowBounds.size.width / 2f
                    centerY = windowBounds.size.height / 2f
                }
                .pointerInteropFilter { event ->
                    touchX = event.x
                    touchy = event.y
                    val angle = -atan2(centerX - touchX, centerY - touchy) * (180f / PI).toFloat()

                    when (event.action) {
                        MotionEvent.ACTION_DOWN -> {
                            rotation = angle
                            true
                        }
                        MotionEvent.ACTION_MOVE -> {
                            if (angle !in -limitingAngle..limitingAngle) {
                                val fixedAngle = if (angle in -180f..limitingAngle) {
                                    360f + angle
                                } else {
                                    angle
                                }
                                rotation = fixedAngle

                                val percent =
                                    (fixedAngle - limitingAngle) / (360f - limitingAngle * 2)
                                onValueChange(percent)
                                true
                            } else false
                        }
                        else -> false
                    }
                }
                .rotate(rotation)
        )
    }
}

//@Composable
//fun CircularProgressBar(
//    percentage: Float,
//    number: Int,
//    fontSize: TextUnit = 28.sp,
//    radius: Dp = 50.dp,
//    color: Color = Color.Green,
//    strokeWidth: Dp = 8.dp,
//    animationDuration: Int = 2000,
//    animationDelay: Int = 1000
//) {
//    var animationPlayed by remember {
//        mutableStateOf(false)
//    }
//
//    val curPercentage = animateFloatAsState(
//        targetValue = if (animationPlayed) percentage else 0f,
//        animationSpec = tween(
//            durationMillis = animationDuration,
//            delayMillis = animationDelay
//        )
//    )
//    LaunchedEffect(key1 = true) {
//        animationPlayed = true
//    }
//
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier.size(radius * 2f),
//    ) {
//        Canvas(modifier = Modifier.size(radius * 2f)) {
//            drawArc(
//                color = color,
//                -90f,
//                360 * curPercentage.value,
//                useCenter = false,
//                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
//            )
//        }
//        Text(
//            text = (number * curPercentage.value).toInt().toString(),
//            color = Color.Black,
//            fontSize = fontSize,
//            fontWeight = FontWeight.Bold
//        )
//    }
//}

//@Composable
//fun ColorBox(
//    modifier: Modifier = Modifier,
//    updateColor: (Color) -> Unit
//) {
//    Box(
//        modifier = modifier
//            .background(Color.Red)
//            .clickable {
//                updateColor(
//                    Color(
//                        Random.nextFloat(),
//                        Random.nextFloat(),
//                        Random.nextFloat(),
//                        1f
//                    )
//                )
//            }
//    )
//}