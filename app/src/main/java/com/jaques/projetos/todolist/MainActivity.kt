package com.jaques.projetos.todolist

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jaques.projetos.todolist.Adapter.OnItemClickListener
import com.jaques.projetos.todolist.Adapter.TodoListAdapter
import com.jaques.projetos.todolist.model.Todo
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity(), OnItemClickListener {
    val todos: ArrayList<Todo> = ArrayList()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todos.add(Todo("Comprar Carne", false))
        todos.add(Todo("Comprar Legume", false))
        todos.add(Todo("Comprar Coffee", true, LocalDate.now()))

        val recycleView = findViewById<RecyclerView>(R.id.recyclerView)
        recycleView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val adapter = TodoListAdapter(todos, this)
        recycleView.adapter = adapter
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onItemClicked(todo: Todo) {
        todo.completed = !todo.completed
        if(!todo.completed)
            todo.date = null
        else
            todo.date = LocalDate.now()
        Log.i("TODO_", todo.item)
        val recycleView = findViewById<RecyclerView>(R.id.recyclerView)
        recycleView.adapter?.notifyDataSetChanged()
    }
}

