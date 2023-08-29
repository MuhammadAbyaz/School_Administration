import java.util.*

val scanner = Scanner(System.`in`)
val menu = Menus()
fun main(args: Array<String>) {
    val name = "S.M. Public Academy"
    val address = "North Nazim-abad"
    val school = School(name, address)
    val admin = Admin(school)
    mainMenu(admin)
}

fun mainMenu(admin: Admin) {
    var option: Int = 0
    while (option != 3) {
        menu.mainMenu()
        try {
            option = scanner.nextInt();
            if (option < 1 || option > 3) {
                println("Invalid Input! Please Select from 1 - 3: ");
            }
            if (option == 1) {
                menuForTeacher(admin)
            } else if (option == 2) {
                menuForStudent(admin)
            }
        } catch (e: Exception) {
            println("Please enter a valid number");
            scanner.next()
        }
    }
}

fun menuForTeacher(admin: Admin) {
    menu.menuForTeacher()
    var option: Int = 0
    option = scanner.nextInt();
    if (option < 1 || option > 5) {
        println("Please Select from 1 - 5: ");
    } else if (option == 1) {
        admin.addTeacher();
    } else if (option == 2) {
        admin.removeTeacher();
    } else if (option == 3) {
        val teacher = admin.getTeacherById();
        teacher?.printTeacher();
    } else if (option == 4) {
        admin.editTeacher();
    }
}

fun menuForStudent(admin: Admin) {
    menu.menuForStudent()
    var option: Int = 0
    option = scanner.nextInt();
    if (option < 1 || option > 5) {
        println("Please Select from 1 - 5: ");
    } else if (option == 1) {
        admin.addStudent();
    } else if (option == 2) {
        admin.removeStudent();
        return
    } else if (option == 3) {
        val student = admin.getStudentById();
        student?.printStudent();
        return
    } else if (option == 4) {
        admin.editStudent();
        return
    }
}