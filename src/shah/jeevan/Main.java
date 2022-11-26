package shah.jeevan;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(50);
        stack.push(60);
        stack.push(70);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}