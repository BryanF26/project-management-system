import java.time.LocalDate

enum class ProjectStatus {
    Active, Completed, OnHold
}

class Project (
    val id: Int,
    var name: String,
    var deadline: LocalDate,
    var status: ProjectStatus,
    val tasks: MutableList<Task> = mutableListOf()
) {
    fun checkProjectStatus() {
        if (tasks.)
    }
}