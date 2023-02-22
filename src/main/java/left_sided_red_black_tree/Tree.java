package left_sided_red_black_tree;

public class Tree {
    private Node root;

    public boolean add(int value) {
        if (root!=null){
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Node.Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.value = value;
            root.color = Node.Color.BLACK;
            return true;
        }
    }

    public boolean addNode(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.value = value;
                    node.leftChild.color = Node.Color.RED;
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.value = value;
                    node.rightChild.color = Node.Color.RED;
                    return true;
                }
            }
        }
    }

    public Node rebalance(Node node) {
        Node result = node;
        boolean progress = true;
        do {
            progress = false;
            if (node.rightChild != null && node.rightChild.color == Node.Color.RED &&
                    (node.leftChild == null || node.leftChild.color == Node.Color.BLACK)) {
                progress = true;
                result = leftTurn(result);
            }
            if (node.leftChild != null && node.leftChild.color == Node.Color.RED &&
                    node.leftChild.leftChild != null && node.leftChild.leftChild.color == Node.Color.RED) {
                progress = true;
                result = rightTurn(result);
            }
            if (node.leftChild != null && node.leftChild.color == Node.Color.RED &&
                    node.rightChild != null && node.rightChild.color == Node.Color.RED) {
                progress = true;
                swapColor(result);
            }
        }
        while (progress);
        return result;
    }

    public Node leftTurn(Node node) {
        Node rightChild = node.rightChild;
        Node between = node.rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = between;
        rightChild.color = node.color;
        node.color = Node.Color.RED;
        return rightChild;
    }

    public Node rightTurn(Node node) {
        Node leftChild = node.leftChild;
        Node between = node.leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = between;
        leftChild.color = node.color;
        node.color = Node.Color.RED;
        return leftChild;
    }

    public void swapColor(Node node) {
        node.rightChild.color = Node.Color.BLACK;
        node.leftChild.color = Node.Color.BLACK;
        node.color = Node.Color.RED;
    }
}
