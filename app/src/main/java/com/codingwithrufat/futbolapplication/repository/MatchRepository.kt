package com.codingwithrufat.futbolapplication.repository

import com.codingwithrufat.futbolapplication.network.match_model.MatchDetailResponse
import retrofit2.Response

interface MatchRepository {
    suspend fun getMatchDetail(match_id: Int): Response<MatchDetailResponse>
}