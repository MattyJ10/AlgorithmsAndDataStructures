package linkedLists;

public class LinkedList {
	Node head = null; 
	Node tail = null; 
	
	public LinkedList() {}
	
	public LinkedList(Node n) {
		this.head = n; 
		this.tail = n; 
	}
	
	public void addToTail(int n) {
		Node end = new Node(n); 
		this.tail.next = end; 
		this.tail = end; 
	}
	
	public void addToHead(int n) {
		Node add = new Node(n); 
		add.next = this.head;
		this.head = add; 
	}
	
	public void printList() {
		Node runner = new Node(); 
		runner = this.head; 
		System.out.println("data: ");
		while(runner != null) {
			System.out.print(runner.data + ", ");
			runner = runner.next;
		}
	}
}
