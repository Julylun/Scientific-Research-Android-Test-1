package com.example.nckh_test_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nckh_test_1.R.drawable.gradientshape
import com.example.nckh_test_1.R.drawable.gradientshape_3
import com.example.nckh_test_1.ui.theme.InterBold
import com.example.nckh_test_1.ui.theme.NCKH_Test_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NCKH_Test_1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    LoginPage("hoangluanhgl@gmail.com", "*******")
                }
            }
        }
    }
}

@Composable
fun LoginPage(demoEmail: String, demoPassword: String) {
    Surface( //Add this surface to this application to create a basic background
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Box { //Use Box component to set layer for components inside it
            Row {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    Image(
                        painter = painterResource(gradientshape),
                        "First gradient shape",
                        modifier = Modifier
                            .size(300.dp)
                            .align(Alignment.End)
                            .absoluteOffset(x = 140.dp, y = (-100).dp)
                    )
                    Image(
                        painter = painterResource(gradientshape_3),
                        "Second gradient shape",
                        modifier = Modifier
                            .size(280.dp)
                            .rotate(1.96F)
                            .align(Alignment.Start)
                            .absoluteOffset(x = -140.dp, y = 110.dp)
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxSize(),
                Arrangement.SpaceAround
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column {

                        //Login Title
                        Text(
                            "Login",
                            fontFamily = InterBold,
                            fontSize = 40.sp,
                            color = Color.Black
                        )
                        //Sub title here
                        Text(
                            "Please login to continue",
                            fontFamily = InterBold,
                            color = MaterialTheme.colorScheme.onSecondary,
                            modifier = Modifier.padding(bottom = 80.dp),
                            fontSize = 20.sp
                        )

                        //-x-x Defining login form is started here
                        IconTextField(
                            label = "Email: ",
                            imageVector = ImageVector.vectorResource(R.drawable.email_1_svgrepo_com),
                            iconSize = 25.dp,
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        IconTextField(
                            label = "Password:",
                            imageVector = ImageVector.vectorResource(R.drawable.lock_svgrepo_com),
                            iconSize = 25.dp
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        Button(
                            onClick = {},
                            modifier = Modifier.align(Alignment.End)
                                .shadow(0.dp,0.dp,20.dp,0.dp,
                                    MaterialTheme.colorScheme.secondaryContainer.copy(0.8f)
                                )
                                .background(
                                    Brush.linearGradient(
                                        colors = listOf(
                                            MaterialTheme.colorScheme.secondaryContainer,
                                            MaterialTheme.colorScheme.primaryContainer
                                        ),
                                    ),
                                    shape = RoundedCornerShape(30.dp),
                                ).width(115.dp).height(45.dp)
                            ,
                            colors = ButtonDefaults.outlinedButtonColors()
                        ) {
                            Text(
                                "Login",
                                fontFamily = InterBold,
                                fontSize = 15.sp,
                                modifier = Modifier.graphicsLayer {
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IconTextField(
    label: String, imageVector: ImageVector, iconSize: Dp = 20.dp,
) {
    var typingText by remember {
        mutableStateOf("")
    }
    var isFocused by remember { mutableStateOf(false) }
    Text(
        label,
        fontFamily = InterBold,
        color = MaterialTheme.colorScheme.onSecondary,
        fontSize = 14.sp
    )

    OutlinedTextField(
        value = typingText,
        onValueChange = {
            typingText = it
        },
        leadingIcon = {
            Icon(
                imageVector = imageVector,
                "Email icon",
                modifier = Modifier.size(iconSize)
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.primary, //Create background for this
            //textfield
            unfocusedContainerColor = MaterialTheme.colorScheme.primary,
            focusedIndicatorColor = Color.Transparent, //Make outline be transparent
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            cursorColor = Color.Black
        ),
        modifier = Modifier.shadow( //If the text field is being focusing, create a shadow behind it
            //else create a line below it (still a shadow)
            offsetX = if (isFocused) 4.dp else 0.dp,
            offsetY = if (isFocused) 10.dp else 1.dp,
            blurAmount = if (isFocused) 18.7.dp else 0.dp,
            spread = if (isFocused) (-2).dp else 0.dp,
            Color.Black.copy(
                alpha = if(isFocused) 0.2f else 0.3f
            )
        ).onFocusChanged { //If the text field is being focusing then assign true to "isFocused"
            focusState -> isFocused = focusState.isFocused
        },
        shape = RectangleShape
    )



}


@Composable
@Preview
fun LoginPagePreview() {
    NCKH_Test_1Theme {
        Surface(modifier = Modifier.fillMaxSize()) {
            LoginPage("hoangluanhgl@gmail.com", "***********")
        }

    }
}
