package AlgorithmPractice.FibonacciNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci_DP {
    static int[] fib = new int[100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("몇 번째 피보나치 수를 출력할까요?");

        int n = Integer.parseInt(br.readLine());

        System.out.println(NthFib(n));
    }

    public static int NthFib(int n) {
        fib[1] = fib[2] = 1;
        for (int i = 3; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}
