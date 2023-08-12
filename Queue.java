package hw4;

public class Queue implements List {
    // Implement Queue using Linked List with tail
    // LIFO
    Node head;
    Node tail;

    // push from back
    public void push(Node node) {
        if (head == null) {
            // Do something (Empty list)
            // set head and tail to node
            head = node;
            tail = node;
        } else {
            // Do something (Non-empty list)
            tail.next = node; // ให้ tail ขยับไปตัวต่อไป
            tail = node; // set tail to last
        }
    }

    // pop form front
    public void pop() {
        if (head != null) { // at lest have 1 element
            if (head != tail) {
                // Do something (List of many nodes)
                head = head.next; // ขยับ head ไปตัวถัดไป ตัวแรกก็จะถูกลบไปเอง
            } else {
                // Do something (List of a single node)
                head = null;
                tail = null;
            }
        } else {
            System.out.println("Error: Queue Underflow");
        }
    }

    // top is mean head of queue
    public Node top() {
        // Fix this
        if (head == null) {
            return null;
        } else {
            return head; // จะถือว่าแก้ code จารไหม?
            // new Node(head.shares, head.price);
        }

    }

}
