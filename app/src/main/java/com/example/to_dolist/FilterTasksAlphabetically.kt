package com.example.to_dolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class FilterTasksAlphabetically : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter_tasks_alphabetically, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity: MainActivity = context as MainActivity
        val taskList: MutableList<String> = activity.getTaskList()
        activity.sortTaskListAlpha()
        val taskLayout: LinearLayout = view.findViewById(R.id.tasksLayout)

        for (task in taskList){
            val taskTextView: TextView = TextView(context)
            taskTextView.text = task
            taskTextView.textSize = 24.0F

            taskLayout.addView(taskTextView)

        }
    }
}