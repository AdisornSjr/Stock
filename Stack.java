package hw4;

public class Stack implements List {
    // Implement Stack using Linked List without tail
    // FIFO
    Node head;

    // like push front
    public void push(Node node) {
        if (head == null) {
            // Do something
            head = node; // add ได้เลย

        } else {
            // Do something else
            node.next = head; // ชี้ที่เดียวกับ head
            head = node; // move head to node
        }
    }

    // like pop front
    public void pop() {
        // Fix this function
        if (head != null) {
            // Do something
            head = head.next; // move head to next node and that node will be delete auto eiei
        } else {
            System.out.println("Error: Stack Underflow");
        }
    }

    // top คือหน้าสุดของ linked list (head)
    public Node top() {
        // add condition
        if (head == null) {
            return null;
        } else {
            return head; // จะถือว่าแก้ code ไหม?
            // new Node(head.shares, head.price);
        }

    }

}
