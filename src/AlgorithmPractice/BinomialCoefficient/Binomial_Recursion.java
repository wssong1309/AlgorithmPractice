package AlgorithmPractice.BinomialCoefficient;

/* 이항정리에서 생각해볼 점
* n개의 원소 중 k개의 원소를 뽑는 경우의 수는 두 가지 갈래로 나눠진다.
* 1. n개의 원소 중 A를 선택하지 않는 경우
*    아직 선택한 원소가 없기 때문에 남은 n-1개의 원소 중에 k개의 원소를 선택해야 한다.
* 2. n개의 원소 중 A를 선택하는 경우
*    원소를 1개 선택했기 때문에 남은 n-1개의 원소 중에 k-1개의 원소를 선택해야 한다.
* 따라서 nCk = n-1Ck + n-1Ck-1이다.
* 위의 결론을 코드로 작성하기만 하면 끝이다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Binomial_Recursion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("정수 두 개를 띄어쓰기로 구분해 입력하세요");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(n + "개의 원소 중 " + k + "개의 원소를 선택하는 경우의 수는 " + binomial(n, k) + "가지 입니다.");
    }

    public static int binomial(int n, int k) {
        if (n == k || k == 0)
            return 1;
        else
            return binomial(n-1, k) + binomial(n-1, k-1);
    }
}
