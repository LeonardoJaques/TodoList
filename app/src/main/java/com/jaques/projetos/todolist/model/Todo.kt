package com.jaques.projetos.todolist.model

import java.time.LocalDate


data class Todo( var item: String, var completed: Boolean, var date: LocalDate? = null)