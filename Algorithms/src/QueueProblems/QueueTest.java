package QueueProblems;

public class QueueTest {

	public static <T> void printQueue(Queue<T> q) {
		Queue.queueNode<T> runner = q.front; 
		while(runner != null) {
			System.out.print(runner.data + " "); 
			runner = runner.next; 
		}
		System.out.println(); 
	}
	
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>(); 
		q.add(10);
		q.add(20); 
		q.add(15);
		q.peek(); 
		printQueue(q); 
		q.remove(); 
		printQueue(q); 
		q.remove(); 
		printQueue(q); 
		q.remove(); 
		printQueue(q); 
	}
}
