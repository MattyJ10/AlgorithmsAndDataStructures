package heap;

public class HeapMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxHeap myHeap = new MaxHeap(10); 
		myHeap.insert(7);
		myHeap.insert(3);
		myHeap.insert(4);
		myHeap.insert(10);
		myHeap.printHeap();
		myHeap.deleteValue(10);
		myHeap.printHeap();
		myHeap.extractMax(); 
		myHeap.printHeap(); 
		myHeap.insert(100);
		myHeap.printHeap();
		
	}

}
