package Baekjoon.Statistics_2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StatisticsWithCountingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[8001];
        int[] numbers = new int[N];

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // 한줄씩 읽어서 value에 저장
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            numbers[i] = value;
            sum += value; // 산술평균을 위한 합계
            arr[value + 4000]++; // counting 정렬을 위해 숫자를 셈

            if (max < value) { // 최대값
                max = value;
            }
            if (min > value) { // 최소값
                min = value;
            }
        }

        // 산술평균
        sb.append(Math.round((double) sum / N)).append("\n");

        // 일단 최빈값 먼처 찾자
        int maxFreq = 0;
        int maxFreqIdx = 0;
        boolean flag = false;
        for (int i = 0; i < 8001; i++) {
            if (arr[i] == maxFreq && !flag) {
                maxFreqIdx = i;
                flag = true;
            } else if (arr[i] > maxFreq) {
                maxFreq = arr[i];
                maxFreqIdx = i;
                flag = false;
            }
        }
        flag = true;

        for (int i = 1; i < 8001; i++) {
            arr[i] += arr[i - 1];
        }

        int[] result = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            arr[numbers[i] + 4000]--;
            result[arr[numbers[i] + 4000]] = numbers[i];
        }

        // 중앙값
        sb.append(result[N / 2]).append("\n");

        // 최빈값
        sb.append(maxFreqIdx - 4000).append("\n");

        // 범위
        sb.append(max - min).append("\n");

        System.out.println(sb);
    }
}
