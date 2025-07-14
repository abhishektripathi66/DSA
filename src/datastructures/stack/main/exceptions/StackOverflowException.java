package datastructures.stack.main.exceptions;

public class StackOverflowException extends Exception {
    private String message;

    public StackOverflowException() {
        message = "Stack overflow has occurred, max capacity is reached!";
    }

    public String getMessage() {
        return message;
    }
}
