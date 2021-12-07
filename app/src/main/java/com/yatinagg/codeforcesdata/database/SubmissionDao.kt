package com.yatinagg.codeforcesdata.database

import androidx.room.*
import com.yatinagg.codeforcesdata.model.SubmissionItems

@Dao
interface SubmissionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSubmission(submission: SubmissionItems)

    @Query("Select * from submissionitems")
    fun getAllSubmissions(): List<SubmissionItems>

    @Query("Select * from submissionitems where userHandle=:userHandle limit 1")
    fun getSubmissionsOfUser(userHandle: String): SubmissionItems

    @Update
    fun updateSubmission(submission: SubmissionItems)

    @Delete
    fun deleteSubmission(submission: SubmissionItems)

}