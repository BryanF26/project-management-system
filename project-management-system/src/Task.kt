import java.time.LocalDate

class Task(
    val id: Int,
    var description:String,
    var priority: TaskPriority,
    var assignedTo:User,
    var status:TaskStatus,
    var dueDate:LocalDate
) {
    fun greet() {

    }
}