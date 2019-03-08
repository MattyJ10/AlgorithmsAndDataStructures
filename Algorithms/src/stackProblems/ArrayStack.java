package stackProblems;

import java.util.EmptyStackException;

public class ArrayStack {
	public int[] data; 
	public int count; 
	
	public ArrayStack() {
		this.data = new int[50];
		this.count = 0; 
	}
	
	public int pop() {
		if (this.count > 0) {
			int ret = this.data[count-1]; 
			this.count--; 
			return ret; 
		} else {
			throw new EmptyStackException(); 
		}
	}
	
	public boolean push(int add) {
		if (this.count == 50) {
			System.out.println("Stack Full"); 
			return false; 
		} else {
			this.data[count] = add; 
			count++; 
			return true; 
		}
	}
	
	public int peek() {
		System.out.println(this.data[count-1]); 
		return this.data[count-1]; 
		
	}
	
	public boolean isEmpty() {
		if (count == 0) {
			return true; 
		} else {
			return false; 
		}
	}
}
