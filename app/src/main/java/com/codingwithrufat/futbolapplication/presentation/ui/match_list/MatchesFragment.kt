package com.codingwithrufat.futbolapplication.presentation.ui.match_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.codingwithrufat.futbolapplication.R
import com.codingwithrufat.futbolapplication.presentation.components.AppBar
import com.codingwithrufat.futbolapplication.presentation.components.CircularIndeterminateProgressBar
import com.codingwithrufat.futbolapplication.presentation.components.MatchList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchesFragment : Fragment() {

    private val viewModel: MatchesViewModel by viewModels()

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

                setupObservableItems()

            }
        }
    }

    @Composable
    private fun setupObservableItems(){
        Column(modifier = Modifier.fillMaxSize()) {

            AppBar(page_name = "Football Application")

            viewModel.response.observeAsState().value.let {
                CircularIndeterminateProgressBar(
                    isDisplayed = viewModel.loading.observeAsState(
                        true
                    ).value
                )
                MatchList(
                    modifier = Modifier.fillMaxSize(),
                    list = it,
                    onClickItem = { id ->

                        val bundle = Bundle()
                        bundle.putInt("match_id", id)
                        findNavController().navigate(R.id.matchDetailFragment, bundle)
                    })
            }

        }
    }
}