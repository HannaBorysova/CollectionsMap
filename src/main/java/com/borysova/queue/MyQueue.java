package main.java.com.borysova.queue;

public class MyQueue<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

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
    }

    public MyQueue() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T e) {
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
        return head.getElement();
    }

    public T poll() {
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

    private T removeLast() {
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

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("This index is not exist");
        }
        else if (index == 0) {
            poll();
        }
        else if (index == size - 1) {
            removeLast();
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

    public void printQ(){
        Node<T> temp = head;
        while(temp != null){
            System.out.println(temp.element);
            temp = temp.next;
        }
    }
}

class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<String> stringMyQ = new MyQueue<>();
        stringMyQ.add("a");
        stringMyQ.add("b");
        stringMyQ.add("c");
        stringMyQ.printQ();
        System.out.println("Size - " + stringMyQ.size());

        stringMyQ.remove(0);
        stringMyQ.printQ();
        System.out.println("Size after removing - " + stringMyQ.size());

        System.out.println("First element - " + stringMyQ.peek());

        System.out.println("First element to remove - " + stringMyQ.poll());
        System.out.println("Size after poll - " + stringMyQ.size());

        stringMyQ.printQ();

        stringMyQ.clear();
        System.out.println("Size after clear - " + stringMyQ.size());
    }
}

