package com.codingwithrufat.futbolapplication.network.match_model

data class PlayersItem(
	val firstName: String? = null,
	val lastName: String? = null,
	val known: String? = null,
	val shirtNumber: Int? = null,
	val playerStats: PlayerStats? = null,
	val id: Int? = null,
	val position: String? = null,
	val captain: Boolean? = null,
	val status: String? = null,
	val imageUrl: String? = null
)
