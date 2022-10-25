package Lesson1_2;

import java.util.Random;
import java.util.Scanner;

public class HeapSort {
    public void sort(int[] arr)
    {
        int n = arr.length;

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            beautify(arr, n, i);

        // Один за другим извлекаем элементы из кучи
        for (int i=n-1; i>=0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру beautify на уменьшенной куче
            beautify(arr, i, 0);
        }
    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
// индексом в arr[]. n - размер кучи
    void beautify(int[] arr, int n, int i)
    {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2*i + 1; // левый = 2*i + 1
        int r = 2*i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            beautify(arr, n, largest);
        }
    }

    /* Вспомогательная функция для вывода на экран массива размера n */
    static void printArray(int[] arr)
    {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    // Управляющая программа
    public static void main(String[] args)
    {

        int [] array = new int[10];
        int minRandom = 1;
        int maxRandom;

        Scanner scanner = new Scanner(System.in);
        System.out.println("введите макс элемент");
        maxRandom = scanner.nextInt();

        Random random = new Random(System.currentTimeMillis());
        String comma="";
        for (int i = 0; i < array.length; i++) {
            array[i] = minRandom + random.nextInt(maxRandom - minRandom + 1);
            System.out.printf("%s%s", comma, array[i]);
                // Now define comma
                comma = ",";

        }

        final HeapSort  ob = new HeapSort();
        ob.sort(array);

        System.out.println();
        System.out.println("Отсортированный массив");
        printArray(array);
    }
}

