package shah.jeevan;

public class Queue<T> extends LinkedList {

    public Queue() {
        super();
    }

    public Queue(LinkedList linkedList) {
        super(linkedList);
    }

    public void enqueue(T data) {
        super.insertTail(data);
    }

    public T dequeue() {
        return (T) super.deleteHead();
    }

    public T front() {
        return (T) super.front();
    }

    public T back() {
        return (T) super.back();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    public int size() {
        return super.length();
    }

    public String toString() {
        return "Queue " + super.toString();
    }

    public Queue clone() {
        return this;
    }
}
