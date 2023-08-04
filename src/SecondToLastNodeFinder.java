class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SecondToLastNodeFinder {
    public static Node findSecondToLast(Node head) {
        if (head == null || head.next == null) {
            return null; // List has less than two nodes, so there's no second-to-last node
        }

        // Initialize two pointers
        Node prev = head;
        Node current = head.next;

        // Traverse the linked list until current.next is null
        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        // At this point, prev will be pointing to the second-to-last node
        return prev;
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Find the second-to-last node
        Node secondToLast = findSecondToLast(head);

        // Output the value of the second-to-last node
        if (secondToLast != null) {
            System.out.println("Value of the second-to-last node: " + secondToLast.data);
        } else {
            System.out.println("The second-to-last node doesn't exist.");
        }
    }
}

