package com.example.to_dolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.navigateUp

class AddTasks : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_tasks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addTaskBtn: Button = view.findViewById(R.id.AddToTaskList)

        val navController: NavController = view.findNavController()

        addTaskBtn.setOnClickListener{
            Toast.makeText(activity, "Task Added, check back on your to-do list.", Toast.LENGTH_SHORT).show()

            val taskNameInput: EditText = view.findViewById(R.id.TaskNameInput)
            val taskDateInput: EditText = view.findViewById(R.id.TaskDateInput)

            val passedData: Bundle = Bundle()

            passedData.putString("taskName", taskNameInput.text.toString())
            passedData.putString("taskDate", taskDateInput.text.toString())
            navController.navigate(R.id.action_addTasks_to_allTasks, passedData)
        }
    }
}