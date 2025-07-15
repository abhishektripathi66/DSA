package datastructures.stack.main.exceptions;

public class StackUnderflowException extends Exception {
    private String message;

    public StackUnderflowException() {
        this.message = "You can't pop from an empty stack!";
    }

    public String getMessage() {
        return message;
    }

}
