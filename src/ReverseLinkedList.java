public class ReverseLinkedList {
    public static LNode reverseList(LNode head) {
        LNode prev = null;
        LNode current = head;

        while (current != null) {
            LNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev; // prev points to the new head of the reversed list
    }

    public static void printList(LNode head) {
        LNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create the original linked list: 1 -> 2 -> 3 -> 4 -> 5
        LNode head = new LNode(1);
        head.next = new LNode(2);
        head.next.next = new LNode(3);
        head.next.next.next = new LNode(4);
        head.next.next.next.next = new LNode(5);

        System.out.println("Original Linked List:");
        printList(head);

        // Reverse the linked list
        head = reverseList(head);

        System.out.println("Reversed Linked List:");
        printList(head);
    }
}
