package com.codingwithrufat.futbolapplication.network

import com.codingwithrufat.futbolapplication.network.match_list_model.MatchListResponse
import com.codingwithrufat.futbolapplication.network.match_model.MatchDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {

    @GET("matches?") // https://feeds.incrowdsports.com/provider/opta/football/v1/matches?compId=2&season=2020
    suspend fun getAllMatches(
        @Query("compId") compId: Int,
        @Query("season") season: Int,
    ): Response<MatchListResponse>

    @GET("matches/{id}") // https://feeds.incrowdsports.com/provider/opta/football/v1/matches/2210271
    suspend fun getDetailedMatch(
        @Path("id") match_id: Int
    ): Response<MatchDetailResponse>

}