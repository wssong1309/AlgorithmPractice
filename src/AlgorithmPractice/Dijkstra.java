package AlgorithmPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Dijkstra {

    static final int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[][] cost = {{0, 20, 30, max, max}, // 행 번호가 출발정점, 열 번호가 도착정점
                {max, 0, 5, 40, max},
                {max, max, 0, 20, 30},
                {max, max, max, 0, 5},
                {max, max, max, max, 0}};
        boolean[] s = new boolean[5];
        long[] dist = new long[5];
        int start;

        System.out.print("시작 정점을 입력하세요 (0 - 4): ");
        start = Integer.parseInt(br.readLine());

        // 초기 설정
        for (int i = 0; i < 5; i++) {
            dist[i] = cost[start][i];
        }

        dijkstra(start, cost, s, dist);

        for (int i = 0; i < 5; i++) {
            sb.append("정점 ").append(start).append("에서 정점 ").append(i).append("까지의 최단경로값 = ").append(dist[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dijkstra(int start, long[][] cost, boolean[] s, long[] dist) {

        int minIndex;
        long minValue;
        long newcost;

        while (true) {

            minIndex = -1;
            minValue = max;

            for (int i = 0; i < 5; i++) {
                if (!s[i] && dist[i] < minValue) {
                    minIndex = i;
                    minValue = dist[i];
                }
            }

            if (minIndex == -1) { // minIndex == -1의 의미는 위의 if 조건을 둘중 하나라도 만족하는 경우가 없었다는 것.
                break;
            } else {
                s[minIndex] = true;
                for (int j = 0; j < 5; j++) {
                    if (!s[j]) { // 최단경로가 찾아지지 않았으면
                        newcost = dist[minIndex] + cost[minIndex][j];
                        if (newcost < dist[j]) {
                            dist[j] = newcost;
                        }
                    }
                }
            }
        }
    }
}
