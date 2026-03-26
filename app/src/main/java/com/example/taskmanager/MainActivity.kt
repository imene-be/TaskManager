package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.room.Room
import com.example.taskmanager.data.AppDb
import com.example.taskmanager.ui.TaskScreen
import com.example.taskmanager.ui.TaskViewModel
import com.example.taskmanager.ui.TaskViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(applicationContext, AppDb::class.java, "db").build()
        val dao = db.dao()

        val viewModel: TaskViewModel by viewModels { TaskViewModelFactory(dao) }

        setContent {
            TaskScreen(viewModel)
        }
    }
}
