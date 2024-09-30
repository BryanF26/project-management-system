class ProjectManager{

    private val projects = mutableListOf<Project>()
    private val tasks = mutableListOf<Task>()
    private val users = mutableListOf<User>()

    fun CreateProject(id: Int, name: String, deadline: LocalDate, status: ProjectStatus) {
        val newProject = Project(id, name, deadline, status)
        projects.add(newProject)
        println("Project '${newProject.name}' has been created with ID: ${newProject.id}.")
    }

    fun AddTaskToProject(){

    }

    fun AssignTask(){

    }

    fun UpdateTaskStatus(){

    }

    fun ProjectStatusTrakcing(){

    }

    fun CreateUser(id: Int, name: String, roleInput: String): User {
        val role = try {
            Roles.valueOf(roleInput)  // This will throw an IllegalArgumentException if roleInput is invalid
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid role: $roleInput. Must be one of ${Roles.values().joinToString()}")
        }

        return User(id, name, role)
    }

}