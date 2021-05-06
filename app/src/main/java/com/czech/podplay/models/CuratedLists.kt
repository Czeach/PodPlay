package com.czech.podplay.models


import com.google.gson.annotations.SerializedName

data class CuratedLists(
    @SerializedName("curated_lists")
    val curatedLists: List<CuratedLists?>?,
    val total: Int?,
    @SerializedName("has_next")
    val hasNext: Boolean?,
    @SerializedName("has_previous")
    val hasPrevious: Boolean?,
    @SerializedName("page_number")
    val pageNumber: Int?,
    @SerializedName("previous_page_number")
    val previousPageNumber: Int?,
    @SerializedName("next_page_number")
    val nextPageNumber: Int?
) {
    data class CuratedLists(
        val id: String?,
        val title: String?,
        val description: String?,
        @SerializedName("source_url")
        val sourceUrl: String?,
        @SerializedName("source_domain")
        val sourceDomain: String?,
        @SerializedName("pub_date_ms")
        val pubDateMs: Long?,
        val podcasts: List<Podcast?>?,
        val total: Int?,
        @SerializedName("listennotes_url")
        val listennotesUrl: String?
    ) {
        data class Podcast(
            val id: String?,
            val title: String?,
            val publisher: String?,
            val image: String?,
            val thumbnail: String?,
            @SerializedName("listennotes_url")
            val listennotesUrl: String?,
            @SerializedName("listen_score")
            val listenScore: String?,
            @SerializedName("listen_score_global_rank")
            val listenScoreGlobalRank: String?
        )
    }
}