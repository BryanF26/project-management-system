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
        if(selectedMenu == 1){
            println("Project Name: ")
            val name:String = scanner.nextLine()

            println("Project Deadline [YYYY-MM-DD]: ")
            val date:String = scanner.nextLine()

            pm.createProject(name, date)
        }
        if(selectedMenu == 2){
            println("Project Id: ")
            val project_id:Int = scanner.nextInt()

            val tasks_id = arrayListOf<Int>()
            do {
                println("Task Id [0 to exit]: ")
                var temp = scanner.nextInt()
                tasks_id.add(temp)
            } while (temp != 0)

            pm.addTaskToProject(project_id, tasks_id)
        }
        if(selectedMenu == 3){
            pm.assignTask()
        }
        if(selectedMenu == 4){
            pm.updateTaskStatus()
        }
        if(selectedMenu == 5){
            pm.projectStatusTracking()
        }
    }
}
