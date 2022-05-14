package com.codingwithrufat.futbolapplication.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.codingwithrufat.futbolapplication.network.match_list_model.DataItem

@Composable
fun MatchList(
    modifier: Modifier,
    list: List<DataItem?>?,
    onClickItem: (index: Int) -> Unit
) {

    val state = rememberLazyListState()

    LazyColumn(modifier = modifier, state = state) {
        list?.let {
            itemsIndexed(items = it) { _, item ->

                MatchCardItem(
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 8.dp)
                        .fillMaxWidth()
                        .height(150.dp),
                    matchData = item!!,
                    onClickCard = {
                        onClickItem(it)
                    })

            }
        }
    }

}