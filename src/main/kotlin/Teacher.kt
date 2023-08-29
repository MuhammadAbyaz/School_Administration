class Teacher(private var _name: String, private var _address: String) {
    private val id: Int
    private var _id: Int = 0
    private var subjectToTeach: ArrayList<String>

    init {
        id = generateId()
        subjectToTeach = ArrayList()
    }

    private fun generateId(): Int {
        return _id++
    }

    fun printTeacher() {
        println("Id       : $id")
        println("Name     : $_name")
        println("Address  : $_address")
        println("Subjects : $subjectToTeach")
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

    fun getSubjectToTeach(): ArrayList<String> {
        return subjectToTeach
    }
}