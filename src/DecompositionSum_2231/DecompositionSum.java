package DecompositionSum_2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecompositionSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;

        for (int i = 0; i < N; i++) {
            int check = i;
            for (int j = 6; j >= 0; j--) {
                if (check / (int) Math.pow(10, j) == 0) {
                    check %= Math.pow(10, j);
                } else {
                    sum += check / Math.pow(10, j);
                    check %= Math.pow(10, j);
                }
            }
            sum += i;
            if (sum == N) {
                System.out.println(i);
                return;
            } else {
                sum = 0;
            }
        }
        System.out.println(0);
    }
}
