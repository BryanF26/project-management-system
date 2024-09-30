package service

import enum.ProjectStatus
import enum.Roles
import enum.TaskPriority
import enum.TaskStatus
import entity.Project
import entity.Task
import entity.User
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ProjectManager{

    val projects = mutableListOf<Project>()
    val tasks = mutableListOf<Task>()
    val users = mutableListOf<User>()

    fun Init(){
        val user1 = User(1, "Bryan", Roles.Manager)
        val user2 = User(2, "Kenny", Roles.Developer)
        val user3 = User(3, "Tasya", Roles.Tester)
        users.add(user1)
        users.add(user2)
        users.add(user3)

        val task1 = Task(1,"Desc1", TaskPriority.High, null, TaskStatus.Completed, null)
        val task2 = Task(2,"Desc2", TaskPriority.Low, null, TaskStatus.Completed, null)
        val task3 = Task(3,"Desc3", TaskPriority.High, null, TaskStatus.Not_Started, null)
        val task4 = Task(4,"Desc4", TaskPriority.Medium, null, TaskStatus.Not_Started, null)
        val task5 = Task(5,"Desc5", TaskPriority.High, null, TaskStatus.Not_Started, null)
        tasks.add(task1)
        tasks.add(task2)
        tasks.add(task3)
        tasks.add(task4)
        tasks.add(task5)
    }

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
            println("==============================================================")
            println("entity.Project '${newProject.name}' has been created with ID: ${newProject.id}.")
            println("==============================================================")
        }
    }

    fun addTaskToProject(projectId: Int, taskIds: List<Int>){
        val project = projects.find {it.id == projectId}
        if(project != null) {
            for (taskId in taskIds) {
                val task = tasks.find { it.id == taskId }
                if (task != null) {
                    project.tasks.add(task)
                    println("==================================================================")
                    println("entity.Task with ID: '${taskId}' has been successfully added to entity.Project ID: ${projectId}.")
                    println("==================================================================")
                } else {
                    println("==================================================================")
                    println("Failed to add entity.Task with ID: '${taskId}' to entity.Project ID: ${projectId}.")
                    println("==================================================================")
                }
            }
        } else{
            println("==============================================================")
            println("There is no project with ID: '${projectId}'.")
            println("==============================================================")
        }
    }

    fun assignTask(taskId: Int, userId: Int){
        val task = tasks.find { it.id == taskId }
        if (task != null) {
            if(isExistingUser(userId)) {
                val user = users.find { it.id == userId }
                task.assignedTo = user
                println("==============================================================")
                println("entity.User '${user?.name}' has been assigned to task '${task.description}'.")
                println("==============================================================")
            } else {
                throw IllegalArgumentException("entity.User with ID $userId was not found.")
            }
        } else {
            println("==============================================================")
            println("entity.Task with ID $taskId not found.")
            println("==============================================================")
        }
    }

    fun updateTaskStatus(taskId: Int, newStatus: String) {
        val task = tasks.find { it.id == taskId }
        if (task != null) {
            if (isValidTaskStatus(newStatus)) {
                task.status = TaskStatus.valueOf(newStatus)
                println("==============================================================")
                println("entity.Task '${task.description}' status updated to '$newStatus'.")
                println("==============================================================")
            } else {
                throw IllegalArgumentException("Invalid status: $newStatus. Must be one of ${TaskStatus.values().joinToString()}.")
            }
        } else {
            println("==============================================================")
            println("entity.Task with ID $taskId not found.")
            println("==============================================================")
        }
    }

    fun projectStatusTracking(projectId: Int){
        val project = projects.find { it.id == projectId }
        if (project != null && project.tasks.all { it.status == TaskStatus.Completed }) {
            project.status = ProjectStatus.Completed
            println("==============================================================")
            println("entity.Project '${project.name}' has been marked as Completed.")
            println("==============================================================")
        } else{
            println("==============================================================")
            println("There is no project with ID: '${projectId}'.")
            println("==============================================================")
        }
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