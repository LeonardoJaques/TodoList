package com.jaques.projetos.todolist.model

import java.time.LocalDate


data class Todo( val item: String, val completed: Boolean, val date: LocalDate? = null)