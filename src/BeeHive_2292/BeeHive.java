package BeeHive_2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeeHive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int border = 1;
        int cnt = 1;

        while (border <= Integer.MAX_VALUE) {
            if (N <= border) {
                System.out.println(cnt);
                return;
            } else {
                border += (cnt * 6);
                cnt++;
            }
        }
    }
}
