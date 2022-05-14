package com.codingwithrufat.futbolapplication.repository

import com.codingwithrufat.futbolapplication.network.RetrofitService
import javax.inject.Inject

class MatchListRepository_Impl
    @Inject constructor(private val retrofitService: RetrofitService) : MatchListRepository {
    override suspend fun getMatches(comp_id: Int, season: Int) = retrofitService.getAllMatches(compId = comp_id, season = season)
}