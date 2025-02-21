package main.exceptions;

public class EmptyStackException extends Exception{
	private String message;

	public EmptyStackException() {
		this.message = "Stack is empty!";
	}

	public String getMessage() {
		return message;
	}
	
}
