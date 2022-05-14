package com.codingwithrufat.futbolapplication.network.match_list_model

data class MatchListResponse(
	val metadata: Metadata? = null,
	val data: List<DataItem?>? = null,
	val status: String? = null
)
