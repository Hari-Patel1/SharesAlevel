package com.alevel.features.auth.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.alevel.theme.Black
import com.alevel.theme.BlueGray
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun SocialMediaLogIn(


    modifier: Modifier = Modifier,
    icon: DrawableResource,
    text: String
){
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .socialMedia()
            .height(40.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        //usage of image here since when using an icon, image would be black and white.
        //icon does not support aRGB
       Image(painter = painterResource(icon), contentDescription = null, modifier = Modifier.size(16.dp))

       Spacer(modifier = Modifier.width(5.dp))
        
       Text(
           text = text,
           style = MaterialTheme.typography.labelMedium.copy(
               color = Color(0xFF64748B)
           )
       )
    }
}

//if the system is in dark mode, a border will not be visible
//this function creates a custom border using modifiers used only when isSystemInDarkTheme is met and uses a different color for each instance

fun Modifier.socialMedia() : Modifier = composed {
    if (isSystemInDarkTheme()){
        //dark theme border
        background(Color.Transparent).border(
            width = 2.dp,
            color = BlueGray,
            shape = RoundedCornerShape(10.dp)
        )
    }
    else{
        //light theme border
        background(Color.Transparent).border(
            width = 2.dp,
            color = Black,
            shape = RoundedCornerShape(10.dp)
        )
    }
}