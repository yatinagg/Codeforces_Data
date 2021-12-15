package com.yatinagg.codeforcesdata.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.google.android.material.textfield.TextInputEditText
import com.yatinagg.codeforcesdata.R
import com.yatinagg.codeforcesdata.adapter.SubmissionAdapter
import com.yatinagg.codeforcesdata.database.AppDatabase
import com.yatinagg.codeforcesdata.databinding.ActivityMainBinding
import com.yatinagg.codeforcesdata.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = SubmissionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.adapter = adapter

        viewModel.submissionList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            binding.recyclerview.visibility = View.VISIBLE
            binding.buttonSubmitDataEntry.visibility = View.GONE
            binding.etSubmissionCount.visibility = View.GONE
            binding.etSubmissionCountLayout.visibility = View.GONE
            binding.etUserHandle.visibility = View.GONE
            binding.etUserHandleLayout.visibility = View.GONE
            binding.tvHeading.visibility = View.GONE
            adapter.setSubmissionList(it.result)
        })
        val userHandle = findViewById<TextInputEditText>(R.id.et_user_handle)
        val submitButton = findViewById<Button>(R.id.button_submit_data_entry)

        submitButton.setOnClickListener {

            val text = userHandle.text

            Log.d("output1", text.toString())

            println("why so")
            val database = AppDatabase.getInstance(this)
            lifecycleScope.launch {
                println("lifecycle scope")
                viewModel.getAllSubmissions(text.toString(), database)
            }
        }

        viewModel.errorMessage.observe(this, Observer {

        })
    }

}

