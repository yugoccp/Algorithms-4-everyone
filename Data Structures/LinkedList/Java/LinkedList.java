import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class LinkedList<T extends Comparable<T>> {

    private Element<T> head;
    private int size;

    public LinkedList() {
        size = 0;
    }

    public LinkedList(T data) {
        this(new Element<T>(data));
    }

    public LinkedList(LinkedList<T> list) {
        this.head = list.head;
        this.size = list.size;
    }

    private LinkedList(Element<T> head) {
        this.head = head;
        size = 1;
    }

    public int getSize() {
        return size;
    }


    public int find(T obj) {

        Element<T> p = head;

        for(int i = 1; i < size; i++) {
            if(p.data.equals(obj)) {
                return i;
            }
            p = p.next;
        }
        return -1;
    }

    public void prepend(T data) {
        prepend(new Element<T>(data));
    }

    private void prepend(Element<T> el) {
        el.next = head;
        head = el;
        size++;
    }

    public void append(T data) {
        append(new Element<T>(data));
    }

    private void append(Element<T> data) {
        if(size == 0) {
            prepend(data);
        } else {
            Element<T> p = head;

            while (p.next != null) {
                p = p.next;
            }

            p.next = data;
            size++;
        }
    }

    public void insert(T data, int pos) {
        insert(new Element<T>(data), pos);
    }

    private void insert(Element<T> data, int pos) {
        if(size == 0 || pos <= 0) {
            prepend(data);
        } else if (pos >= size){
            append(data);
        } else {
            Element<T> p = head;

            for (int i = 1; i < pos; i++) p = p.next;

            data.next = p.next;
            p.next = data;
            size++;
        }
    }

    public void remove(int pos) {
        if(size == 0 || pos < 0 || pos > size) {
            throw new NoSuchElementException();
        }

        if(pos == 0) {
            head = head.next;
            size--;
        } else {
            Element<T> p = head;
            for(int i = 1; i < pos - 1 && p.next != null; i++) p = p.next;

            Element<T> q = p.next.next;
            p.next.next = null;
            p.next = q;
            size--;
        }
    }

    public boolean contains(T data) {
        return contains(new Element<T>(data));
    }

    private boolean contains(Element<T> el) {
        if(size == 0) return false;

        Element<T> p = head;

        while (p.next != null) {
            if(p.equals(el)) {
                return true;
            }

            p = p.next;
        }

        return p.equals(el);
    }


    private static class Element<T extends Comparable<T>> {

        private T data;
        private Element<T> next;

        public Element(T data) { this.data = data; }

        public boolean equals(Element<T> el) {
            if(el == null) return false;

            if ((el.data == null) && (this.data == null)) {
                return true;
            }

            if ((el.data == null) || (this.data == null)) {
                return false;
            }

            return (el.data.equals(this.data));
        }

        public int compareTo(Element<T> el) {
            return data.compareTo(el.data);
        }
    }

    public T getLast() {

        if(size == 0) throw new EmptyStackException();

        Element<T> p = head;

        for(int i = 0; i < size - 1; i++, p = p.next);
        return p.data;
    }

    public String toString() {
        if(size == 0) {
            return "List is empty";
        }

        StringBuilder res = new StringBuilder();

        Element<T> p = head;
        res.append(p.data);

        while (p.next != null) {
            res.append(", ");
            p = p.next;
            res.append(p.data);
        }

        return "[" + res.toString() + "]";
    }
}
