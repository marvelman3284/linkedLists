

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        System.out.println(list);
        list.insertHead(10);
        System.out.println(list);
        list.insertHead(5);
        System.out.println(list);
        list.insertHead(20);
        list.set(0, 55);
        list.set(20, -5);
        System.out.println(list);
        list.insertBefore(0, 69);
        System.out.println(list);
        list.delete(1);
        System.out.println(list);
    }
}