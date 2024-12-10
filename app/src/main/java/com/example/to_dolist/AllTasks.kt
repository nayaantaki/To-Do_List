package com.example.to_dolist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.findNavController

class AllTasks : Fragment() {
    override fun onCreateView( //this may be getting ignored because the fragment isnt being destroyed??
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_all_tasks, container, false)

        val parentLayout = view.findViewById<LinearLayout>(R.id.tasksLayout)

        val args: Bundle? = arguments
        if (args != null) {
            val task: TextView = TextView(context).apply {
                text = args.getString("taskName") + args.getString("taskDate")
            }
            parentLayout.addView(task)
        }

        return inflater.inflate(R.layout.fragment_all_tasks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController: NavController = view.findNavController();

        val toAddTasksBtn: Button = view.findViewById(R.id.toAddTasks)
        toAddTasksBtn.setOnClickListener {
            navController.navigate(R.id.action_allTasks_to_addTasks)
        }

        val toFilterTasksDateBtn: Button = view.findViewById(R.id.toFilterTasksDate)
        toFilterTasksDateBtn.setOnClickListener {
            navController.navigate(R.id.action_allTasks_to_filterTasksDate)
        }

        val toFilterTasksAlphabeticallyBtn: Button = view.findViewById(R.id.toFilterTasksAlphabetically)
        toFilterTasksAlphabeticallyBtn.setOnClickListener {
            navController.navigate(R.id.action_allTasks_to_filterTasksAlphabetically)
        }
    }
}