package com.codingwithrufat.futbolapplication.network.match_model

data class AwayTeam(
	val score: Int? = null,
	val players: List<PlayersItem?>? = null,
	val imageUrl: String? = null,
	val imageUrls: ImageUrls? = null,
	val name: String? = null,
	val id: String? = null,
	val skyId: Int? = null,
	val halfTimeScore: Int? = null,
	val shortName: String? = null,
	val abbreviation: String? = null,
	val managers: List<ManagersItem?>? = null,
	val teamStats: TeamStats? = null
)
