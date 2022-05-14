package com.codingwithrufat.futbolapplication.repository

import com.codingwithrufat.futbolapplication.network.RetrofitService
import com.codingwithrufat.futbolapplication.network.match_model.MatchDetailResponse
import retrofit2.Response
import javax.inject.Inject

class MatchRepository_Impl
    @Inject constructor(private val retrofitService: RetrofitService) : MatchRepository {
    override suspend fun getMatchDetail(match_id: Int) = retrofitService.getDetailedMatch(match_id)
}