package com.example.to_dolist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfig: AppBarConfiguration
    private lateinit var navController: NavController

    private var taskList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val appBar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(appBar)

        val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        val navGraph: NavGraph = navController.graph // get the navigation graph associated with the controller
        appBarConfig = AppBarConfiguration(navGraph) // create an app configuration based on the nav graph
        setupActionBarWithNavController(navController, appBarConfig)
    }

    override fun onSupportNavigateUp(): Boolean {
        val success: Boolean = navController.navigateUp(appBarConfig)
        return success || super.onSupportNavigateUp()
    }

    fun getTaskList(): MutableList<String> {
        return taskList
    }

    fun setTaskItem(newTask: String){
        taskList.add(newTask)
    }

    fun sortTaskListAlpha() {
        taskList.sort()
    }

    fun sortTaskListDate() {
        taskList.sortBy { it.substring(it.indexOf(":")) }
    }

}