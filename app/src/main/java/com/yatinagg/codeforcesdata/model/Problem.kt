package com.yatinagg.codeforcesdata.model

import com.google.gson.annotations.SerializedName


data class Problem(

    @SerializedName("contestId") var contestId: Int? = null,
    @SerializedName("index") var index: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("points") var points: Int? = null,
    @SerializedName("rating") var rating: Int? = null,
    @SerializedName("tags") var tags: List<String> = arrayListOf()

)