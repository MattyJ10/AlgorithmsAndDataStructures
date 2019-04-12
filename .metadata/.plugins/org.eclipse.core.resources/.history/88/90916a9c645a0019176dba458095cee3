package stackProblems;

public class StackTest {
	
	public static void printArrStack(ArrayStack stk) {
		for (int i = 0; i < stk.count; i++) {
			System.out.print(stk.data[i]);
		}
		System.out.println(); 
	}
	
	public static <Item> void printListStack(LinkedListStack.stackNode<Item> top) {
		LinkedListStack.stackNode<Item> runner = top; 
		while(runner != null) {
			System.out.print(runner.data);
			runner = runner.next; 
		}
		System.out.println(); 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack arrStack = new ArrayStack(); 
		arrStack.push(5);
		arrStack.push(11); 
		printArrStack(arrStack);
		arrStack.peek(); 
		arrStack.pop(); 
		printArrStack(arrStack);
		System.out.println(); 
		LinkedListStack<Integer> lStack = new LinkedListStack<Integer>(); 
		lStack.push(5);
		lStack.push(11);
		printListStack(lStack.top); 
		lStack.peek(); 
		lStack.pop(); 
		printListStack(lStack.top);
	}

}
