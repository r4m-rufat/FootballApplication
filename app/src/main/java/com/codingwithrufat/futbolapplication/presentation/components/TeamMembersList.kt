package com.codingwithrufat.futbolapplication.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.codingwithrufat.futbolapplication.network.match_model.PlayersItem

@Composable
fun TeamMembersList(
    list: List<PlayersItem?>?
) {

    list?.forEach { item ->

        TeamMemberItem(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(vertical = 4.dp, horizontal = 5.dp), player = item!!
        )

    }
}
