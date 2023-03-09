class MobilePhone(number: String, ) {
    var myNumber: String = ""
    var Book: ArrayList<Contact> = arrayListOf()

    init{
        this.myNumber = number
        this.Book.add(Contact("Я", number))
    }

    fun addNewContact(contact: Contact) : Boolean {
        if (findContact(contact) == -1) {
            Book.add(contact)
            return true
        }
        else {
            return false
        }
    }

    fun updateContact(oldContact: Contact, newContact: Contact) : Boolean {
        if (findContact(oldContact) != -1) {
            Book.set(Book.indexOf(oldContact), newContact)
            return true
        }
        else {
            return false
        }
    }

    fun removeContact(contact: Contact) : Boolean {
        if (findContact(contact) != -1) {
            Book.remove(contact)
            return true
        }
        else {
            return false
        }
    }

    fun findContact(contact: Contact) : Int {
        return Book.indexOf(contact)
    }

    fun queryContact(text: String) : Contact? {
        Book.forEach{
            if (it.name.indexOf(text) != -1) {
                println(it)
                return it
            }
        }
        return null
    }

    public fun printContacts(){
        var iterator = Book.iterator()
        while (iterator.hasNext()) {
            println(iterator.next().toString())
        }
    }
}

data class Contact(
    var name: String = "Undefined",
    var number: String = ""
)