package AlgorithmPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class VerifyPrimeNumber {
    public static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        getPrime(N);

        for (int i = M; i < prime.length; i++) {
            if (prime[i] == false) {
                System.out.println(i);
            }
        }
    }

    public static void getPrime(int N) {
        prime = new boolean[N + 1];

        if (N < 2) {
            return;
        }

        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (prime[i]) {
                continue;
            }

            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}