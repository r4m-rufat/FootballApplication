package com.codingwithrufat.futbolapplication.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.codingwithrufat.futbolapplication.network.match_model.PlayersItem
import androidx.compose.ui.res.painterResource

import com.codingwithrufat.futbolapplication.R


@Composable
fun TeamMemberItem(
    modifier: Modifier,
    player: PlayersItem
) {

    Card(
        modifier = modifier,
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {

        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = player.position!!,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                color = Color.Black,
            )

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                player.imageUrl.let { 
                    if (!it.isNullOrEmpty()){
                        AsyncImage(
                            model = player.imageUrl,
                            contentDescription = null,
                            modifier = Modifier
                                .weight(0.2f)
                                .size(50.dp)
                                .clip(CircleShape)

                        )
                    }else{
                        Image(
                            painter = painterResource(id = R.drawable.ic_person),
                            contentDescription = null,
                            modifier = Modifier
                                .weight(0.2f)
                                .size(50.dp)
                                .clip(CircleShape)

                        )
                    }
                }

                Text(
                    modifier = Modifier.weight(0.6f),
                    text = "${player.firstName} ${player.lastName}",
                    fontSize = 14.sp,
                    color = Color.Black,
                )

                Text(
                    modifier = Modifier.weight(0.2f),
                    text = "${player.shirtNumber}",
                    textAlign = TextAlign.Center,
                    fontSize = 28.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

            }

        }

    }

}