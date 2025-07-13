package main.stack;

import java.util.LinkedList;
import java.util.List;

import main.exceptions.EmptyStackException;
import main.exceptions.StackOverflowException;
import main.exceptions.StackUnderflowException;

public class Stack {
	private List<Integer> stackContent;
	private int usedCapacity;
	private int maxCapacity;
	
	public Stack(int size) {
		this.stackContent = new LinkedList<Integer>();
		this.usedCapacity = 0;
		this.maxCapacity = size;
	}
	
	public void push(Integer val) throws Exception {
		if (this.maxCapacity > this.usedCapacity) {
			this.stackContent.add(val);
			this.usedCapacity += 1;
		} else {
			throw new StackOverflowException();
		}
	}
	
	public Integer pop() throws StackUnderflowException {
		Integer popped = -1;
		if (this.usedCapacity <= 0) {
			throw new StackUnderflowException();
		} else {
			Integer elementForRemoval = this.stackContent.get(usedCapacity - 1);
			if (elementForRemoval != null) {
				popped = elementForRemoval;
				this.stackContent.remove(usedCapacity - 1);
				this.usedCapacity -= 1;
			}
		}
		
		return popped;
	}
	
	public boolean isFull() {
		System.out.println(usedCapacity + "vs" + maxCapacity);
		return this.usedCapacity == this.maxCapacity;
	}
	
	public boolean isEmpty() {
		return this.usedCapacity == 0;
	}
	
	public String showStackContent() throws EmptyStackException {
		StringBuilder sb = new StringBuilder();
		if (!this.isEmpty()) {
			sb.append("Bottom of the stack --> |");
			for (int i = 0; i < this.usedCapacity; i++) {
				sb.append(stackContent.get(i).toString() + "|");
			}
			sb.append(" <-- Top of the stack");
		} else {
			throw new EmptyStackException();
		}
		
		return sb.toString();
	}
	
	public int peek() throws EmptyStackException {
		if (!this.isEmpty()) {
			return this.stackContent.get(this.usedCapacity - 1);
		} else {
			throw new EmptyStackException();
		}
	}
}
