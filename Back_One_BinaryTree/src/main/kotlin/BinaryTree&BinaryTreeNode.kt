class BinaryTreeNode(data: Int) {
    var data: Int
    var left: BinaryTreeNode? = null
    var right: BinaryTreeNode? = null

    init {
        this.data = data
    }
}

class BinaryTree() {
    private var node: BinaryTreeNode? = null

    fun InsertItem(newItem: Int) {

        var newNode = BinaryTreeNode(newItem)

        if (this.node == null) {
            this.node = newNode
            return
        }
        this.InsertNextStep(node!!, newNode)
    }

    fun SearchItem(item: Int) : Boolean {
        return SearchNextStep(node!!, item)
    }

    fun RemoveItem(item: Int) : Boolean {
        return RemoveNextStep(node!!, item)
    }

    private fun InsertNextStep(node: BinaryTreeNode, newItem: BinaryTreeNode) {

        if (node.data > newItem.data) {
            if (node.left == null) {
                node.left = newItem
            } else {
                this.InsertNextStep(node.left!!, newItem)
            }
        } else if (node.data < newItem.data) {

            if (node.right == null) {
                node.right = newItem
            } else {
                this.InsertNextStep(node.right!!, newItem)
            }
        } else {
            return println("Error: duplicate numbers.")
        }
    }

    private fun SearchNextStep(node: BinaryTreeNode?, item: Int) : Boolean {
        if (node == null)
            return false
        else if (node.data == item)
            return true

        if (node.data > item)
            return SearchNextStep(node.left, item)
        if (node.data < item)
            return SearchNextStep(node.right, item)
        return false
    }

    fun RemoveNextStep(node: BinaryTreeNode?, item: Int) : Boolean {
        if (node == null)
            return false
        else if (node.data == item) {
            if (node.left == null && node.right == null) {
                this.node = null
            }
            else if (node.left != null && node.right != null){
                this.node = node.right
            }
            else {
                if (node.left != null)
                    this.node = node.left
                if (node.right != null)
                    this.node = node.right
            }
            return true
        }

        if (node.data > item)
            return SearchNextStep(node.left, item)
        if (node.data < item)
            return SearchNextStep(node.right, item)
        return false
    }
}
