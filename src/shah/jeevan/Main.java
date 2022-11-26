package shah.jeevan;

public class Main {

    public static void main(String[] args) {
        Queue<Double> queue = new Queue<Double>();
        queue.enqueue(3.14);
        queue.enqueue(4.25);
        queue.enqueue(5.36);
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.front());
        System.out.println(queue);
    }
}