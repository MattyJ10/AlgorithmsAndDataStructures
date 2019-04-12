package linkedLists;

public class PartitionList {
	
	public static LinkedList partition(LinkedList n, int p) {
		
		LinkedList part = new LinkedList(); 
		
		Node runner = n.head; 
		while(runner != null) {
			if (runner.data >= p) {
				System.out.println("tail");
				part.addToTail(runner.data);
			} else {
				System.out.println("head");
				part.addToHead(runner.data);
			}
			runner = runner.next; 
		}
		part.printList();
		return part;
	}

	public static void main(String[] args) {
		Node head = new Node(3); 
		LinkedList list = new LinkedList(head);
		list.addToTail(5);
		list.addToTail(8);
		list.addToTail(5);
		list.addToTail(10);
		list.addToTail(2);
		list.addToTail(1);
		//list.printList();
		partition(list, 5);
		
	}

}
