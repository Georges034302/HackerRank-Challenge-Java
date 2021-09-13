package Trees;

import java.util.List;

/**
 *
 * @author George
 */
public class Tree {

    class Node {

        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    //number of edges from root to farthest node
    public static int height(Node root) {
        return Math.max(root.left != null ? height(root.left) : -1, root.right != null ? height(root.right) : -1) + 1;
    }

    //Lowest common ancestor
    public static Node lca(Node root, int v1, int v2) {
        if (root == null) {
            return null;
        }

        if (root.data > v1 && root.data > v2) {
            return lca(root.left, v1, v2);
        }

        if (root.data < v1 && root.data < v2) {
            return lca(root.right, v1, v2);
        }

        return root;
    }

    boolean checkBST(Node root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.left.data > root.data) {
            return false;
        }

        if (root.right != null && root.right.data < root.data) {
            return false;
        }

        return checkBST(root.left) && checkBST(root.right);
    }

    public static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    void decode(String s, Node root) {
        StringBuilder output = new StringBuilder();
        Node base = root;
        while (!s.isEmpty()) {            
            base = (s.charAt(0) == '0') ? base.left : base.right;
            s = s.substring(1);
            
            if(isLeaf(base)){
                output.append(base.data);
                base = root;
            }            
        }
        System.out.println(output.toString());
    }

    public static int balancedForest(List<Integer> c, List<List<Integer>> edges) {
    
        return 0;
    }
    
    public static void main(String[] args) {
        Node head = null;
        System.out.format(" Heigh = %-4d \n", height(head));
    }

}
