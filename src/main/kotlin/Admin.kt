import java.util.*

class Admin(private val school: School) {
    private val scanner = Scanner(System.`in`)
    private val menus = Menus()
    fun addStudent() {
        println("Enter student name: ")
        val name: String = scanner.next()
        println("Enter student address: ")
        val address: String = scanner.next()
        println("Enter student grade: ")
        val grade: Int = scanner.nextInt()

        val student = Student(name, address, grade)
        school.getStudentList().add(student);
        message("Student", "Added")
    }

    fun addTeacher() {
        println("Enter teacher name: ")
        val name = scanner.next()
        println("Enter teacher address: ")
        val address = scanner.next()
        val teacher = Teacher(name, address)
        println("How many subject will he/she teach? ")
        val numberOfSubject = scanner.nextInt()
        var subject: String
        for (i in 1..numberOfSubject) {
            println("Subject $i")
            subject = scanner.next()
            teacher.getSubjectToTeach().add(subject)
        }
        school.getTeacherList().add(teacher);
        message("Teacher", "Added")
    }

    fun removeTeacher() {
        println("Enter teacher id: ")
        val id = scanner.nextInt()
        var teacherToRemove: Teacher? = null
        school.getTeacherList().forEach { teacher: Teacher ->
            if (teacher.getId() == id) {
                teacherToRemove = teacher
            }
        }
        if (teacherToRemove == null) {
            println("This id does not exist")
            return
        }
        school.getTeacherList().remove(teacherToRemove)
        message("Teacher", "Removed")
    }

    fun removeStudent() {
        println("Enter student id: ")
        val id = scanner.nextInt()
        var studentToRemove: Student? = null
        school.getStudentList().forEach { student: Student ->
            if (student.getId() == id) {
                studentToRemove = student
            }
        }
        if (studentToRemove == null) {
            println("This id does not exist")
            return
        }
        school.getStudentList().remove(studentToRemove)
        message("Student", "Removed")
    }

    fun getTeacherById(): Teacher? {
        println("Enter teacher id: ")
        val id = scanner.nextInt()
        var teacherToGet: Teacher? = null;
        school.getTeacherList().forEach { teacher: Teacher ->
            if (teacher.getId() == id) {
                teacherToGet = teacher
            }
        }
        if (teacherToGet == null) {
            println("This id does not exist")
        }
        return teacherToGet
    }

    fun getStudentById(): Student? {
        println("Enter student id: ")
        val id = scanner.nextInt()
        var studentToGet: Student? = null;
        school.getStudentList().forEach { student: Student ->
            if (student.getId() == id) {
                studentToGet = student
            }
        }
        if (studentToGet == null) {
            println("This id does not exist")
        }
        return studentToGet
    }

    fun editTeacher() {
        println("Enter employee id: ");
        val id = scanner.nextInt();
        var teacherToEdit: Teacher? = null;
        for (teacher: Teacher in school.getTeacherList()) {
            if (teacher.getId() == id) {
                teacherToEdit = teacher
            }
        }
        if (teacherToEdit == null) {
            println("This id does not exists");
        } else {
            println("Which info you want to edit");
            println("\t\t\t\t      ___________________________");
            println("\t\t\t\t     |   |                       |");
            println("\t\t\t\t     | 1 | Name                  |");
            println("\t\t\t\t     | 2 | Address               |");
            println("\t\t\t\t     | 3 | Subjects              |");
            println("\t\t\t\t     |___|_______________________|");

            println("Select from above: ");

            val option = scanner.nextInt();
            when (option) {
                1 -> {
                    println("Enter edited name: ");
                    val name = scanner.next();
                    teacherToEdit.setName(name);
                    message("Teacher", "Edited");
                }

                2 -> {
                    println("Enter edited address: ");
                    val address = scanner.next();
                    teacherToEdit.setAddress(address);
                    message("Teacher", "Edited");
                }

                3 -> {
                    menus.menuForSubjects();
                    val choice = scanner.nextInt();
                    if (choice == 1) {
                        println("Enter subject you want to add: ");
                        val subjectToBeAdded = scanner.next();
                        teacherToEdit.getSubjectToTeach().add(subjectToBeAdded);
                        message("Teacher", "Edited");
                    } else if (choice == 2) {
                        println(teacherToEdit.getSubjectToTeach());
                        println("Enter subject you want to remove: ");
                        val subjectToBeRemoved = scanner.next();
                        for (s: String in teacherToEdit.getSubjectToTeach()) {
                            if (s == subjectToBeRemoved) {
                                teacherToEdit.getSubjectToTeach().remove(subjectToBeRemoved);
                                message("Teacher", "Edited");
                                break;
                            }
                        }
                    } else if (choice == 3) {
                        println(teacherToEdit.getSubjectToTeach());
                        println("Select subject you want to remove: ");
                        val subjectToBeEdited = scanner.next();
                        println("Enter edited subject: ");
                        val editedSubject = scanner.next();
                        for (s: String in teacherToEdit.getSubjectToTeach()) {
                            if (s == subjectToBeEdited) {
                                teacherToEdit.getSubjectToTeach().remove(subjectToBeEdited);
                                teacherToEdit.getSubjectToTeach().add(editedSubject);
                                message("Teacher", "Edited");
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    fun editStudent() {
        println("Enter student id: ")
        val id = scanner.nextInt()
        var studentToEdit: Student? = null
        for (student in school.getStudentList()) {
            if (student.getId() == id) {
                studentToEdit = student
            }
        }
        if (studentToEdit == null) {
            println("This id does not exist")
        } else {
            println("Which info you want to edit")
            println("\t\t\t\t      ___________________________")
            println("\t\t\t\t     |   |                       |")
            println("\t\t\t\t     | 1 | Name                  |")
            println("\t\t\t\t     | 2 | Address               |")
            println("\t\t\t\t     | 3 | Grade                 |")
            println("\t\t\t\t     |___|_______________________|")
            println("Select from above: ")
            val option = scanner.nextInt()
            when (option) {
                1 -> {
                    println("Enter edited name: ")
                    val name = scanner.next()
                    studentToEdit.setName(name)
                    message("Student", "Edited")
                }

                2 -> {
                    println("Enter edited address: ")
                    val address = scanner.next()
                    studentToEdit.setAddress(address)
                    message("Student", "Edited")
                }

                3 -> {
                    println("Enter edited grade: ")
                    val grade = scanner.nextInt()
                    studentToEdit.setGrade(grade)
                    message("Student", "Edited")
                }

                else -> println("Please select form above options")
            }
        }
    }

    private fun message(person: String, task: String) {
        println(" ______________________________")
        println("|                              |")
        println("| $person Successfully $task  |")
        println("|______________________________|")
    }
}