import java.time.LocalDate

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