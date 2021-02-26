package main.java.com.borysova.stack;

import main.java.com.borysova.queue.MyQueue;

public class MyStack<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    private static class Node<T> {
        private T element;
        private Node<T> next;
        private Node<T> prev;

        public Node(T e) {
            element = e;
        }

        public T getElement() {
            return element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> n) {
            next = n;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            prev = prev;
        }
    }

    public MyStack() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T e) {
        Node<T> newNode = new Node<>(e);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public T pop() {
        if (size == 0) return null;
        else if (size == 1) {
            Node<T> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        } else {
            Node<T> current = head;
            for (int i = 0; i < size - 2; i++)
                current = current.next;
            Node<T> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    private T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        else {
            Node<T> temp = head;
            head = head.next;
            size--;
            if (head == null) tail = null;
            return temp.element;
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("This index is not exist");
        }
        else if (index == 0) {
            removeFirst();
        }
        else if (index == size - 1) {
            pop();
        }
        else {
            Node<T> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node<T> current = previous.next;
            previous.next = current.next;
            size--;
        }
    }

    public void clear() {
        tail = null;
        head = null;
        size = 0;
    }

    public void printMyStack(){
        Node<T> temp = head;
        while(temp != null){
            System.out.println(temp.element);
            temp = temp.next;
        }
    }
}

class MyStackTest {
    public static void main(String[] args) {
        MyStack <String> stringMyStack = new MyStack<>();
        stringMyStack.push("a");
        stringMyStack.push("b");
        stringMyStack.push("c");
        stringMyStack.printMyStack();
        System.out.println("Size - " + stringMyStack.size());

        stringMyStack.remove(2);
        stringMyStack.printMyStack();

        System.out.println("First element as LIFO - " + stringMyStack.peek());
        System.out.println("First element to remove as LIFO - "
                + stringMyStack.pop());

        stringMyStack.printMyStack();
        System.out.println("Size after pop - " + stringMyStack.size());

        stringMyStack.clear();
        System.out.println("Size after clear " + stringMyStack.size());
    }
}