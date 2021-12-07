package com.yatinagg.codeforcesdata.model

import com.google.gson.annotations.SerializedName


data class Author(

    @SerializedName("contestId") var contestId: Int? = null,
    @SerializedName("members") var members: List<Members> = arrayListOf(),
    @SerializedName("participantType") var participantType: String? = null,
    @SerializedName("ghost") var ghost: Boolean? = null,
    @SerializedName("room") var room: Int? = null,
    @SerializedName("startTimeSeconds") var startTimeSeconds: Int? = null

)