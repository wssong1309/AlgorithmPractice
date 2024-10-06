package AlgorithmPractice.BinomialCoefficient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Binomial_Memoization {
    static int[][] cache = new int[100][100];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 100; i++) {
            Arrays.fill(cache[i], -1);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("정수 두 개를 띄어쓰기로 구분해 입력하세요");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(n + "개의 원소 중 " + k + "개의 원소를 선택하는 경우의 수는 " + binomial(n, k) + "가지 입니다.");
    }

    public static int binomial(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        } else if (cache[n][k] != -1) {
            return cache[n][k];
        } else {
            cache[n][k] = binomial(n-1, k) + binomial(n-1, k-1);
            return cache[n][k];
        }
    }
}
