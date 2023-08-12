package hw4;

public class Stack implements List {
    // Implement Stack using Linked List without tail
    // FIFO
    Node head;

    // like push front
    public void push(Node node) {
        if (head == null) {
            // Do something
            head = node;

        } else {
            // Do something else
            node.next = head;
            head = node;
        }
    }

    // like pop front
    public void pop() {
        // Fix this function
        if (head != null) {
            // Do something
            head = head.next;
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
