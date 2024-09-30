import java.time.LocalDate

class Project (
    val id: Int,
    var name: String,
    var deadline: LocalDate,
    var status: ProjectStatus,
    val tasks: MutableList<Task> = mutableListOf()
) {
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
    }s
}