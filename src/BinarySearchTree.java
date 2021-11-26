import java.util.Objects;

public class BinarySearchTree {
    Node root;

    public void inorderTraversal() {
//        printing inorder from root
        this.inorderTraversal(root);
    }
    private void inorderTraversal(Node node) {
        if (Objects.nonNull(node)){
            // because the left side it's smaller than the actual node print the left side first
            // as left side can contains more node print node left
            inorderTraversal(node.left);
            // after print all on the left side print the node value
            System.out.println(node);
            // because the right side it's greater than the actual node print the right side after the node
            // as right side can contains more node print node right
            inorderTraversal(node.right);
        }
    }

    public void getHeight() {
        System.out.println("Height: " + this.getHeight(root))   ;
    }

    private int getHeight(Node node) {
        int heightLeft = 0;
        int heightRight = 0;

        if (Objects.nonNull(node)){
            // getting the size of the left side
            heightLeft = getHeight(node.left);
            // getting the size of the right side
            heightRight = getHeight(node.right);
        }
        // returning the greater value between left and right side
        if (heightRight > heightLeft) {
            return heightRight;
        }
        return heightLeft;
    }

    public void insert(int data) {
       // if root it's null than the first value it's root
        if (Objects.isNull(root)){
            this.root = new Node(data);
            return;
        }

        Node parent = null;
        Node currentParent = root;
        // finding the parent to the new node
        // the search use the new value the determinate if it's the right ou left side
        while (Objects.nonNull(currentParent)) {
            parent = currentParent;
            if (data < currentParent.data) {
                currentParent = currentParent.left;
            } else {
                currentParent = currentParent.right;
            }
        }

        // after find the parent set the new node on the right size
        if (data < parent.data) {
            parent.left = new Node(data);
        } else {
            parent.right = new Node(data);
        }

    }

    public boolean contains(int target) {
        // find from the root
        return search(root, target);
    }

    private boolean search(Node node, int target) {
        if (Objects.nonNull(node)) {
            // if find the node it's the target returning true
            if (node.data == target){
                return true;
            }
            // if the target it's smaller than the actual node search on the left size
            if (target < node.data) {
                return search(node.left, target);
            }
            // if the target it's greater than the actual node search on the right size
            return search(node.right, target);
        }

        return false;
    }

    public int min() {
        return this.min(root);
    }

    private int min(Node node) {
        // going to the left most node in the tree
        while (Objects.nonNull(node.left)){
            node = node.left;
        }

        // returning his value
        return node.data;
    }

    public void remove(int value){
        this.remove(value, root);
    }

    private Node remove(int value, Node node) {
        // if it's null we can't do anything
        if (Objects.isNull(node)) {
            return null;
        }
        if (value < node.data) {
            // if the value it's smaller than the actual node, remove from the left side
            node.left = remove(value, node.left);
        } else if (value > node.data) {
            // if the value it's greater than the actual node, remove from the right side
            node.right = remove(value, node.right);
        } else {
            // if the value it is neither smaller nor greater, so it's the value. So let's remove
            if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
                // if the value hasn't children so the parent will be connected with nothing
                return null;
            }

            if (Objects.isNull(node.left)) {
                // if the value hasn't children on the left side so the parent will be connected with the right side
                return node.right;
            }

            if (Objects.isNull(node.right)) {
                // if the value hasn't children on the right side so the parent will be connected with the left side
                return node.left;
            }

            // if the value has children in both side so the new value will be the successor of the value

            // find the successor of the  value
            int substitute = min(node.right);
            // replacing the value
            node.data = substitute;
            // remove the successor from the tree
            node.right = remove(substitute, node.right);
        }

        return node;
    }
}
