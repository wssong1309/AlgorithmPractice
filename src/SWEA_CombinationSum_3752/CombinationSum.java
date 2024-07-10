package SWEA_CombinationSum_3752;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CombinationSum {
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] numbers = new int[N];
            boolean[] visited = new boolean[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                numbers[j] = Integer.parseInt(st.nextToken());

            for (int k = 0; k < N; k++)
                combination(numbers, visited, 0, N, k);

            sb.append("#").append(i+1).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    public static void combination(int[] numbers, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            cnt++;
            return;
        }

        if (depth == n)
            return;

        visited[depth] = true;
        combination(numbers, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        combination(numbers, visited, depth + 1, n, r);
    }
}
