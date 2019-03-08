package QueueProblems;

import java.util.NoSuchElementException;

public class Queue<T> {
	public static class queueNode<T> {
		T data; 
		queueNode<T> next; 
		public queueNode(T val) {
			this.data = val; 
			this.next = null; 
		}
	}
	
	queueNode<T> front; 
	queueNode<T> back; 
	public Queue() {
		this.front = null; 
		this.back = null; 
	}
	
	public T remove() {
		if (front == null) {
			throw new NoSuchElementException(); 
		}
		T ret = front.data; 
		front = front.next; 
		if (this.front == null) {
			this.back = null; 
		}
		return ret; 
	}
	
	public void add(T item) {
		queueNode<T> add = new queueNode<T>(item); 
		if (back == null) {
			back = add;
			front = add; 
		} else {
			back.next = add; 
			back = add; 
		}
	}
	
	public T peek() {
		System.out.println(front.data); 
		return front.data; 
	}
	
	public boolean isEmpty() {
		return front == null; 
	}
}
