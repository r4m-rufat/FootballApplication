package com.codingwithrufat.futbolapplication.network.match_model

data class Data(
	val date: String? = null,
	val venue: Venue? = null,
	val competitionId: Int? = null,
	val period: String? = null,
	val awayTeam: AwayTeam? = null,
	val feedMatchId: Int? = null,
	val competition: String? = null,
	val type: String? = null,
	val minute: Int? = null,
	val lastUpdated: String? = null,
	val round: Int? = null,
	val seasonId: Int? = null,
	val officials: List<OfficialsItem?>? = null,
	val season: String? = null,
	val homeTeam: HomeTeam? = null,
	val id: String? = null,
	val skyId: Int? = null,
	val attendance: Int? = null,
	val events: List<EventsItem?>? = null,
	val status: String? = null
)
