class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListConcatenation {

    public static ListNode concatenateLists(ListNode L, ListNode M) {
        if (L == null) {
            return M;
        }

        if (M == null) {
            return L;
        }

        ListNode lastNodeL = L;
        while (lastNodeL.next != null) {
            lastNodeL = lastNodeL.next;
        }

        lastNodeL.next = M;
        return L;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample linked lists L and M
        ListNode L = new ListNode(1);
        L.next = new ListNode(2);
        L.next.next = new ListNode(3);

        ListNode M = new ListNode(4);
        M.next = new ListNode(5);
        M.next.next = new ListNode(6);

        System.out.println("List L:");
        printList(L);

        System.out.println("List M:");
        printList(M);

        ListNode concatenatedList = concatenateLists(L, M);

        System.out.println("Concatenated List:");
        printList(concatenatedList);
    }
}
