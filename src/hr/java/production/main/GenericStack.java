package hr.java.production.main;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class GenericStack<T> {
    private LinkedList<T> stack;

    public GenericStack() {
        this.stack = new LinkedList<>();
    }

    // Method to add an element to the stack
    public void push(T element) {
        stack.addFirst(element);
    }

    // Method to remove and return the top element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stack.removeFirst();
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Optional: Method to peek at the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stack.getFirst();
    }
}