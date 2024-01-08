package com.harrymuema.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter : TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        findViewById<RecyclerView>(R.id.rvToDoItems).adapter = todoAdapter
        findViewById<RecyclerView>(R.id.rvToDoItems).layoutManager = LinearLayoutManager( this)

        findViewById<Button>(R.id.btnAddToDo).setOnClickListener {
            val todoTitle =  findViewById<EditText>(R.id.etToDoTitle).text.toString()
            if(todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle)
                todoAdapter.addToDo((todo))
                findViewById<EditText>(R.id.etToDoTitle).text.clear()
            }
        }

        findViewById<Button>( R.id.btnDeleteDoneToDo).setOnClickListener{
            todoAdapter.deleteToDo()
        }

    }
}