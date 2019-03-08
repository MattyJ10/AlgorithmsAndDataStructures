package stackProblems;

import java.util.EmptyStackException;

public class LinkedListStack<Item> {
	public static class stackNode<Item> {
		Item data; 
		stackNode<Item> next; 
		public stackNode(Item val) {
			this.data = val; 
			this.next = null; 
		}
	}
	
	public stackNode<Item> top;
	
	public Item pop() {
		if (top == null) {
			throw new EmptyStackException(); 
		}
		Item val = top.data; 
		top = top.next; 
		return val; 
	}
	
	public void push(Item val) {
		stackNode<Item> add = new stackNode<Item>(val); 
		add.next = top; 
		top = add; 
	}
	
	public Item peek() {
		System.out.println(top.data); 
		return top.data; 
	}
	
	public boolean isEmpty() {
		return top == null; 
	}
	
}
