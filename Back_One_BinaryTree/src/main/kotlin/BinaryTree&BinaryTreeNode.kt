class BinaryTreeNode(value: Int) {
    var value: Int
    var left: BinaryTreeNode? = null
    var right: BinaryTreeNode? = null

    init {
        this.value = value
    }
}

class BinaryTree {
    private var node: BinaryTreeNode? = null

    fun insertItem(value: Int) {

        val newNode = BinaryTreeNode(value)

        if (this.node == null) {
            this.node = newNode
            return
        }
        this.insertItemRecursion(this.node!!, newNode)
    }

    fun searchItem(searchedValue: Int) : Boolean {
        return searchItemRecursion(this.node, searchedValue)
    }

    fun removeItem(deletedValue: Int) : Boolean {
        return removeItemRecursion(this.node, deletedValue)
    }

    fun getAllItem() {
        try {
            if (this.node == null)
                throw Exception("Дерево не содержит значений")
            else {
                return getAllItemRecursion(node!!)
            }
        } catch (e: Exception) {
            println(e)
            return
        }
    }

    private fun getAllItemRecursion(node: BinaryTreeNode) {

        print(node.value)
        print(' ')
        if (node.left != null)
            this.getAllItemRecursion(node.left!!)
        if (node.right != null)
            this.getAllItemRecursion(node.right!!)
    }

    private fun insertItemRecursion(node: BinaryTreeNode, newItem: BinaryTreeNode) {

        try {
            if (node.value > newItem.value) {
                if (node.left == null) {
                    node.left = newItem
                } else {
                    this.insertItemRecursion(node.left!!, newItem)
                }
            } else if (node.value < newItem.value) {

                if (node.right == null) {
                    node.right = newItem
                } else {
                    this.insertItemRecursion(node.right!!, newItem)
                }
            } else {
                throw Exception("Error: duplicate numbers.")
            }
        } catch (e: Exception) {
            println(e)
            return
        }
    }

    private fun searchItemRecursion(node: BinaryTreeNode?, searchedValue: Int) : Boolean {
        if (node == null)
            return false
        else if (node.value == searchedValue)
            return true

        if (node.value > searchedValue)
            return searchItemRecursion(node.left, searchedValue)
        if (node.value < searchedValue)
            return searchItemRecursion(node.right, searchedValue)
        return false
    }

    private fun removeItemRecursion(node: BinaryTreeNode?, deletedValue: Int) : Boolean {
        var parent: BinaryTreeNode? = null
        var node: BinaryTreeNode? = node

        while (node != null && node.value != deletedValue) {
            parent = node

            node = if (node.value > deletedValue)
                node.left
            else
                node.right
        }

        if (node == null)
            return false
        else if (node.value == deletedValue) {
            if (node.left == null && node.right == null) {  // Case1: у узла нет потомков

                if (parent != null) {
                    if (parent.left == node) {
                        parent.left = null
                    } else {
                        parent.right = null
                    }
                } else {
                    this.node = null
                }
            }
            else if (node.left != null && node.right != null) {  // Case2: у узла два потомка
                val tmp = this.gettingGreatestValueRecursion(node.left!!)

                val value = tmp.value

                this.removeItemRecursion(this.node, value)
                node.value = value
            }
            else {                                               // Case3: у узла один потомок
                val child: BinaryTreeNode = if (node.right != null)
                    node.right!!
                else
                    node.left!!

                if (parent != null) {
                    if (parent.left == node) {
                        parent.left = child
                    } else {
                        parent.right = child
                    }
                } else {
                    this.node = child
                }
            }

            return true
        }

        return false
    }

    private fun gettingGreatestValueRecursion(node: BinaryTreeNode): BinaryTreeNode {
        return if (node.right != null) {
            gettingGreatestValueRecursion(node.right!!)
        } else {
            node
        }
    }
}
