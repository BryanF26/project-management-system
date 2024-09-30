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
}