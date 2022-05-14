package com.codingwithrufat.futbolapplication.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codingwithrufat.futbolapplication.R
import com.codingwithrufat.futbolapplication.network.match_list_model.DataItem

@Composable
fun MatchCardItem(
    modifier: Modifier,
    matchData: DataItem,
    onClickCard: (id: Int) -> Unit
) {

    Card(modifier = modifier.clickable(
        enabled = true,
        onClick = {
            onClickCard(matchData?.feedMatchId!!)
        }
    ),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)) {


        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_football_field),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                text = matchData.competition!!,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(vertical = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.weight(0.4f),
                    text = matchData.homeTeam?.shortName!!,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
                Text(
                    modifier = Modifier.weight(0.2f),
                    textAlign = TextAlign.Center,
                    text = "${matchData.homeTeam?.score} - ${matchData.awayTeam?.score}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
                Text(
                    modifier = Modifier.weight(0.4f),
                    textAlign = TextAlign.End,
                    text = matchData.awayTeam?.shortName!!,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                text = "${matchData.date?.substring(0, 10)}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

        }

    }

}