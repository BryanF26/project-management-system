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

    fun AddTaskToProject(projectId: Int, taskIds: Array<Int>){
        val project = projects.find {it.id == projectId}
        if(project != null) {
            for (taskId in taskIds) {
                val task = tasks.find { it.id == taskId }
                if (task != null) {
                    project.tasks.add(task)
                    println("Task with ID: '${taskId}' has been successfully added to Project ID: ${projectId}.")
                } else {
                    println("Failed to add Task with ID: '${taskId}' to Project ID: ${projectId}.")
                }
            }
        }
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