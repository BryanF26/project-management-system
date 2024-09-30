import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ProjectManager{

    private val projects = mutableListOf<Project>()
    private val tasks = mutableListOf<Task>()
    private val users = mutableListOf<User>()

    fun createProject(name: String, inputtedDeadline: String) {
        val deadline: LocalDate?  =  try {
            LocalDate.parse(inputtedDeadline, DateTimeFormatter.ISO_LOCAL_DATE)
        } catch (e: Exception) {
            println("Invalid date format. Please enter a date in the format yyyy-mm-dd.")
            null
        }
        if(deadline != null) {
            val newProject = Project(projects.size+1, name, deadline, ProjectStatus.Active)
            projects.add(newProject)
            println("Project '${newProject.name}' has been created with ID: ${newProject.id}.")
        }
    }

    fun addTaskToProject(projectId: Int, taskIds: Array<Int>){
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