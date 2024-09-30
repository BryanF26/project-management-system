import java.util.Scanner
import ProjectManager

fun menus(){
    println("**Project Management System**")
    println("1. Create Project")
    println("2. Add Task to Project")
    println("3. Assign Task")
    println("4. Update Task Status")
    println("5. Project Status Tracking")
    println(">> ")
}

fun main() {

    val pm = ProjectManager()
    pm.Init()
    val scanner = Scanner(System.`in`)
    var selectedMenu = 0

    while (selectedMenu != 6){
        menus()
        try {
            selectedMenu = scanner.nextInt()
            scanner.nextLine()
            when(selectedMenu){

                1 -> {
                    println("Project Name: ")
                    val name:String = scanner.nextLine()

                    println("Project Deadline [YYYY-MM-DD]: ")
                    val date:String = scanner.nextLine()

                    pm.createProject(name, date)
                }
                2 -> {
                    for (x in pm.projects){
                        println("ID: ${x.id} Name: ${x.name} Deadline: ${x.deadline} Status: ${x.status}")
                        println("Task: ")
                        for (y in x.tasks){
                            println("ID: ${y.id} Description: ${y.description} Priority: ${y.priority} AssignedTo: ${y.assignedTo?.name} Status: ${y.status} DueDate: ${y.dueDate}")
                        }
                        if(x.tasks.isEmpty()){
                            println("There is no task")
                        }
                    }
                    println("Project Id: ")
                    val projectId:Int = scanner.nextInt()

                    val tasksId = arrayListOf<Int>()
                    do {
                        for (x in pm.tasks){
                            println("ID: ${x.id} Description: ${x.description} Prioritx: ${x.priority} AssignedTo: ${x.assignedTo?.name} Status: ${x.status} DueDate: ${x.dueDate}")
                        }
                        println("Task Id [0 to exit]: ")
                        val temp = scanner.nextInt()
                        if(temp == 0) break
                        tasksId.add(temp)
                    } while (true)

                    pm.addTaskToProject(projectId, tasksId)
                }
                3 -> {
                    for (x in pm.tasks){
                        println("ID: ${x.id} Description: ${x.description} Prioritx: ${x.priority} AssignedTo: ${x.assignedTo?.name} Status: ${x.status} DueDate: ${x.dueDate}")
                    }
                    println("Task Id: ")
                    val taskId: Int = scanner.nextInt()
                    for (x in pm.users){
                        println("ID: ${x.id} Name: ${x.name} Role: ${x.role}")
                    }
                    println("User Id: ")
                    val userId: Int = scanner.nextInt()
                    pm.assignTask(taskId, userId)
                }
                4 -> {
                    for (x in pm.tasks){
                        println("ID: ${x.id} Description: ${x.description} Prioritx: ${x.priority} AssignedTo: ${x.assignedTo?.name} Status: ${x.status} DueDate: ${x.dueDate}")
                    }
                    println("Task Id: ")
                    val taskId: Int = scanner.nextInt()
                    scanner.nextLine()
                    println("Update Status [Not_Started | In_Progress | Completed]: ")
                    val newStatus: String = scanner.nextLine()
                    pm.updateTaskStatus(taskId, newStatus)
                }
                5 -> {
                    for (x in pm.projects){
                        println("ID: ${x.id} Name: ${x.name} Deadline: ${x.deadline} Status: ${x.status}")
                        println("Task:")
                        for (y in x.tasks){
                            println("ID: ${y.id} Description: ${y.description} Priority: ${y.priority} AssignedTo: ${y.assignedTo?.name} Status: ${y.status} DueDate: ${y.dueDate}")
                        }
                        if(x.tasks.isEmpty()){
                            println("There is no task")
                        }
                    }
                    println("Project Id: ")
                    val projectId: Int = scanner.nextInt()

                    pm.projectStatusTracking(projectId)
                }
                6 -> {
                    println("Exiting...")
                }
                else -> {
                    println("Invalid option. Please select a valid menu.")
                }
            }
        } catch (e: NumberFormatException) {
            scanner.nextLine()
            println("Error: Invalid number format. Please enter a valid integer.")
        } catch (e: Exception) {
            scanner.nextLine()
            println("Error: ${e.message}")
        }
    }
}
