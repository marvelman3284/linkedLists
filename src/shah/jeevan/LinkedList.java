package shah.jeevan;

public class LinkedList<T> {

    private int length;
    private Node head;
    private Node tail;

    public LinkedList() {
        destroy();
    }

    public LinkedList(LinkedList linkedList) {
        this.destroy();
        for (int i = 0; i < linkedList.length(); i++) {
            this.add((T)linkedList.get(i));
        }
    }

    public LinkedList(T[] array) {
        if (array != null) {
            fromArray(array);
        }
    }

    public final void destroy() {
        length = 0;
        head = tail = null;
    }

    public void insertHead(T data) {
        Node<T> node = new Node<T>(data);
        if (isEmpty()) {
            insertTail(data);
        } else {
            node.next = head;
            head.previous = node;
            head = node;
        }
        length++;
    }

    public void insertTail(T data) {
        Node<T> node = new Node<T>(data);
        if (isEmpty()) {
            tail = node;
            head = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        length++;
    }

    public void set(int index, T data) {
        Node node = getNode(index);
        if (node != null) {
            node.data = data;
        }
    }

    public T front() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    public T back() {
        if (isEmpty()) {
            return null;
        }
        return get(length-1);
    }

    public LinkedList clone() {
        LinkedList<T> list = new LinkedList<T>();

        for (int i = 0; i < length; i++) {
            list.insertTail(this.get(i));
        }

        return list;
    }

    public boolean contains(T data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int firstIndexOf(T data) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        Node current = tail;
        int index = length-1;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.previous;
            index--;
        }
        return -1;
    }

    private Node getNode(int index) {
        if (inRange(index)) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }
        return null;
    }

    public T[] toArray() {
        java.util.LinkedList<T> list = new java.util.LinkedList<T>();
        for (int i = 0; i < length; i++) {
            list.add(this.get(i));
        }
        T[] array = (T[])list.toArray();
        return array;
    }

    public void fromArray(T[] array) {
        destroy();
        for (int i = 0; i < array.length; i++) {
            insertTail(array[i]);
        }
    }

    public T deleteHead() {
        if (isEmpty()) {
            return null;
        } else {
            T data = (T) head.data;
            if (length == 1) {
                destroy();
            } else {
                head = head.next;
                head.previous.next = null;
                head.previous = null;
                length--;
            }
            return data;
        }
    }

    public T deleteTail() {
        if (isEmpty()) {
            return null;
        } else {
            T data = (T) tail.data;
            if (length == 1) {
                destroy();
            } else {
                tail = tail.previous;
                head.next.previous = null;
                tail.next = null;
                length--;
            }
            return data;
        }
    }

    public void add(T data) {
        insertTail(data);
    }

    private boolean inRange(int index) {
        if (isEmpty() || index < 0 || index >= length) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isEmpty() {
        return length == 0;
    }
    public void insertBefore(int index, T data) {
        if (inRange(index)) {
            if (index == 0) {
                insertHead(data);
            } else {
                Node node = new Node(data);
                Node current = getNode(index);
                node.previous = current.previous;
                current.previous.next = node;
                current.previous = node;
                node.next = current;
                length++;
            }
        }
    }

    public void insertAfter(int index, T data) {
        if (inRange(index)) {
            if (index == 0) {
                insertHead(data);
            } else {
                Node node = new Node(data);
                Node current = getNode(index);
                node.next = current.next;
                current.next.previous = node;
                current.next = node;
                node.previous = current;
                length++;
            }
        }
    }

    public T delete(int index) {
        if (inRange(index)) {
            if (index == 0) {
                return deleteHead();
            } else if (index == length - 1) {
                return deleteTail();
            } else {
                Node current = getNode(index);
                current.previous.next = current.next;
                current.next.previous = current.previous;
                current.next = null;
                current.previous = null;
                length--;
                return (T) current.data;
            }
        }
        return null;
    }

    public int length() {
        return length;
    }

    public T get(int index) {
        if (inRange(index)) {
            return (T) getNode(index).data;
        }
        return null;
    }

    public String toString() {
        if (isEmpty()) {
            return "Empty list!";
        } else {
            String text = "List = ";
            Node current = head;
            while (current != null) {
                text += current + ", ";
                current = current.next;
            }
            return text;
        }
    }
}
