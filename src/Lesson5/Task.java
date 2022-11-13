package Lesson5;

import java.util.Random;
import java.util.Scanner;


public class Task{
    public void sort(int[] arr) {
        int n = arr.length;

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            beautify(arr, n, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру beautify на уменьшенной куче
            beautify(arr, i, 0);
        }
    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i,
    // что является
    // индексом в arr[]. n - размер кучи
    void beautify(int[] arr, int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // левый = 2*i + 1
        int r = 2 * i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный
        // момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            beautify(arr, n, largest);
        }
    }

    /* Вспомогательная функция для вывода на экран массива размера n */
    static void printArray(int[] arr) {
        for (int j : arr)
            System.out.print(j + " ");
        System.out.println();
    }

    // Управляющая программа
    public static void main(String[] args) {

        int[] array = new int[10];
        int minRandom = 1;
        int maxRandom;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("введите макс элемент");
            maxRandom = scanner.nextInt();
        }
        Random random = new Random(System.currentTimeMillis());
        String comma = "";
        for (int i = 0; i < array.length; i++) {
            array[i] = minRandom + random.nextInt(maxRandom - minRandom + 1);
            System.out.printf("%s%s", comma, array[i]);
            // Now define comma
            comma = " ";

        }

        final Task ob = new Task();
        ob.sort(array);

        System.out.println();
        System.out.println("Отсортированный массив");
        printArray(array);
    }
    public static void printTree(int[] array) {
        int n = array.length;
        for (int i = n / 2; i >= 0; i++){

        }
            

    }

}

class app {
    public static void main(String[] args) {
        Node root = new Node(1);

        Node n2 = new Node(2);
        Node n3 = new Node(3);

        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        Node n7 = new Node(7);
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

        n6.left = n11;
        n6.right = n20;
        // 1 2 4 7 9 3 5 6 11 20
        preOrder(root, "");
    }

    static void preOrder(Node tree, String space) {
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

}

// nil
class Node {
    int value;

    public Node(int value) {
        this.value = value;
    }

    Node left;
    Node right;
}