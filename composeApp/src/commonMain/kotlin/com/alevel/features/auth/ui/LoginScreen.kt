package com.alevel.features.auth.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.alevel.features.auth.models.LoginModel
import com.alevel.theme.Black
import com.alevel.theme.BlueGray
import org.jetbrains.compose.resources.painterResource
import sharesapp.composeapp.generated.resources.Res
import sharesapp.composeapp.generated.resources.facebook
import sharesapp.composeapp.generated.resources.google
import sharesapp.composeapp.generated.resources.shape
import sharesapp.composeapp.generated.resources.stock

class LoginScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val model = LoginModel()

        //creates a screen which will contain all designs and items
        //screen uses material design which works better with system wide settings like dark/light themes
        Surface {
            val uiColour = if (isSystemInDarkTheme()) Color.White else Black
            //passing the modifier allows the screen to occupy the largest size possible
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                //sets the background of the screen
                Box(contentAlignment = Alignment.TopCenter) {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.46f),
                        painter = painterResource(Res.drawable.shape),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                    Row (
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(start = 10.dp)
                            .align(Alignment.TopStart)
                    ){
                        IconButton(
                            onClick = { navigator.pop() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null,
                                tint = uiColour
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .padding(top = 80.dp),
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Icon(
                            modifier = Modifier.size(50.dp),
                            painter = painterResource(Res.drawable.stock),
                            contentDescription = null,
                            tint = uiColour
                        )

                        Spacer(
                            modifier = Modifier
                                .width(15.dp)
                        )

                        //column to contain the app name and slogan and center it under each other
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "test Text",
                                style = MaterialTheme.typography.headlineMedium,
                                color = uiColour
                            )

                            Text(
                                text = "test Text",
                                style = MaterialTheme.typography.titleMedium,
                                color = uiColour
                            )
                        }
                    }
                    Text(
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .align(Alignment.BottomCenter),
                        text = "Log In",
                        style = MaterialTheme.typography.headlineLarge,
                        color = uiColour
                    )
                }


                //the two variables give functionality to the text fields.
                //there has to be two separate variables since they cannot share a value
                val email = remember { mutableStateOf("") }
                val password = remember { mutableStateOf("") }

                Spacer(
                    modifier = Modifier
                        .size(36.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {

                    TextField(
                        //passing certain params such as label and text colours helps the textfield blend in better
                        value = email.value,
                        onValueChange = { email.value = it },
                        label = { Text("Username or Email", color = uiColour) },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            focusedLabelColor = uiColour,
                            unfocusedLabelColor = uiColour,
                        ),
                        textStyle = TextStyle(color = uiColour),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(
                        modifier = Modifier.height(25.dp)
                    )

                    TextField(
                        value = password.value,
                        onValueChange = { password.value = it },
                        label = { Text("Password", color = uiColour) },
                        trailingIcon = {
                            Text(
                                text = "Forgot?",
                                color = uiColour,
                                fontSize = 12.sp,
                                modifier = Modifier.clickable { navigator.push(ForgotPassScreen()) }
                            )
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            focusedLabelColor = uiColour,
                            unfocusedLabelColor = uiColour,
                        ),
                        textStyle = TextStyle(color = uiColour),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp),
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isSystemInDarkTheme()) BlueGray else Black,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(size = 10.dp)
                    ) {
                        Text(
                            text = "Log In Now",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(30.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Or Continue With...",
                            style = MaterialTheme.typography.labelMedium.copy(color = Color.Gray),
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            SocialMediaLogIn(
                                modifier = Modifier
                                    .weight(1f)
                                    .clickable { /*TODO*/ },
                                icon = Res.drawable.google,
                                text = "Google"
                            )

                            Spacer(modifier = Modifier.width(20.dp))

                            SocialMediaLogIn(
                                modifier = Modifier
                                    .weight(1f)
                                    .clickable { /*TODO*/ },
                                icon = Res.drawable.facebook,
                                text = "Facebook"
                            )
                        }
                    }
                }


            }
            Row(
                modifier = Modifier
                    //here, passing the modifier and dp stops the text from being at the very bottom of the surface.
                    //this is done by adding padding from the bottom up, so that the text cannot occupy any space 40dp from the bottom.
                    .padding(bottom = 40.dp)
                    .fillMaxHeight()
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom

            ) {


                Text(
                    text = "Don't have an account? ",
                    color = uiColour
                )
                Text(
                    modifier = Modifier.clickable { navigator.push(SignUpScreen()) },
                    text = "Create one now",
                    color = uiColour,
                    fontWeight = FontWeight.ExtraBold,
                )
            }
        }
    }
}

