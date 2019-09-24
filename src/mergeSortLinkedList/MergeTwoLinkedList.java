package mergeSortLinkedList;

public class MergeTwoLinkedList {
    public ListNode sortList(ListNode head) {
        // base case: If its empty Linked list or One item linked List
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode mid = findMidPoint(head);
        
        ListNode leftSide = sortList(head);
        
        ListNode rightSide = sortList(mid);
        
        return mergeTwoLinkedList(leftSide, rightSide);
    }
    
    private ListNode findMidPoint(ListNode head){
        // Slowpointer will move one node at a time
        ListNode slowPointer = head;
        
        // FasterPointer will move two node at a time
        ListNode fastPointer = head;
        
        // Just keeping track of the head
        ListNode previous = null;
        
        // fastpointer will either be null if its even or the fastpointer.next will be null if its odd
        while(fastPointer != null && fastPointer.next != null){
            previous = slowPointer;
            
            slowPointer = slowPointer.next;
            
            fastPointer = fastPointer.next.next;
        }
        
        // We need to end the linked List in order to have another list for the original head
        previous.next = null;
        
        // Mid point will be the start of the second Linked List which is slowPointer
        return slowPointer;
    }
    
    // After spliting the list, now we will merge them in a sorted list
    private ListNode mergeTwoLinkedList(ListNode l1, ListNode l2){
        // Dummy.next will be the final sorted list
        ListNode dummy = new ListNode(0);
        
        ListNode end = dummy;
        
        // When they are both not null
        while(l1 != null && l2 != null){
            // If l2 > l1, then first node should be l1
            if(l1.val < l2.val){
                // Update the next node
                end.next = l1;
                
                // Move on to the next node
                l1 = l1.next;
            } else { // Else, we know l2 is smaller or equal to l1
                // Update the next node
                end.next = l2;
                
                // Move on to the next node
                l2 = l2.next;
            }
            
            // Update the end pointer
            end = end.next;
        }
        
        // One list will for sure be left with one last node
        if(l1 != null){
            end.next = l1;
        }
        if(l2 != null){
            end.next = l2;
        }
        
        // return the sorted list
        return dummy.next;
    }
}
