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
    val user1 = User(1, "Bryan", Roles.Manager)
    val user2 = User(2, "Kenny", Roles.Developer)
    val user3 = User(3, "Tasya", Roles.Tester)

    val pm = ProjectManager()
    val scanner = Scanner(System.`in`)
    var selectedMenu = 0

    while (selectedMenu != 6){
        menus()
        selectedMenu = scanner.nextInt()
        scanner.nextLine()
        if(selectedMenu == 1){
            println("Project Name: ")
            val name:String = scanner.nextLine()

            if (name.isEmpty()) {
                println("Project name must not be empty.")
                continue
            }

            println("Project Deadline [YYYY-MM-DD]: ")
            val date:String = scanner.nextLine()

            if (date.isEmpty()) {
                println("Project date must not be empty.")
                continue
            }
            pm.createProject(name, date)
        }
        if(selectedMenu == 2){
            println("Project Id: ")
            val projectId:Int = scanner.nextInt()

            val tasksId = arrayListOf<Int>()
            do {
                println("Task Id [0 to exit]: ")
                val temp = scanner.nextInt()
                tasksId.add(temp)
            } while (temp != 0)

            pm.addTaskToProject(projectId, tasksId)
        }
        if(selectedMenu == 3){
            println("Task Id: ")
            val taskId: Int = scanner.nextInt()
            println("User Id: ")
            val userId: Int = scanner.nextInt()
            pm.assignTask(taskId, userId)
        }
        if(selectedMenu == 4){
            println("Task Id: ")
            val taskId: Int = scanner.nextInt()
            println("Update Status: ")
            val newStatus: String = scanner.nextLine()
            pm.updateTaskStatus(taskId, newStatus)
        }
        if (selectedMenu == 5) {
            println("Project Id: ")
            val projectId: Int = scanner.nextInt()

            val taskIds = arrayListOf<Int>()
            do {
                println("Task Id [0 to exit]: ")
                val temp = scanner.nextInt()
                if (temp != 0) {
                    taskIds.add(temp)
                }
            } while (temp != 0)

            pm.projectStatusTracking(projectId, taskIds)
        }

    }
}
