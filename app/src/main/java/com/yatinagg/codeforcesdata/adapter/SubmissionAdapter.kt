package com.yatinagg.codeforcesdata.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yatinagg.codeforcesdata.databinding.ListviewSubmissionBinding
import com.yatinagg.codeforcesdata.model.Result

class SubmissionAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var submissions = mutableListOf<Result>()

    fun setSubmissionList(submissions: List<Result>) {
        this.submissions = submissions.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = ListviewSubmissionBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val submission = submissions[position]
        holder.binding.submissionText.text =
            submission.problem?.name + "\t" + submission.programmingLanguage + "\n" + submission.verdict
    }

    override fun getItemCount(): Int {
        return submissions.size
    }
}

class MainViewHolder(val binding: ListviewSubmissionBinding) :
    RecyclerView.ViewHolder(binding.root) {

}