package com.yatinagg.codeforcesdata.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yatinagg.codeforcesdata.database.AppDatabase
import com.yatinagg.codeforcesdata.model.Submission
import com.yatinagg.codeforcesdata.model.SubmissionItems
import com.yatinagg.codeforcesdata.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    val submissionList = MutableLiveData<Submission>()
    val errorMessage = MutableLiveData<String>()

    suspend fun getAllSubmissions(userHandle: String, database: AppDatabase) {


        val submissionItems: SubmissionItems =
            repository.getSubmissionsOfUserFromDB(userHandle, database)
        println(submissionItems)

        submissionItems?.let {
            submissionList.postValue(Submission(submissionItems.status, submissionItems.result))
        }

        Log.d("output1", "getAllSubmissions control");
        val response = repository.getAllSubmissions(userHandle)
        response.enqueue(object : Callback<Submission> {
            override fun onResponse(call: Call<Submission>, response: Response<Submission>) {

                val submissionItem =
                    response.body()?.result?.let { SubmissionItems(userHandle, "Success", it) }
                viewModelScope.launch {
                    if (submissionItem != null)
                        repository.insertSubmission(submissionItem, database)
                }
                submissionList.postValue(response.body())
                Log.d("output1", response.body().toString())
            }

            override fun onFailure(call: Call<Submission>, t: Throwable) {
                errorMessage.postValue(t.message)
                Log.d("output1", "failure" + t.message)
            }
        })
    }
}