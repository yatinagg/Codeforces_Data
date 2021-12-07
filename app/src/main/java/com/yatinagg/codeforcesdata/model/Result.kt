package com.yatinagg.codeforcesdata.model

import com.google.gson.annotations.SerializedName


data class Result(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("contestId") var contestId: Int? = null,
    @SerializedName("creationTimeSeconds") var creationTimeSeconds: Int? = null,
    @SerializedName("relativeTimeSeconds") var relativeTimeSeconds: Int? = null,
    @SerializedName("problem") var problem: Problem? = Problem(),
    @SerializedName("author") var author: Author? = Author(),
    @SerializedName("programmingLanguage") var programmingLanguage: String? = null,
    @SerializedName("verdict") var verdict: String? = null,
    @SerializedName("testset") var testset: String? = null,
    @SerializedName("passedTestCount") var passedTestCount: Int? = null,
    @SerializedName("timeConsumedMillis") var timeConsumedMillis: Int? = null,
    @SerializedName("memoryConsumedBytes") var memoryConsumedBytes: Int? = null

)