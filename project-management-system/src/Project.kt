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
}