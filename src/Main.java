/*
 * +На вход некоторому исполнителю подаётся два числа (a, b). У исполнителя есть
 * две команды
 * - команда 1 (к1): увеличить а в с раз, а умножается на c
 * - команда 2 (к2): увеличить на d, к a прибавляется d
 * написать программу, которая выдаёт набор команд, позволяющий число a
 * превратить в число b или сообщить, что это невозможно
 * Пример 1: а = 1, b = 7, c = 2, d = 1
 * ответ: к2, к2, к2, к2, к2, к2, k2 или к1, к1, к2, к2, к2
 * Можно начать с более простого – просто подсчёта общего количества вариантов
 * Пример 2: а = 11, b = 7, c = 2, d = 1
 * ответ: нет решения.
 * Подумать над тем, как сделать минимальное количество команд
 */
public class Main {
    public static void main(String[] args) {

        int a = 1;
        int b = 7;
        int k1 = 2; // умножение на 2
        int k2 = 1; // прибавление на 1
        StringBuilder answer = new StringBuilder();
        if (a > b) {
            System.err.println("нет решения");
        } else {
            while (a < b) {
                if ((a*k1) < b){
                    a = a*k1;
                    answer.append("k1");

                } else {
                    a = a+k2;
                    answer.append("k2");
                }
            }

            System.out.println(answer);

        }
    }
}
//  k1 k1 k2 k2 k2


 /*
    public static void main(String[] args) {
        int a = 1;
        int b = 7;
        int c = 2;
        int d = 1;
        int result = a;

        String line = null;

        while (result <= b) {
            result = multiply(result, c);
            line = line + "k1";

            if (a < b) {
                a *= c;
            }

        }

        System.out.println("line: " + line);

    }

    public static int multiply(int a, int c) {
        return a * c;
    }

    public static int addition(int a, int c) {
        return a + c;
    }
}
*/
/*
 * public class Main {
 * public static void main(String[] args) {
 *
 * byte a = 1;
 * byte b = 7;
 * byte c = 2;
 * byte d = 1;
 * int rez_temp = a;
 *
 * String rezult = null;
 *
 * while (rez_temp <= b){
 * rez_temp = multiply(rez_temp, c);
 * rezult = rezult + "k1";
 *
 * if (rez_temp == b){
 * break;
 * }
 *
 * rez_temp = addition(rez_temp, d);
 * rezult = rezult + "k2";
 * if (rez_temp == b){
 * break;
 * }
 * }
 *
 *
 *
 * System.out.println(rezult);
 *
 * }
 *
 * public static int multiply(int a, int c){
 * return a * c;
 * }
 *
 * public static int addition(int a, int c){
 * return a + c;
 * }
 * }
 *
 */

/*
 * Зал № 2
 * //Путь 2 - команда сложения
 * System.out.println("\nПуть 2 - команда сложения");
 * int count_operation_2 = 0;
 * boolean way_is_good_2 = false;
 * flag_to_continue = true;
 * temp_val = a;
 * while (flag_to_continue){
 * temp_val = command_add(temp_val, d);
 * if (temp_val > b){
 * flag_to_continue = false;
 * }
 * else if (temp_val == b){
 * way_is_good_2 = true;
 * flag_to_continue = false;
 * }
 * ++count_operation_2;
 * String res = String.format("%d - %d  - %d - %b - %b", temp_val, b,
 * count_operation_1, flag_to_continue, way_is_good_2);
 * System.out.println(res);
 * }
 *
 */
