fun main(args: Array<String>) {

    var binaryTree = BinaryTree()

    binaryTree.InsertItem(1)
    binaryTree.InsertItem(2)
    binaryTree.InsertItem(4)
    binaryTree.InsertItem(3)
    binaryTree.InsertItem(5)
    binaryTree.InsertItem(0)
    println(binaryTree.SearchItem(3))

}