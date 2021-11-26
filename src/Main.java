public class Main {
    public static void main(String[] args) {
        BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.insert(10);
        binaryTree.insert(15);
        binaryTree.insert(5);
        binaryTree.insert(12);
        binaryTree.insert(7);
        binaryTree.insert(2);
        binaryTree.insert(17);

        binaryTree.inorderTraversal();

        System.out.println("contains: 10: " + binaryTree.contains(10));
        System.out.println("contains: 13: " + binaryTree.contains(13));

        System.out.println("Min: "+  binaryTree.min());
        System.out.println("removing the 12");
        binaryTree.remove(12);
        binaryTree.inorderTraversal();
    }
}
