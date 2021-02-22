package main.java.com.borysova.queue;

public class MyQueue<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    private static class Node<T> {
        private T element;
        private Node<T> next;

        public Node(T e, Node<T> n) {
            element = e;
            next = n;
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
            return "" + element + " " + next;
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
        Node<T> newNode = new Node<>(e, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
        System.out.println("Added tail node with '" +
                tail.getElement() + "' element.");
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
            System.out.println("Removed head node with '"
                    + temp.element + "' element.");
            return temp.element;
        }
    }

    public T removeLast() {
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

    public T remove(int index) {
        if (index < 0 || index >= size) return null;
        else if (index == 0) return poll();
        else if (index == size - 1) return removeLast();
        else {
            Node<T> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node<T> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    public void clear() {
        tail = null;
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        return " " + head;
    }
}

class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<String> stringMyQ = new MyQueue<>();
        stringMyQ.add("a");
        stringMyQ.add("b");
        stringMyQ.add("c");
        System.out.println(stringMyQ);
        System.out.println("Size - " + stringMyQ.size());

        System.out.println("Element should to remove - "
                + stringMyQ.remove(0));
        System.out.println("Size after removing - " + stringMyQ.size());

        System.out.println("First element - " + stringMyQ.peek());

        System.out.println("First element to remove - " + stringMyQ.poll());
        System.out.println("Size after poll - " + stringMyQ.size());

        System.out.println(stringMyQ);

        stringMyQ.clear();
        System.out.println("Size after clear - " + stringMyQ.size());
    }
}

