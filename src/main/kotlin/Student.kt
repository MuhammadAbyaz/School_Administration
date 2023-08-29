class Student(private var _name: String, private var _address: String, private var _grade: Int) {
    private var id: Int

    init {
        id = generateId()
    }

    private var _id: Int = 0
    private fun generateId(): Int {
        return _id++
    }

    fun printStudent() {
        println("Id     : $id")
        println("Name   : $_name")
        println("Address: $_address")
        println("Grade  : $_grade")
    }

    fun getId(): Int {
        return id
    }

    fun setName(name: String) {
        _name = name
    }

    fun setAddress(address: String) {
        _address = address
    }

    fun setGrade(grade: Int) {
        _grade = grade
    }
}