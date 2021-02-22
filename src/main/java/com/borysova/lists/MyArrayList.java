package main.java.com.borysova.lists;

import java.util.Arrays;

public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int CUT_RATE = 4;
    private static final int DIVIDER = 2;
    private static final int MULTIPLAYER = 3;
    private Object[] array = new Object[DEFAULT_CAPACITY];
    private int size;

    public MyArrayList() {
    }

    public void add(T element) {
        if (size == array.length -1) {
            resize(((array.length * MULTIPLAYER) / DIVIDER) + 1);
        }
        array[size++] = element;
    }

    public void remove(int index) {
        if (array.length > DEFAULT_CAPACITY && size < array.length / CUT_RATE) {
            resize(array.length / DIVIDER);
        }
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
            array[size--] = null;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

        private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public T get (int index) {
        return (T) array[index];
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}

class MyArrayListTester {
    public static void main(String[] args) {
        MyArrayList<String> str = new MyArrayList<>();
        str.add("a");
        str.add("b");
        str.add("c");
        str.add("d");
        System.out.println(str.toString());

        System.out.println(str.get(1));

        System.out.println(str.size());

        str.remove(2);
        System.out.println(str.toString());
        System.out.println(str.size());

        str.clear();
        System.out.println(str.size());
    }
}