fun main() {

    print("Введите ваш номер телефона: ")
    val myNumberPhone : String = readln()

    var mobilePhone: MobilePhone = MobilePhone(myNumberPhone)
    do {
        println("\nСписок контактов:")
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

                if (mobilePhone.updateContact(oldContact, newContact)) {
                    println("Контакт успешно изменен")
                }
                else {
                    println("Контакт не найден")
                }
            }
            3 -> {
                print("Введите данные о контатке\n" +
                        "Имя: ")
                var name = readln()

                print("Номер: ")
                var numberPhone = readln()

                val contact = Contact(name,numberPhone)

                if (mobilePhone.removeContact(contact)) {
                    println("Контакт удален")
                }
                else {
                    println("Контакт не найден")
                }
            }
            4 -> {
                print("Введите данные о контатке\n" +
                        "Имя: ")
                var name = readln()

                print("Номер: ")
                var numberPhone = readln()

                val contact = Contact(name,numberPhone)

                val index = mobilePhone.findContact(contact)

                if (index != -1) {
                    println("Результат поиска: ${mobilePhone.Book[index]}")
                }
                else {
                    println("По вашему запросу ничего не найдено")
                }
            }
            5 -> {
                print("Введите данные о контатке\n" +
                        "Имя: ")
                val name = readln()

                val data = mobilePhone.queryContact(name)
                if (data == null) {
                    println("По вашему запросу ничего не найдено")
                }
                else {
                    println("Результат поиска: $data")
                }
            }
        }

    }while (key != 9)
}