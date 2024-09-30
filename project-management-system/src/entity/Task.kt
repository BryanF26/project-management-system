package entity

import enum.TaskPriority
import enum.TaskStatus
import java.time.LocalDate

class Task(
    val id: Int,
    var description:String,
    var priority: TaskPriority,
    var assignedTo: User?,
    var status: TaskStatus,
    var dueDate:LocalDate?
) {
    init {
        if(description.isBlank()) throw IllegalArgumentException("Description cannot be empty.")
    }
}