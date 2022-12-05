package shah.jeevan;

public class Main {

    public static void main(String[] args) {
        String[] array = {"mayonaise", "ahhh", "dinosaur", "tree", "hypoxia", "super", "apocoiphal"};
        LinkedList<String> list = new LinkedList<String>(array);
        Stack<String> stack = new Stack<String>(list);
        Queue<String> queue = new Queue<String>(stack);
        Tree<String> tree = new Tree<String>(queue);
        System.out.println(tree);

    }
}