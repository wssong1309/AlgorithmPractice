package AlgorithmPractice.FibonacciNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci_Recursion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("몇 번째 피보나치 수를 출력할까요?");

        int n = Integer.parseInt(br.readLine());

        System.out.println(NthFib(n));
    }

    public static int NthFib(int n) {
        if (n == 1 || n == 2)
            return 1;
        else
            return NthFib(n - 2) + NthFib(n - 1);
    }
}
