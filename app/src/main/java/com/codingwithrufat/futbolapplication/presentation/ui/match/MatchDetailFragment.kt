package com.codingwithrufat.futbolapplication.presentation.ui.match

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.codingwithrufat.futbolapplication.network.match_model.Data
import com.codingwithrufat.futbolapplication.presentation.components.AppBar
import com.codingwithrufat.futbolapplication.presentation.components.CircularIndeterminateProgressBar
import com.codingwithrufat.futbolapplication.presentation.components.TeamMembersList
import com.codingwithrufat.futbolapplication.presentation.components.TopMatchCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchDetailFragment : Fragment() {

    private val matchDetailViewModel: MatchDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {

                setObservableItems()

            }
        }
    }

    @Composable
    private fun putTeamNameToCenter(string: String) {

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp, vertical = 10.dp),
            text = string,
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }

    @Composable
    private fun setObservableItems() {
        CircularIndeterminateProgressBar(isDisplayed = matchDetailViewModel.loading.observeAsState(true).value)
        matchDetailViewModel.response.observeAsState().value?.let {
                setupPageWidgets(data = it)

        }
    }

    @Composable
    private fun setupPageWidgets(data: Data) {

        Column(modifier = Modifier.fillMaxSize()) {

            AppBar(page_name = "Match Detail")

            TopMatchCard(
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 8.dp)
                    .fillMaxWidth()
                    .height(150.dp), data = data!!
            )

            LazyColumn(modifier = Modifier.fillMaxSize()){

                item {
                    putTeamNameToCenter(string = data.homeTeam?.shortName!!)

                    TeamMembersList(
                        list = data.homeTeam?.players
                    )
                }

                item {
                    putTeamNameToCenter(string = data.awayTeam?.shortName!!)

                    TeamMembersList(
                        list = data.awayTeam?.players
                    )
                }

            }

        }

    }

}