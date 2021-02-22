package main.java.com.borysova.lists;

public class MyLinkedList<E> {

    private Node<E> last;
    private Node<E> first;
    private int size = 0;

    public MyLinkedList() {
        last = new Node<E>(null, first, null);
        first = new Node<E>(null, null, last);
    }

    private class Node<E> {
        private E element;
        Node<E> previous;
        Node<E> next;

        public Node(E element, Node<E> previous, Node<E> next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    public void add(E element) {
        Node<E> prev = last;
        prev.setElement(element);
        last = new Node<E>(null, prev, null);
        prev.setNext(last);
        size++;
    }

    public int size() {
        return size;
    }

    public boolean remove(int index) {
        if(index >=0 && index < size){
            Node<E> removeNode = getNodeByIndex(index);
            Node<E> prevNode = removeNode.getPrevious();
            Node<E> nextNode = removeNode.getNext();
            prevNode.setNext(nextNode);
            nextNode.setPrevious(prevNode);
            size--;
            return true;
        } else {
            return false;
        }
    }

    private Node<E> getNodeByIndex(int counter) {
        Node<E> removeTarget = first.getNext();
        for (int i = 0; i < counter; i++) {
            removeTarget = getNextElement(removeTarget);
        }
        return removeTarget;
    }

    public E get(int index) {
        Node<E> target = first.getNext();
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target.getElement();
    }

    private Node<E> getNextElement(Node<E> current) {
        return current.getNext();
    }

    public void clear() {
       first = null;
       last = null;
       size = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(" " + get(i));
        }
        return stringBuilder.toString();
    }
}

class MyLinkedListTester {
    public static void main(String[] args) {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.add("a");
        stringMyLinkedList.add("b");
        stringMyLinkedList.add("c");
        System.out.println(stringMyLinkedList);
        System.out.println(stringMyLinkedList.get(2));
        System.out.println(stringMyLinkedList.size());
        stringMyLinkedList.remove(1);
        System.out.println(stringMyLinkedList);
        System.out.println(stringMyLinkedList.size());
        stringMyLinkedList.clear();
        System.out.println(stringMyLinkedList.size());
    }
}