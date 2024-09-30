import java.time.LocalDate

class Project (
    val id: Int,
    var name: String,
    var deadline: LocalDate,
    var status: ProjectStatus,
    val tasks: MutableList<Task> = mutableListOf()
) {
    init {
        if(name.isBlank()) {
            throw IllegalArgumentException( "Project name must not be empty.")
        }
    }
    fun checkProjectStatus() {
        var allCompleted = true

        for (task in tasks) {
            if (task.status != TaskStatus.Completed) {
                allCompleted = false
                break
            }
        }

        if (allCompleted) {
            status = ProjectStatus.Completed
        }
    }

    fun hasTasks(): Boolean {
        return tasks.isNotEmpty()
    }
}