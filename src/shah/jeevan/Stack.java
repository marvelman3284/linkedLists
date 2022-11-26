package shah.jeevan;

public class Stack<T> extends LinkedList {
    public Stack() {
        super();
    }

    public void push(T data) {
        super.insertTail(data);
    }

    public T pop() {
        return (T) super.deleteTail();
    }

    public T top() {
        return (T) super.back();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    public int size() {
        return super.length();
    }

    public String toString() {
        return "Stack " + super.toString();
    }

    public Stack clone() {
        return this;
    }
}