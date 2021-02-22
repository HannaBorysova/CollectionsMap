package main.java.com.borysova.stack;

public class MyStack<T> {

    private static class Node<T> {
        private T element;
        private Node<T> next;

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

        @Override
        public String toString() {
            return element + " " + next;
        }
    }

    private Node<T> nodeElement = null;
    private int size = 0;
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
        newNode.setNext(nodeElement);
        nodeElement = newNode;
        size++;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return nodeElement.getElement();
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            Node<T> myNode = nodeElement.getNext();
            size--;
            return (T) nodeElement.getElement();
        }
    }

    public void clear() {
        nodeElement = null;
        size = 0;
    }

    @Override
    public String toString() {
        return "" + nodeElement;
    }
}

class MyStackTester {
    public static void main(String[] args) {
        MyStack <String> stringMyStack = new MyStack<>();
        stringMyStack.push("a");
        stringMyStack.push("b");
        stringMyStack.push("c");
        System.out.println(stringMyStack);
        System.out.println("Size - " + stringMyStack.size());

        System.out.println("Last element - " + stringMyStack.peek());
        System.out.println("Last element to remove - " + stringMyStack.pop());

        System.out.println(stringMyStack.size());

        stringMyStack.clear();
        System.out.println(stringMyStack.size());
    }
}