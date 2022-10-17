import java.util.Scanner;

public class triangularNumber {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Введите число n, для вычисления n-ого треугольного числа:");

            int n = scan.nextInt();

            if (n < 0) {
                System.out.println("Для отрицательных чисел треугольное число посчитать не получится.");
            } else {
                System.out.println("Для n = " + n + " треугольное число = " + TriangularNumber(n));
            }
        } catch (Exception e) {
            System.err.println("Вы ввели не число");
        }
    }

    public static int TriangularNumber(int n) {

        return ((n * (n + 1)) / 2);
    }
}
