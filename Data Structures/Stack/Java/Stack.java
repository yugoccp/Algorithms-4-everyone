public class Stack<T extends Comparable<T>> {

    private LinkedList<T> stackList;

    public Stack() {
        stackList = new LinkedList<T>();
    }

    public T push(T item) {
        stackList.append(item);
        return item;
    }

    public T pop() {
        T el = stackList.getLast();
        stackList.remove(stackList.getSize());
        return el;
    }

    public T peek() {
        return stackList.getLast();
    }

    public boolean empty() {
        if(stackList.getSize() == 0) {
            return true;
        }
        return false;
    }

    public int search(T o) {
        return stackList.find(o);
    }

    public String stackToString() {
        return stackList.toString();
    }

}
