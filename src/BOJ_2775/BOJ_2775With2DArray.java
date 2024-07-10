package BOJ_2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2775With2DArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] apt = new int[15][15];
        make_APT(apt);

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(apt[k][n]).append("\n");
        }

        System.out.println(sb);
    }

    public static int[][] make_APT(int[][] apt) {
        for (int i = 0; i < apt.length; i++) {
            for (int j = 0; j < apt[i].length; j++) {
                if (i == 0) {
                    apt[i][j] = j;
                } else if (j == 0) {
                    apt[i][j] = apt[i - 1][j];
                } else {
                    apt[i][j] = apt[i - 1][j] + apt[i][j - 1];
                }
            }
        }

        return apt;
    }
}
