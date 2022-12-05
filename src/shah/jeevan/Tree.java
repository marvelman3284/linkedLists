package shah.jeevan;

public class Tree<T extends Comparable<T>> {

    private TreeNode<T> root;
    private LinkedList<T> list;

    public Tree() {
        root = null;
        list = new LinkedList<T>();
    }

    public Tree(LinkedList linkedList) {
        root = null;
        for (int i = 0; i < linkedList.length(); i++) {
            this.insert((T) linkedList.get(i));
        }
    }

    public void insert(T data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            root.insert(data);
        }
    }

    public boolean search (T data) {
        return recursiveSearch(data, root);
    }

    private boolean recursiveSearch(T data, TreeNode current) {
        if (current == null) {
            return false;
        } else if (data.compareTo((T)current.data) < 0) {
            return recursiveSearch(data, current.left);
        } else if (data.compareTo((T)current.data) > 0) {
            return recursiveSearch(data, current.right);
        } else {
            return true;
        }
    }

    public String toString() {
        String output = "Tree traversals:\n";
        output += "(1) PreOrder: " + preOrder().toString();
        output += "(1) PostOrder: " + postOrder().toString();
        output += "(1) InOrder: " + inOrder().toString();
        return output;
    }

    public LinkedList preOrder() {
        list = new LinkedList<T>();
        preOrderRecursive(root);
        return list;
    }

    private void preOrderRecursive(TreeNode<T> current) {
        if (current == null) {
            return;
        }
        list.add((T) current.data);
        preOrderRecursive(current.left);
        preOrderRecursive(current.right);
    }

    public LinkedList postOrder() {
        list = new LinkedList<T>();
        postOrderRecursive(root);
        return list;
    }

    private void postOrderRecursive(TreeNode<T> current) {
        if (current == null) {
            return;
        }
        postOrderRecursive(current.left);
        postOrderRecursive(current.right);
        list.add((T) current.data);
    }

    public LinkedList inOrder() {
        list = new LinkedList<T>();
        inOrderRecursive(root);
        return list;
    }

    private void inOrderRecursive(TreeNode<T> current) {
        if (current == null) {
            return;
        }
        inOrderRecursive(current.left);
        list.add((T) current.data);
        inOrderRecursive(current.right);
    }
}
