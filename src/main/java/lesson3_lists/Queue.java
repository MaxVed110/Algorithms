package lesson3_lists;

public class Queue {
    Node head;
    Node tall;

    public void push(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }

    public Integer peek(){
        Integer result = null;
        if(tall!=null){
            result = tall.value;
            tall.previous.next = null;
            tall = tall.previous;
        }
        return result;
    }

    public static class Node {
        int value;
        Node next;
        Node previous;
    }
}
