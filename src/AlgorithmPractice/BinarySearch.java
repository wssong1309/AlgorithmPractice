package AlgorithmPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Random random = new Random();
        int[] number = new int[17];
        for (int i = 0; i < 17; i++) {
            number[i] = random.nextInt(50);
        }
        Arrays.sort(number);

        for (int i = 0; i < 17; i++) {
            System.out.print(number[i] + " ");
        }

        System.out.println("\n" + binarySearch(number, N));
    }

    public static int binarySearch(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (key < arr[mid]) {
                hi = mid - 1;
            } else if (key > arr[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
