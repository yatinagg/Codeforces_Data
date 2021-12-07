package com.yatinagg.codeforcesdata.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SubmissionItems(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "userHandle")
    var handle: String = "yatinagg",

    @ColumnInfo(name = "status")
    var status: String? = null,

    @ColumnInfo(name = "result")
    var result: List<Result> = arrayListOf()
)