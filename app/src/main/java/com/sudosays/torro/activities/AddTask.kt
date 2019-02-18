package com.sudosays.torro.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_task.*
import kotlinx.android.synthetic.main.edit_task.view.*

import com.sudosays.torro.R
import com.sudosays.torro.TaskInsertAsync
import com.sudosays.torro.data.Task
import com.sudosays.torro.data.TaskDatabase

class AddTask : AppCompatActivity() {

    private lateinit var db: TaskDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        db = TaskDatabase.getInstance(this)
    }

    fun saveTask(view: View)
    {

        val task = Task(0,taskEditview.nameEditText.text.toString(), taskEditview.durationEditText.text.toString().toFloat())
        TaskInsertAsync(db).execute(task)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
}
