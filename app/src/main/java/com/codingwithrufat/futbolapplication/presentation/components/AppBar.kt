package com.codingwithrufat.futbolapplication.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codingwithrufat.futbolapplication.R
import com.codingwithrufat.futbolapplication.presentation.theme.DarkBlue

@Composable
fun AppBar(
    page_name: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(DarkBlue),
        verticalAlignment = Alignment.CenterVertically,
    ) {

            Image(modifier = Modifier.padding(horizontal = 10.dp).size(40.dp), painter = painterResource(id = R.drawable.ic_ball), contentDescription = null)
            Text(
                text = page_name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )
    }

}