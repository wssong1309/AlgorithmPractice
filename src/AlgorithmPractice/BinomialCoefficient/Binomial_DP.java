package AlgorithmPractice.BinomialCoefficient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Binomial_DP {
    static int[][] cache = new int[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("정수 두 개를 띄어쓰기로 구분해 입력하세요");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 100; i++) {
            Arrays.fill(cache[i], -1);
        }


        System.out.println(n + "개의 원소 중 " + k + "개의 원소를 선택하는 경우의 수는 " + binomial(n, k) + "가지 입니다.");
    }

    /* DP는 bottom-up 방식으로 6C3을 구하려면 어떤 값을 먼저 구해야 하는가에 대해 생각해보면서 논리를 전개한다.
     * 여기서는 bottom이 (0,0)이고, 배열에 어떤식으로 채워지는지 생각하면서 논리를 생각하면 좀 더 쉬울 것이다.*/

    public static int binomial(int n, int k) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k && j <= i; j++) {
                if (i == j || j == 0) {
                    cache[i][j] = 1;
                } else {
                    cache[i][j] = cache[i - 1][j] + cache[i - 1][j - 1];
                }
            }
        }
        return cache[n][k];
    }
}
