package Lesson5;



// import java.util.ArrayList;

// public class Tree {
//     public static void main(String[] args) {
//         Node root = new Node(1);

//         Node n2 = new Node(2);
//         Node n3 = new Node(3);

//         Node n4 = new Node(4);
//         Node n5 = new Node(5);
//         Node n6 = new Node(6);

//         Node n7 = new Node(7);
//         Node n8 = new Node(8);
//         Node n9 = new Node(9);
//         Node n11 = new Node(11);
//         Node n20 = new Node(20);

//         // root.left = n2;
//         // root.right = n3;

//         // n2.left = n4;
//         // n3.left = n5;
//         // n3.right = n6;

//         // n4.left = n7;
//         // n4.right = n9;

//         // n6.left = n11;
//         // n6.right = n20;
//         // // 1 2 4 7 9 3 5 6 11 20
//         // preOrder(root, "");

//         ArrayList<Node> rootNodes = new ArrayList<Node>();
//         rootNodes.add(n2);
//         rootNodes.add(n3);
//         root.son = rootNodes;

//         ArrayList<Node> Nodes1 = new ArrayList<Node>();
//         Nodes1.add(n4);
//         n2.son = Nodes1;

//         ArrayList<Node> Nodes2 = new ArrayList<Node>();
//         Nodes2.add(n5);
//         Nodes2.add(n6);
//         n3.son = Nodes2;

//         ArrayList<Node> Nodes3 = new ArrayList<Node>();
//         Nodes3.add(n7);
//         Nodes3.add(n8);
//         Nodes3.add(n9);
//         n4.son = Nodes3;

//         ArrayList<Node> Nodes4 = new ArrayList<Node>();
//         Nodes4.add(n11);
//         Nodes4.add(n20);
//         n6.son = Nodes4;

//         preOrder(root, "");

//     }

//     static void preOrder(Node tree, String space) {
//         if (tree != null)
//             System.out.println(space + tree.value);
//         else {
//             System.out.println(space + "nil");
//             return;
//         }
//         if (tree.left != null || tree.right != null) {
//             preOrder(tree.left, space + "  ");
//             preOrder(tree.right, space + "  ");
//         }
//         for (int i = 0; i < tree.son.size(); i++) {
//             preOrder(tree.son.get(i), space + " ");
//         } 
//     }
// }

// // nil
// class Node {
//     int value;

//     protected ArrayList<Node> son = new ArrayList<Node>();

//     public void add(Node node){
//         son.add(node);
//     }

//     public Node(int value) {
//         this.value = value;
//     }

//     Node left;
//     Node right;
// }
import java.util.ArrayList;
import java.util.List;

public class Tree<T extends Comparable<T>> {
    private T val;
    private Tree left;
    private Tree right;
    private Tree parent;
    private List<T> listForPrint = new ArrayList<>();

    public T val() {
        return val;
    }

    public Tree left() {
        return left;
    }

    public Tree right() {
        return right;
    }

    public Tree parent() {
        return parent;
    }

    public Tree(T val, Tree parent) {
        this.val = val;
        this.parent = parent;
    }

    public void add(T... vals) {
        for (T v : vals) {
            add(v);
        }
    }

    public void add(T val) {
        if (val.compareTo(this.val) < 0) {
            if (this.left == null) {
                this.left = new Tree(val, this);
            } else if (this.left != null)
                this.left.add(val);
        } else {
            if (this.right == null) {
                this.right = new Tree(val, this);
            } else if (this.right != null)
                this.right.add(val);
        }
    }

    private Tree<T> _search(Tree<T> tree, T val) {
        if (tree == null)
            return null;
        switch (val.compareTo(tree.val)) {
            case 1:
                return _search(tree.right, val);
            case -1:
                return _search(tree.left, val);
            case 0:
                return tree;
            default:
                return null;
        }
    }

    public Tree<T> search(T val) {
        return _search(this, val);
    }

    public boolean remove(T val) {
        // ??????????????????, ???????????????????? ???? ???????????? ????????
        Tree<T> tree = search(val);
        if (tree == null) {
            // ???????? ???????? ???? ????????????????????, ???????????? false
            return false;
        }
        Tree<T> curTree;
        // ???????? ?????????????? ????????????
        if (tree == this) {
            if (tree.right != null) {
                curTree = tree.right;
            } else
                curTree = tree.left;
            while (curTree.left != null) {
                curTree = curTree.left;
            }
            T temp = curTree.val;
            this.remove(temp);
            tree.val = temp;
            return true;
        }
        // ???????????????? ??????????????
        if (tree.left == null && tree.right == null && tree.parent != null) {
            if (tree == tree.parent.left)
                tree.parent.left = null;
            else {
                tree.parent.right = null;
            }
            return true;
        }
        // ???????????????? ????????, ???????????????? ?????????? ??????????????????, ???? ???? ?????????????? ?????????????? ??????????????????
        if (tree.left != null && tree.right == null) {
            // ???????????? ????????????????
            tree.left.parent = tree.parent;
            if (tree == tree.parent.left) {
                tree.parent.left = tree.left;
            } else if (tree == tree.parent.right) {
                tree.parent.right = tree.left;
            }
            return true;
        }
        // ???????????????? ????????, ???????????????? ???????????? ??????????????????, ???? ???? ?????????????? ???????????? ??????????????????
        if (tree.left == null && tree.right != null) {
            // ???????????? ????????????????
            tree.right.parent = tree.parent;
            if (tree == tree.parent.left) {
                tree.parent.left = tree.right;
            } else if (tree == tree.parent.right) {
                tree.parent.right = tree.right;
            }
            return true;
        }
        // ?????????????? ????????, ?????????????? ???????????????????? ?? ?????????? ????????????
        if (tree.right != null && tree.left != null) {
            curTree = tree.right;
            while (curTree.left != null) {
                curTree = curTree.left;
            }
            // ???????? ?????????? ?????????? ?????????????? ???????????????? ???????????? ????????????????
            if (curTree.parent == tree) {
                curTree.left = tree.left;
                tree.left.parent = curTree;
                curTree.parent = tree.parent;
                if (tree == tree.parent.left) {
                    tree.parent.left = curTree;
                } else if (tree == tree.parent.right) {
                    tree.parent.right = curTree;
                }
                return true;
            }
            // ???????? ?????????? ?????????? ?????????????? ???? ???????????????? ???????????? ????????????????
            else {
                if (curTree.right != null) {
                    curTree.right.parent = curTree.parent;
                }
                curTree.parent.left = curTree.right;
                curTree.right = tree.right;
                curTree.left = tree.left;
                tree.left.parent = curTree;
                tree.right.parent = curTree;
                curTree.parent = tree.parent;
                if (tree == tree.parent.left) {
                    tree.parent.left = curTree;
                } else if (tree == tree.parent.right) {
                    tree.parent.right = curTree;
                }
                return true;
            }
        }
        return false;
    }

    private void _print(Tree<T> node) {
        if (node == null)
            return;
        _print(node.left);
        listForPrint.add(node.val);
        System.out.print(node + " ");
        if (node.right != null)
            _print(node.right);
    }

    public void print() {
        listForPrint.clear();
        _print(this);
        System.out.println();
    }

    @Override
    public String toString() {
        return val.toString();
    }
    
    static void preOrder(Node tree, String space) {
        /**
         * Tree
         */
        if (tree != null)
            System.out.println(space + tree.value);
        else {
            System.out.println(space + "nil");
            return;
        }
        if (tree.left != null || tree.right != null) {
            preOrder(tree.left, space + "  ");
            preOrder(tree.right, space + "  ");
        }
    }


public static void main(String[] args) {
  //???????????????? ???????????? ?? ???????????????? ?????????????????? 33
  Tree<Integer> tree = new Tree<>(33, null);
  tree.add(5, 35, 1, 20, 4, 17, 31, 99, 18, 19, 55, 75);
  //?????????????????????? ???????????????? ????????????
  tree.print();
  //???????????? ????????????
  tree.remove(33);
  tree.remove(17);
  tree.add(18);
  tree.add(34);
  tree.print();
  //?????????????????? ???????????????? ????????????
  System.out.println(tree);
  System.out.println(tree.left());
  System.out.println(tree.left().left());
  System.out.println(tree.right().left());


  // ?????????? ????????????
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

  root.left = n2;
  root.right = n3;

  n2.left = n4;
  n3.left = n5;
  n3.right = n6;

  n4.left = n7;
  n4.right = n9;
  n5.left = n8;

  n6.left = n11;
  n6.right = n20;
  // 1 2 4 7 9 3 5 6 11 20
  preOrder(root, "");
}
}