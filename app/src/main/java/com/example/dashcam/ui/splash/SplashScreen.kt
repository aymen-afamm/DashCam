package com.example.dashcam.ui.splash

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val PrimaryRed = Color(0xFFFF382E)
private val AccentTeal = Color(0xFF2EE5FF)
private val BackgroundDark = Color(0xFF121212)

@Composable
fun MotionCamSplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundDark)
    ) {
        SpeedLinesBackground()
        
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .align(Alignment.TopCenter)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            PrimaryRed.copy(alpha = 0.05f),
                            Color.Transparent
                        )
                    )
                )
        )
        
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(256.dp)
                .align(Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            BackgroundDark.copy(alpha = 0.8f),
                            BackgroundDark
                        )
                    )
                )
        )
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LogoSection()
            
            Spacer(modifier = Modifier.height(32.dp))
            
            AppNameSection()
        }
        
        BottomSection(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun SpeedLinesBackground() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height
        
        rotate(degrees = 15f, pivot = Offset(0f, height * 0.2f)) {
            drawLine(
                brush = Brush.horizontalGradient(
                    colors = listOf(Color.Transparent, PrimaryRed.copy(alpha = 0.3f), Color.Transparent),
                    startX = -40.dp.toPx(),
                    endX = 256.dp.toPx()
                ),
                start = Offset(-40.dp.toPx(), height * 0.2f),
                end = Offset(256.dp.toPx(), height * 0.2f),
                strokeWidth = 1.dp.toPx()
            )
        }
        
        rotate(degrees = -10f, pivot = Offset(width + 80.dp.toPx(), height * 0.45f)) {
            drawLine(
                brush = Brush.horizontalGradient(
                    colors = listOf(Color.Transparent, AccentTeal.copy(alpha = 0.3f), Color.Transparent),
                    startX = width - 384.dp.toPx(),
                    endX = width + 80.dp.toPx()
                ),
                start = Offset(width - 384.dp.toPx(), height * 0.45f),
                end = Offset(width + 80.dp.toPx(), height * 0.45f),
                strokeWidth = 1.dp.toPx()
            )
        }
        
        rotate(degrees = 5f, pivot = Offset(-80.dp.toPx(), height * 0.75f)) {
            drawLine(
                brush = Brush.horizontalGradient(
                    colors = listOf(Color.Transparent, PrimaryRed.copy(alpha = 0.3f), Color.Transparent),
                    startX = -80.dp.toPx(),
                    endX = 320.dp.toPx()
                ),
                start = Offset(-80.dp.toPx(), height * 0.75f),
                end = Offset(320.dp.toPx(), height * 0.75f),
                strokeWidth = 1.dp.toPx()
            )
        }
        
        rotate(degrees = -20f, pivot = Offset(width * 0.9f, height * 0.1f)) {
            drawLine(
                brush = Brush.horizontalGradient(
                    colors = listOf(Color.Transparent, AccentTeal.copy(alpha = 0.3f), Color.Transparent),
                    startX = width * 0.9f - 192.dp.toPx(),
                    endX = width * 0.9f
                ),
                start = Offset(width * 0.9f - 192.dp.toPx(), height * 0.1f),
                end = Offset(width * 0.9f, height * 0.1f),
                strokeWidth = 1.dp.toPx()
            )
        }
        
        rotate(degrees = -5f, pivot = Offset(width * 1.05f, height * 0.85f)) {
            drawLine(
                brush = Brush.horizontalGradient(
                    colors = listOf(Color.Transparent, PrimaryRed.copy(alpha = 0.3f), Color.Transparent),
                    startX = width * 1.05f - 500.dp.toPx(),
                    endX = width * 1.05f
                ),
                start = Offset(width * 1.05f - 500.dp.toPx(), height * 0.85f),
                end = Offset(width * 1.05f, height * 0.85f),
                strokeWidth = 1.dp.toPx()
            )
        }
    }
}

@Composable
fun LogoSection() {
    Box(
        modifier = Modifier.size(128.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(160.dp)
                .background(PrimaryRed.copy(alpha = 0.2f), CircleShape)
                .blur(32.dp)
        )
        
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            
            Box(
                modifier = Modifier
                    .height(4.dp)
                    .fillMaxWidth()
                    .offset(x = 16.dp)
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(Color.Transparent, PrimaryRed.copy(alpha = 0.6f), Color.Transparent)
                        ),
                        CircleShape
                    )
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Box(
                modifier = Modifier
                    .height(4.dp)
                    .fillMaxWidth()
                    .offset(x = (-16).dp)
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(Color.Transparent, AccentTeal.copy(alpha = 0.6f), Color.Transparent)
                        ),
                        CircleShape
                    )
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Box(
                modifier = Modifier
                    .height(4.dp)
                    .fillMaxWidth()
                    .offset(x = 8.dp)
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(Color.Transparent, PrimaryRed.copy(alpha = 0.6f), Color.Transparent)
                        ),
                        CircleShape
                    )
            )
            
            Spacer(modifier = Modifier.weight(1f))
        }
        
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(BackgroundDark, CircleShape)
                .padding(2.dp)
                .background(Color.White.copy(alpha = 0.05f), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(
                        Brush.radialGradient(
                            colors = listOf(
                                Color.White.copy(alpha = 0.05f),
                                Color.Transparent
                            )
                        ),
                        CircleShape
                    )
                    .padding(1.dp)
                    .background(Color.White.copy(alpha = 0.02f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(Color.Transparent, CircleShape)
                        .padding(4.dp)
                        .background(PrimaryRed, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(Color.White, CircleShape)
                    )
                }
            }
            
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.radialGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.White.copy(alpha = 0.05f),
                                Color.White.copy(alpha = 0.1f)
                            )
                        ),
                        CircleShape
                    )
                    .rotate(45f)
            )
        }
    }
}

@Composable
fun AppNameSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontSize = 48.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontStyle = FontStyle.Italic
                    )
                ) {
                    append("MOTION")
                }
                withStyle(
                    style = SpanStyle(
                        color = PrimaryRed,
                        fontSize = 48.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontStyle = FontStyle.Italic
                    )
                ) {
                    append("CAM")
                }
            },
            letterSpacing = (-2).sp
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .width(32.dp)
                    .height(1.dp)
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(Color.Transparent, Color.White.copy(alpha = 0.2f))
                        )
                    )
            )
            
            Spacer(modifier = Modifier.width(8.dp))
            
            Text(
                text = "PREMIUM DASHCAM",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White.copy(alpha = 0.4f),
                letterSpacing = 3.sp
            )
            
            Spacer(modifier = Modifier.width(8.dp))
            
            Box(
                modifier = Modifier
                    .width(32.dp)
                    .height(1.dp)
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(Color.White.copy(alpha = 0.2f), Color.Transparent)
                        )
                    )
            )
        }
    }
}

@Composable
fun BottomSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 64.dp, start = 32.dp, end = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        Box(
            modifier = Modifier
                .width(192.dp)
                .height(4.dp)
                .background(Color.White.copy(alpha = 0.05f), CircleShape)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.33f)
                    .fillMaxHeight()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(PrimaryRed, AccentTeal)
                        ),
                        CircleShape
                    )
            )
        }
        
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "CAPTURE EVERY MILE",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White.copy(alpha = 0.6f),
                letterSpacing = 4.sp,
                textAlign = TextAlign.Center
            )
            
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 4.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = null,
                    tint = PrimaryRed,
                    modifier = Modifier.size(10.dp)
                )
                
                Spacer(modifier = Modifier.width(4.dp))
                
                Text(
                    text = "ENCRYPTED RECORDING ACTIVE",
                    fontSize = 9.sp,
                    color = Color.White.copy(alpha = 0.3f),
                    letterSpacing = 0.sp
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF121212)
@Composable
fun MotionCamSplashScreenPreview() {
    MotionCamSplashScreen()
}
