package com.codingwithrufat.futbolapplication.network.match_model

data class EventsItem(
	val time: String? = null,
	val type: String? = null,
	val eventTimestamp: String? = null,
	val eventId: Long? = null,
	val period: String? = null,
	val substitutionDetails: SubstitutionDetails? = null,
	val teamId: String? = null,
	val optaMinute: Int? = null,
	val minute: Int? = null,
	val goalDetails: GoalDetails? = null
)
