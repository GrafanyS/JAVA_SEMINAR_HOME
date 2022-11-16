package Lesson5;

import java.util.ArrayList;

public class Tree {
    public static void main(String[] args) {
        Node root = new Node(1);

        Node n2 = new Node(2);
        Node n3 = new Node(3);

        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n11 = new Node(11);
        Node n20 = new Node(20);

        // root.left = n2;
        // root.right = n3;

        // n2.left = n4;
        // n3.left = n5;
        // n3.right = n6;

        // n4.left = n7;
        // n4.right = n9;

        // n6.left = n11;
        // n6.right = n20;
        // // 1 2 4 7 9 3 5 6 11 20
        // preOrder(root, "");

        ArrayList<Node> rootNodes = new ArrayList<Node>();
        rootNodes.add(n2);
        rootNodes.add(n3);
        root.son = rootNodes;

        ArrayList<Node> Nodes1 = new ArrayList<Node>();
        Nodes1.add(n4);
        n2.son = Nodes1;

        ArrayList<Node> Nodes2 = new ArrayList<Node>();
        Nodes2.add(n5);
        Nodes2.add(n6);
        n3.son = Nodes2;

        ArrayList<Node> Nodes3 = new ArrayList<Node>();
        Nodes3.add(n7);
        Nodes3.add(n8);
        Nodes3.add(n9);
        n4.son = Nodes3;

        ArrayList<Node> Nodes4 = new ArrayList<Node>();
        Nodes4.add(n11);
        Nodes4.add(n20);
        n6.son = Nodes4;

        preOrder(root, "");

    }

    static void preOrder(Node tree, String space) {
        if (tree != null)
            System.out.println(space + tree.value);
        else {
            System.out.println(space + "nil");
            return;
        }
        // if (tree.left != null || tree.right != null) {
        //     preOrder(tree.left, space + "  ");
        //     preOrder(tree.right, space + "  ");
        // }
        
        for (int i = 0; i < add(tree).size(); i++) {
            preOrder(tree.son.get(i), space + " ");
        } 
    }
}

// nil
class Node {
    int value;

    private ArrayList<Node> son = new ArrayList<Node>();

    public void add(Node node){
        son.add(node);
    }

    public Node(int value) {
        this.value = value;
    }

    // Node left;
    // Node right;
}
    


