package com.jaques.projetos.todolist

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jaques.projetos.todolist.Adapter.TodoListAdapter
import com.jaques.projetos.todolist.model.Todo

class MainActivity : AppCompatActivity() {
        val todos: ArrayList<Todo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todos.add(Todo("Comprar Carne", false))
        todos.add(Todo("Comprar Legume", false))
        todos.add(Todo("Comprar Coffee", false))

        val recycleView= R.id.recyclerView as RecyclerView
        recycleView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)

        val adapter = TodoListAdapter(todos)
        recycleView.adapter = adapter
    }

}

