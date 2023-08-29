class School(private var name: String, private var address: String) {
    private var teacherList = ArrayList<Teacher>()
    private var studentList = ArrayList<Student>()


    fun getStudentList(): ArrayList<Student> {
        return studentList
    }

    fun getTeacherList(): ArrayList<Teacher> {
        return teacherList
    }

    fun getName(): String {
        return name
    }

    fun getAddress(): String {
        return address
    }
}