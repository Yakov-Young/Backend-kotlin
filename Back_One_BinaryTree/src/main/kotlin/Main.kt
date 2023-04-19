fun main(args: Array<String>) {
/*
    Методы для работы с деревом:
    insertItem(Int) - вставка нового узла(если не дублируется).
    getAllItem() - Получение всех элементов.
    searchItem(Int) - Поиск элемента. Возвращает Boolean-значение: True в случае если значение найдено; False в случае если значение не обнаружено.
    removeItem(Int) - Удаление элемента. Возвращает Boolean-значение: True в случае если значение удалено; False в случае если значение не обнаружено.

    Строение дерева:
                                         5
                                         /\
                                        0  8
                                        |  |\
                                        4  7 10
                                        /  |  |\
                                       1   6  9 11
                                       |
                                       3
                                       /
                                      2
*/


    val binaryTree = BinaryTree()

    binaryTree.insertItem(5)
    binaryTree.insertItem(0)
    binaryTree.insertItem(8)
    binaryTree.insertItem(4)
    binaryTree.insertItem(1)
    binaryTree.insertItem(10)
    binaryTree.insertItem(7)
    binaryTree.insertItem(3)
    binaryTree.insertItem(11)
    binaryTree.insertItem(2)
    binaryTree.insertItem(6)
    binaryTree.insertItem(9)

    println(binaryTree.searchItem(3))
    println(binaryTree.searchItem(100))
    binaryTree.getAllItem()

    println(binaryTree.removeItem(2))
    binaryTree.getAllItem()

}