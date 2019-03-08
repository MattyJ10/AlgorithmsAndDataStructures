package heap;

public class MaxHeap {
	
	public int[] heapData; 
	public int size; 
	
	MaxHeap(int size) {
		this.heapData = new int[size]; 
		this.size = 0; 
	}
	
	public int get() {
		if (size == 0) {
			return -1; 
		} else {
			return heapData[0]; 
		}
	}
	
	public int extractMax() {
		if (size == 0) {
			return -1; 
		} else if (size == 1) {
			size--; 
			return heapData[0]; 
		}
		//replace with last value
		int ret = heapData[0];
		heapData[0] = heapData[size - 1];
		size = size - 1; 
		heapify(0); 
		return ret; 
	}
	
	public void insert(int value) {
		if (size != heapData.length) {
			heapData[size] = value; 
			size++; 
			int i = size - 1; 
			while (heapData[i] > heapData[getParent(i)]) {
				int temp = heapData[getParent(i)]; 
				heapData[getParent(i)] = heapData[i]; 
				heapData[i] = temp; 
				i = getParent(i); 
			}
		}
	}
	
	public void deleteValue(int value) {
		//find value
		int foundIndex = -1; 
		for (int i = 0; i < size; i++) {
			if (heapData[i] == value) {
				foundIndex = i; 
				break; 
			}
		}
		if (foundIndex == -1) {
			return; 
		} else {
			heapData[foundIndex] = Integer.MAX_VALUE; 
			while(foundIndex != 0 && heapData[foundIndex] > heapData[getParent(foundIndex)]) {
				int temp = heapData[getParent(foundIndex)]; 
				heapData[getParent(foundIndex)] = heapData[foundIndex]; 
				heapData[foundIndex] = temp; 
				foundIndex = getParent(foundIndex);
			}
			extractMax();
		}
	}
	
	private void heapify(int start) {
		//get left and right
		int leftIndex = getLeftChild(start); 
		int rightIndex = getRightChild(start); 
		int largest = start;
		//check for which of the children is the largest 
		if (leftIndex < size && heapData[leftIndex] > heapData[start]) {
			largest = leftIndex; 
		}
		if (rightIndex < size && heapData[rightIndex] > heapData[largest]) {
			largest = rightIndex; 
		}
		//if we found a value that is larger than the current index, swap them with the largest value
		if (largest != start) { 
			int temp = heapData[start]; 
			heapData[start] = heapData[largest]; 
			heapData[largest] = temp; 
			heapify(largest); 
		} 
	}
	
	private int getLeftChild(int index) {
		return (2*index) + 1;
	}
	private int getRightChild(int index) {
		return (2*index) + 2;
	}
	
	public int getParent(int index) {
		return (index - 1) / 2; 
	}
	
	public void printHeap() {
		for (int i = 0; i < size; i++) {
			System.out.print(heapData[i] + " "); 
		}
		System.out.println(); 
	}
}
