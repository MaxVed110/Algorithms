package s_three_connected_list;

public class LinkList {
    Node head;
    Node tail;

    public void add(int value) {
        Node addNode = new Node();
        addNode.value = value;
        if (head == null) {
            head = addNode;
        } else {
            tail.next = addNode;
            addNode.previous = tail;
        }
        tail = addNode;
    }

    public void addFirst(int value){
        Node node = new Node();
        node.value = value;
        if (head!=null){
            node.next = head;
        }
        head = node;
    }

    /**
     * разворот двусвязанного списка
     */
    public void reverseV2() {
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            Node previous = curr.previous;
            curr.next = previous;
            curr.previous = next;
            if (previous == null) {
                tail = curr;
            }
            if (next == null) {
                head = curr;
            }
            curr = next;
        }
    }

    /**
     * разворот односвязанного списка
     */
    public void reverseV1() {
        if (head != null && head.next != null) {
            Node temp = head;
            swap(head.next, head);
            temp.next = null;
        }
    }

    private void swap(Node currNode, Node previousNode) {
        if (currNode.next == null) {
            head = currNode;
        } else {
            swap(currNode.next, currNode);
        }
        currNode.next = previousNode;
    }
}

