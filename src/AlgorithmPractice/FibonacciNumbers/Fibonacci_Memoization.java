package AlgorithmPractice.FibonacciNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Fibonacci_Memoization {
    static int[] fib = new int[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Arrays.fill(fib, -1);

        System.out.println("몇 번째 피보나치 수를 출력할까요?");

        int n = Integer.parseInt(br.readLine());

        System.out.println(NthFib(n));
    }

    public static int NthFib(int n) {
        if (n == 0 || n == 1)
            return 1;
        else if (fib[n] != -1)
            return fib[n];
        else {
            fib[n] = NthFib(n - 1) + NthFib(n - 2);
            return fib[n];
        }
    }
}
