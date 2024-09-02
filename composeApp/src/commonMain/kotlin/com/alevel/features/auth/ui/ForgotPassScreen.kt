package com.alevel.features.auth.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.alevel.features.auth.models.ForgotPassModel
import com.alevel.theme.Black
import org.jetbrains.compose.resources.painterResource
import sharesapp.composeapp.generated.resources.Res
import sharesapp.composeapp.generated.resources.shape
import sharesapp.composeapp.generated.resources.stock


class ForgotPassScreen : Screen {
    @Composable
    override fun Content() {
        //object which allows the control of the state of the screen
        val navigator = LocalNavigator.currentOrThrow
        val model = ForgotPassModel()


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
                        //sets the image at the right height (80.dp from the top)
                        modifier = Modifier
                            .padding(top = 80.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
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
                                text = "Test Text",
                                style = MaterialTheme.typography.headlineMedium,
                                color = uiColour
                            )

                            Text(
                                text = "Test Text",
                                style = MaterialTheme.typography.titleMedium,
                                color = uiColour
                            )
                        }
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .align(Alignment.BottomCenter)
                    ) {
                        Text(
                            text = "Forgot Password?",
                            style = MaterialTheme.typography.headlineLarge,
                            color = uiColour,
                        )
                        Text(text = "Reset it now")


                    }
                }




                Spacer(
                    modifier = Modifier
                        .size(36.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {

                    Text(text = "NOT IMPLEMENTED")
                    Text(text = "will need a database to implement such as mongodb or firebase")
                }
            }
        }
    }
}