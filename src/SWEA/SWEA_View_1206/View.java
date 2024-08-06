package SWEA.SWEA_View_1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class View {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] buildings = new int[N];
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                buildings[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 2; j < N - 2; j++) {
                if (buildings[j - 2] < buildings[j] && buildings[j - 1] < buildings[j] && buildings[j + 2] < buildings[j] && buildings[j + 1] < buildings[j]) {
                    cnt += buildings[j] - max(sliceArray(buildings, j - 2, j + 2));
                }
            }

            sb.append("#" + i + " " + cnt + "\n");
        }

        System.out.println(sb);
    }

    static int max(int[] array) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (i == 2)
                continue;
            else if (max < array[i]) {
                max = array[i];
            }
        }

        return max;
    }

    static int[] sliceArray(int[] array, int start, int end) {
        int length = end - start + 1;
        int[] slicedArray = new int[length];
        System.arraycopy(array, start, slicedArray, 0, length);

        return slicedArray;
    }
}