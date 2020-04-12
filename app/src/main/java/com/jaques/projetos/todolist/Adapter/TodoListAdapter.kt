package com.jaques.projetos.todolist.Adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.jaques.projetos.todolist.R
import com.jaques.projetos.todolist.model.Todo
import kotlinx.android.synthetic.main.todo_list.view.*
import java.time.format.DateTimeFormatter

class TodoListAdapter (val todoList: ArrayList<Todo>):
    RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        @RequiresApi(Build.VERSION_CODES.O)
        fun bindItems(todo: Todo): Unit {
            val chbItem = itemView.chbItem
            val textViewDate:TextView = itemView.textViewDate

            chbItem.text = todo.item
            chbItem.isChecked = todo.completed
            val formater = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            textViewDate.text = todo.date?.format(formater) ?: ""
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layout = LayoutInflater.from(parent.context).inflate(R.layout.todo_list, parent, false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: TodoListAdapter.ViewHolder, position: Int) {
        holder.bindItems(todoList[position])
    }


}