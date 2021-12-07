package com.yatinagg.codeforcesdata.repository

import com.yatinagg.codeforcesdata.database.AppDatabase
import com.yatinagg.codeforcesdata.model.RetrofitService
import com.yatinagg.codeforcesdata.model.SubmissionItems
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllSubmissions(userHandle: String) = retrofitService.getAllSubmissions(userHandle, 1, 20)

    suspend fun getSubmissionsOfUserFromDB(
        userHandle: String,
        database: AppDatabase
    ): SubmissionItems = coroutineScope {
        println("hello")
        withContext(Dispatchers.IO) {

            val submissionDao = database.submissionDao()
            val submission: SubmissionItems = submissionDao.getSubmissionsOfUser(userHandle)
            println("getAll$submission")
            submission
        }
    }

    suspend fun insertSubmission(submissionItem: SubmissionItems, database: AppDatabase) {
        withContext(Dispatchers.IO) {
            val submissionDao = database.submissionDao()
            submissionDao.insertSubmission(submissionItem)
            println("insert$submissionItem")
        }
    }

}
