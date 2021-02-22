package main.java.com.borysova.map;

import java.util.Objects;

public class MyHashMap<K, V> {
    private final int CAPACITY = 16;
    private Entry<K, V> table[];
    private int size;

    private class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key);
        }
    }

    public MyHashMap() {
        table = new Entry[CAPACITY];
    }

    public void put(K key, V value) {
        int hash = key.hashCode() % CAPACITY;
        Entry<K, V> e = table[hash];

        if (e == null) {
            table[hash] = new Entry<K, V>(key, value);
        } else {
            while (e.next != null) {
                if (e.getKey() == key) {
                    e.setValue(value);
                    return;
                }
                e = e.next;
            }
            if (e.getKey() == key) {
                e.setValue(value);
                return;
            }
            e.next = new Entry<K, V>(key, value);
        }
        size++;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int hash = key.hashCode() % CAPACITY;
        Entry<K, V> e = table[hash];
        if (e == null) {
            return null;
        }
        while (e != null) {
            if (e.getKey() == key) {
                return e.getValue();
            }
            e = e.next;
        }
        return null;
    }

    public Entry<K, V> remove(K key) {
        int hash = key.hashCode() % CAPACITY;
        Entry<K, V> e = table[hash];
        if (e.getKey() == key) {
            table[hash] = e.next;
            e.next = null;
            return e;
        }
        Entry<K, V> prev = e;
        e = e.next;

        while (e != null) {
            if (e.getKey() == key) {
                prev.next = e.next;
            }
        }
        return null;
    }

    public void clear() {
        Entry<K, V>[] t;
        if ((t = table) != null && size > 0) {
            size = 0;
            for (int i = 0; i < t.length; ++i)
                t[i] = null;
        }
    }

    public void printMyHashMap() {
        for (int i = 0; i < CAPACITY; i++) {
            if (table[i] != null) {
                Entry<K, V> e = table[i];
                while (e != null) {
                    System.out.println(String.format(e.getKey() +
                            "=" + e.getValue()));
                    e = e.next;
                }
            }
        }
        if (size == 0) {
            System.out.println("null");
        }
    }
}

class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("A", "first");
        myHashMap.put("B", "second");
        myHashMap.put("C", "thi");
        myHashMap.put("C", "third");
        myHashMap.printMyHashMap();
        System.out.println(myHashMap.size());
        System.out.println(myHashMap.get("C"));
        myHashMap.remove("B");
        myHashMap.printMyHashMap();
        myHashMap.clear();
        System.out.println(myHashMap.size());
    }
}