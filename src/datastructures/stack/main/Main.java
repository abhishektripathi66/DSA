package datastructures.stack.main;


import main.stack.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        Stack s = new Stack(5);
        s.push(2);

        System.out.println(s.showStackContent());

        s.push(3);

        System.out.println(s.showStackContent());

        s.push(4);

        System.out.println(s.showStackContent());

        s.push(5);

        System.out.println(s.showStackContent());

        s.push(6);

        System.out.println(s.isFull());

        // s.push(7);

//		s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();

        System.out.println(s.peek());

        System.out.println(s.showStackContent());
        System.out.println(s.isEmpty());

        // s.pop();
    }
}
