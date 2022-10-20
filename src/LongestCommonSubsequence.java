/* Наивная рекурсивная реализация задачи LCS в java*/
public class LongestCommonSubsequence {

    /* Возвращает длину LCS для X[0..m-1], Y[0..n-1] */
    int lcs(char[] X, char[] Y, int m, int n)
    {
        if (m == 0 || n == 0)
            return 0;
        if (X[m - 1] == Y[n - 1])
            return 1 + lcs(X, Y, m - 1, n - 1);
        else
            return max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
    }

    /* Служебная функция для получения максимум 2 целых чисел */
    int max(int a, int b)
    {
        return Math.max(a, b);
    }

    public static void main(String[] args)
    {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Длина LCS составляет"
                + " " + lcs.lcs(X, Y, m, n));
    }
}


