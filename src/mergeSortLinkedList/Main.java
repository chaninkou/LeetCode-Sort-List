package mergeSortLinkedList;

public class Main {
	public static void main(String[] args) {
		int[] input = {5,4,3,2,1,0};
		
		ListNode head = insertNode(input);
		
		System.out.println("Input: ");
		
		displayLinkedList(head);
		
		MergeTwoLinkedList solution = new MergeTwoLinkedList();
		
		ListNode sortedHead = solution.sortList(head);
		
		System.out.println("Solution: ");
		
		displayLinkedList(sortedHead);
	}
	
	private static void displayLinkedList(ListNode head) {
		ListNode current = head;

		while (current != null) {
			System.out.print(current.val + " -> ");

			if (current.next == null) {
				System.out.print("null");
			}

			current = current.next;
		}

		System.out.println(" ");
	}

	private static ListNode insertNode(int[] input) {
		ListNode dummyRoot = new ListNode(0);
		ListNode previous = dummyRoot;

		for (int item : input) {
			previous.next = new ListNode(item);
			previous = previous.next;
		}

		return dummyRoot.next;
	}
}
