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

    fun addTaskToProject(projectId: Int, taskIds: List<Int>){
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

    fun assignTask(taskId: Int, userId: Int){
        val task = tasks.find { it.id == taskId }
        val user = users.find { it.id == userId }
        if (task != null) {
            if(!isExistingUser(userId)) {
                throw IllegalArgumentException("User was not found.")
            } else {
                task.assignedTo = user
                println("User '${user?.name}' has been assigned to task '${task?.description}'.")
            }
        } else {
            println("Task with ID $taskId not found.")
        }
    }

    fun updateTaskStatus(taskId: Int, newStatus: String){
        val task = tasks.find { it.id == taskId }
        if (task != null) {
            if(!isValidTaskStatus(newStatus)) {
                throw IllegalArgumentException("Invalid status: $newStatus. Must be one of ${TaskStatus.values().joinToString()}")
            }
            task.status = TaskStatus.valueOf(newStatus)
            println("Task '${task.description}' status updated to '$newStatus'.")
        } else {
            println("Task with ID $taskId not found.")
        }
    }

    fun projectStatusTracking(){

    }

    fun isExistingUser(userId: Int): Boolean {
        return users.any { it.id == userId }
    }

    fun isValidTaskStatus(status: String): Boolean {
        return try {
            TaskStatus.valueOf(status)
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }

}