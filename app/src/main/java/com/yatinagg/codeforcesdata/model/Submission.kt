package com.yatinagg.codeforcesdata.model

import com.google.gson.annotations.SerializedName


data class Submission(

    @SerializedName("status") var status: String? = null,
    @SerializedName("result") var result: List<Result> = arrayListOf()

)