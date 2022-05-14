package com.codingwithrufat.futbolapplication.repository

import com.codingwithrufat.futbolapplication.network.match_list_model.MatchListResponse
import retrofit2.Response

interface MatchListRepository {
    suspend fun getMatches(comp_id: Int, season: Int): Response<MatchListResponse>
}