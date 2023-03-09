fun main() {

    print("Введите ваш номер телефона: ")
    val myNumberPhone : String = readln()

    var mobilePhone: MobilePhone = MobilePhone(myNumberPhone)
    do {
        println("\nСписок контактов: ")
        mobilePhone.printContacts()

        println("  \nВыберите действие:\n" +
                "1. Добавить новый контакт;\n" +
                "2. Изменить контакт;\n" +
                "3. Удалить контакт;\n" +
                "4. Найти контакт(contact);\n" +
                "5. Найти контакт(name);\n" +
                "9. Завершить работу.")
        var key: Int = readln().toInt()

        when (key) {
            1 -> {
                print("Введите данные о контатке\n" +
                        "Имя: ")
                val name = readln()

                print("Номер: ")
                val numberPhone = readln()

                val contact = Contact(name,numberPhone)

                mobilePhone.addNewContact(contact)
            }
            2 -> {
                print("Введите данные о контатке\n" +
                        "Имя: ")
                var name = readln()

                print("Номер: ")
                var numberPhone = readln()

                val oldContact = Contact(name,numberPhone)

                print("Введите обновленные данные\n" +
                        "Имя: ")
                name = readln()

                print("Номер: ")
                numberPhone = readln()

                val newContact = Contact(name,numberPhone)

                mobilePhone.updateContact(oldContact, newContact)
            }
            3 -> {
                print("Введите данные о контатке\n" +
                        "Имя: ")
                var name = readln()

                print("Номер: ")
                var numberPhone = readln()

                val contact = Contact(name,numberPhone)

                mobilePhone.removeContact(contact)
            }
            4 -> {
                print("Введите данные о контатке\n" +
                        "Имя: ")
                var name = readln()

                print("Номер: ")
                var numberPhone = readln()

                val contact = Contact(name,numberPhone)

                mobilePhone.findContact(contact)
            }
            5 -> {
                print("Введите данные о контатке\n" +
                        "Имя: ")
                var name = readln()

                mobilePhone.queryContact(name)
            }
        }

    }while (key != 9)
}