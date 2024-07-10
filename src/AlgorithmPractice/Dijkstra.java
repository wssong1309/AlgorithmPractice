package AlgorithmPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Dijkstra {
    final static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        int[][] matrix = {{0, 20, 30, 0, 0},
                {0, 0, 5, 40, 0},
                {0, 0, 0, 20, 30},
                {0, 0, 0, 0, 5},
                {0, 0, 0, 0, 0}};
        int[] s = new int[5];
        int[] dist = new int[5];
        int startNode = 0;
        int mindist;
        int nearestNodeNumber;
        int destNode;
        int newCost;

        /*for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                matrix[i][j] = r.nextInt(10);
            }
        }*/

        //그래프 출력
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println("--그래프--\n" + sb);

        //초기화
        s[startNode] = 1; //시작 노드 표시
        for (int i = 1; i < 5; i++) { //시작 노드에서 다른 노드까지 거리 저장
            dist[i] = matrix[startNode][i];
        }

        while (true) {
            mindist = MAX;
            nearestNodeNumber = -1;

            for (int i = 0; i < 5; i++) {
                if (s[i] == 0 && dist[i] < mindist && dist[i] > 0) {
                    mindist = dist[i];
                    nearestNodeNumber = i;
                }
            }

            if (nearestNodeNumber == -1) {
                break;
            } else {
                s[nearestNodeNumber] = 1;
                for (destNode = 0; destNode < 5; destNode++) {
                    if (s[destNode] == 0) {
                        newCost = dist[nearestNodeNumber] + matrix[nearestNodeNumber][destNode];
                        if (dist[destNode] == 0)
                            dist[destNode] = newCost;
                        else if (dist[destNode] > newCost)
                            dist[destNode] = newCost;
                    }
                }
            }
        }

        System.out.println("0번 노드에서의 최단경로");
        for (int i = 0; i < 5; i++) {
            System.out.print(dist[i] + " ");
        }
    }
}
