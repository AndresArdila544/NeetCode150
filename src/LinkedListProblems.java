import java.util.*;

public class LinkedListProblems {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}

    }

    public static void main(String[] args) {

        LinkedListProblems llp = new LinkedListProblems();

        //Reverse Linked List
        ListNode head = llp.new ListNode(1);
        head.next = llp.new ListNode(2);
        head.next.next = llp.new ListNode(4);
        head.next.next.next = llp.new ListNode(3);
        //llp.print(llp.reverseList(head));

        //Merge Two Sorted Linked Lists
        ListNode head2 = llp.new ListNode(1);
        head2.next = llp.new ListNode(3);
        head2.next.next = llp.new ListNode(5);
        //llp.print(llp.mergeTwoLists(head, head2));

        ListNode head3 = llp.new ListNode(1);
        head3.next = llp.new ListNode(2);
        head3.next.next = llp.new ListNode(3);
        head3.next.next.next = llp.new ListNode(4);
        head3.next.next.next.next = llp.new ListNode(5);
        head3.next.next.next.next.next = llp.new ListNode(6);
        //head3.next.next.next.next.next.next = llp.new ListNode(7);
        llp.reorderList(head3);
        llp.print(head3);


    }

    public void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    //Reverse Linked List
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;

    }

    //Merge Two Sorted Linked Lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode head;
        if(list1.val<list2.val){
            head = list1;
            list1 = list1.next;
        }else {
            head = list2;
            list2 = list2.next;
        }
        ListNode curr = head;

        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1!=null){
            curr.next = list1;
        }
        if(list2!=null){
            curr.next = list2;
        }
        return head;

    }

    //Linked List Cycle
    public boolean hasCycle(ListNode head) {

        Set<ListNode> visited = new HashSet<>();

        ListNode curr = head;
        while (curr != null) {
            if (visited.contains(curr)) {
                return true;
            }else{
                visited.add(curr);
            }
            curr = curr.next;
        }
        return false;

    }

    //Reorder Linked List
    public void reorderList(ListNode head) {
        if(head == null) return;
        if(head.next == null) return;
        Stack<ListNode> st = new Stack();

        ListNode a = head;
        while (a != null) {
            st.push(a);
            a = a.next;
        }
        ListNode curr = head;
        int mid = (st.size())/2;

        for (int i = 0; i < mid; i++) {
            ListNode temp = curr.next;

            curr.next = st.pop();
            curr.next.next = temp;

            curr = temp;

        }
        curr.next = null;
    }



}
