import java.time.LocalDate

class ProjectManager{

    private val projects = mutableListOf<Project>()
    private val tasks = mutableListOf<Task>()
    private val users = mutableListOf<User>()

    fun createProject(id: Int, name: String, deadline: LocalDate, status: ProjectStatus) {
        val newProject = Project(id, name, deadline, status)
        projects.add(newProject)
        println("Project '${newProject.name}' has been created with ID: ${newProject.id}.")
    }

    fun addTaskToProject(){

    }

    fun assignTask(){

    }

    fun updateTaskStatus(){

    }

    fun projectStatusTracking(){

    }

    fun createUser(id: Int, name: String, roleInput: String): User {
        val role = try {
            Roles.valueOf(roleInput)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid role: $roleInput. Must be one of ${Roles.values().joinToString()}")
        }

        return User(id, name, role)
    }



}