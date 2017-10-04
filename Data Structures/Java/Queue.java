import java.util.NoSuchElementException;

public class Queue<T extends Comparable<T>> {

    private int maxSize;
    private int currentSize;
    private boolean areNullElementsAllowed;

    private Element<T> head;



    public Queue() {
        maxSize = -1;
        currentSize = 0;
        areNullElementsAllowed = true;
    }

    public Queue(int maxSize, boolean areNullElementsAllowed) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.areNullElementsAllowed = areNullElementsAllowed;
    }

    public boolean add(T item) {
        if(item == null && !areNullElementsAllowed) throw new NullPointerException();
        if(maxSize >= 0) {
            if(currentSize + 1 > maxSize) throw new IllegalStateException();
            Element<T> p = new Element<T>(item);
            p.next = head;
            head = p;
            currentSize++;
            return true;
        } else {
            Element<T> p = new Element<T>(item);
            p.next = head;
            head = p;
            currentSize++;
            return true;
        }
    }

    public T element() {
        if(currentSize == 0) throw new NoSuchElementException();
        Element<T> p = head;
        while (p.next != null) p = p.next;
        return p.data;
    }

    public boolean offer(T item) {
        if(item == null && !areNullElementsAllowed) throw new NullPointerException();
        if(maxSize >= 0) {
            if(currentSize + 1 > maxSize) return false;
            Element<T> p = new Element<T>(item);
            p.next = head;
            head = p;
            currentSize++;
            return true;
        } else {
            Element<T> p = new Element<T>(item);
            p.next = head;
            head = p;
            currentSize++;
            return true;
        }
    }

    public T poll() {
        if(currentSize == 0)
            return null;
        else {
            Element<T> p = head;
            while (p.next != null) p = p.next;
            currentSize--;
            return p.data;
        }
    }

    public T remove() {
        if(currentSize == 0) throw new NoSuchElementException();
        else {
            Element<T> p = head;
            while (p.next.next != null) p = p.next;
            T el = p.next.data;
            p.next = null;
            currentSize--;
            return el;
        }
    }

    public T peek() {
        if(currentSize == 0) return null;
        else {
            Element<T> p = head;
            while (p.next != null) p = p.next;
            return p.data;
        }
    }

    public boolean empty() {
        if(currentSize > 0) return false;
        return true;
    }

    public int search(T o) {
        Element<T> p = head;

        for(int i = 0; i < currentSize; i++) {
            if(p.data.equals(o)) {
                return currentSize - i;
            }
            p = p.next;
        }
        return -1;
    }

    public String toString() {
        if(currentSize == 0) {
            return "Queue empty";
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
}
