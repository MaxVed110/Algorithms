package lesson3_lists;


/**
 * linkedList
 * двунаправленный
 */
public class List {
    NodeL head;
    NodeL tall;

    /**
     * добавить в конец
     */
    public void add(int value) {
        NodeL nodeL = new NodeL();
        nodeL.value = value;
        if (head == null) {
            head = nodeL;
        } else {
            tall.next = nodeL;
            nodeL.previous = tall;
            tall = nodeL;
        }
    }

    /**
     * добавить в начало (односвязанный)
     */
    // public void addFirst(int value){
    //     Node node = new Node();
    //     if (head!=null){
    //         node.next = head;
    //     }
    //     head = node;
    // }

    /**
     * добавить внутрь списка
     */
    public void add(int value, NodeL nodeL) {
        NodeL next = nodeL.next;
        NodeL newNodeL = new NodeL();
        newNodeL.value = value;
        nodeL.next = newNodeL;
        newNodeL.previous = nodeL;
        if (next == null) {
            tall = newNodeL;
        } else {
            next.previous = newNodeL;
            newNodeL.next = next;
        }
    }

    /**
     * поиск ноды
     */
    public NodeL find(int value) {
        NodeL currentNodeL = head;
        while (currentNodeL != null) {
            if (currentNodeL.value == value) {
                return currentNodeL;
            }
            currentNodeL = currentNodeL.next;
        }
        return null;
    }

    /**
     * удаление ноды
     */
    public void delete(NodeL nodeL) {
        NodeL previous = nodeL.previous;
        NodeL next = nodeL.next;
        if (previous == null) {
            next.previous = null;
            head = next;
        } else {
            if (next == null) {
                previous.next = null;
                tall = previous;
            } else {
                previous.next = next;
                next.previous = previous;
            }
        }
    }

    /**
     * разворот двунаправленного списка
     */
    public void revert() {
        NodeL currentNodeL = head;
        while (currentNodeL != null) {
            NodeL next = currentNodeL.next;
            NodeL previous = currentNodeL.previous;
            currentNodeL.next = previous;
            currentNodeL.previous = next;
            if (previous == null) {
                tall = currentNodeL;
            }
            if (next == null) {
                head = currentNodeL;
            }
            currentNodeL = next;
        }
    }

    /**
     * разворот односвязанный списка
     */
    // public void rev(){
    //     if (head!=null && head.next != null){
    //         Node temp = head;
    //         revertOne(head.next, head);
    //         temp.next = null;
    //     }
    // }

    // private void revertOne(Node currentNode, Node previousNode){
    //     if (currentNode.next==null){
    //         head = currentNode;
    //     } else {
    //         revertOne(currentNode.next, currentNode);
    //     }
    //     currentNode.next = previousNode;
    // }

    /**
     * поиск центральной ноды (односвязанный список)
     */
    // public Node middleFind() {
    //     int counter = 1;
    //     Node node = head;
    //     while (node.next != null) {
    //         counter++;
    //         node = node.next;
    //     }
    //     counter = counter / 2 + 1;
    //     node = head;
    //     for (int i = 0; i < counter - 1; i++) {
    //         node = node.next;
    //     }
    //     return node;
    // }

    public static class NodeL {
        int value;
        NodeL next;
        NodeL previous;
    }
}
