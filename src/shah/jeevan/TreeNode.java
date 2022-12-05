package shah.jeevan;


public class TreeNode<T extends Comparable<T>> {

    public T data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(T data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode(T data) {
        this(data, null, null);
    }

    public TreeNode() {
        this(null, null, null);
    }

    public void insert(T data) {
        if (data.compareTo(this.data) < 0) {
            if (this.left == null) {
                this.left = new TreeNode(data);
            } else {
                this.left.insert(data);
            }
        } else if (data.compareTo(this.data) >= 0) {
            if (this.right == null) {
                this.right = new TreeNode(data);
            } else {
                this.right.insert(data);
            }
        }
    }

    @Override
    public String toString() {
        String text = "Data = " + data.toString();
        text += "\n Left = " + this.left.toString();
        text += "\n Right = " + this.right.toString();
        return text;
    }
}
