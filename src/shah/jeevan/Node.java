package shah.jeevan;

public class Node<T> {

    public T data;
    public Node next;
    public Node previous;


    public Node(T data, Node next, Node previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public Node(T data, Node next) {
        this(data, next, null);
    }

    public Node(T data) {
        this(data, null, null);
    }

    public Node() {
        this(null, null, null);
    }


    @Override
    public String toString() {
        if (data == null) return "null";
        return data.toString();
    }


    @Override
    public boolean equals(Object object) {
        if (this.data == null) return false;
        if (object == null) return false;
        Node that = (Node) object;
        if (that.data == null) return false;
        return this.data.equals(that.data);
    }

    @Override
    public Node clone() {
        return new Node(data, next, previous);
    }

    @Override
    public void finalize() {
        data = null;
        next = previous = null;
        System.gc();
    }
}