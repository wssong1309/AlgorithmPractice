/*N개의 문제가 있을 때 가능한 점수 조합의 개수를 구하는 문제. (1 <= N <= 100)
 * 문제의 조건에서, N(문제의 개수)이 100까지 주어질 수 있기 때문에 combination을 사용해서 문제를 풀면 경우의 수가 너무 많아 시간이 초과될 수 있다.
 * 따라서 모든 경우의 수를 구한 다음, set에 넣어 중복을 그때그때 제거하는 방식으로 문제를 풀어야 한다.
 *
 * N=1, 배점이 {a}라면, 가능한 경우의 수는 0, 0+a.
 * N=2, 배점이 {a, b}라면, 가능한 경우의 수는 0, 0+a, 0+b, 0+a+b.
 * 문제의 개수가 N일 때 가능한 경우의 수는 N-1일 때 점수의 모든 조합에 지금까지 사용하지 않았던 수를 더해주는 것, 그리고 0은 기본적으로 들어간다.
 *
 * -코드 순서-
 * 아래의 논리를 N번 반복한다.
 * tmpSet에 possibleScore의 점수를 복사한다.
 * tmpSet에서 숫자를 하나씩 꺼내서 n번째 점수를 더한 뒤 possibleScore에 추가한다.*/
package SWEA.SWEA_PossibleScore_3752;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class PossibleScore {
    static Set<Integer> possibleScore = new HashSet<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            possibleScore.clear();
            possibleScore.add(0);

            int ans = 0;
            int N = Integer.parseInt(br.readLine());

            int[] numbers = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                numbers[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < N; j++) {
                scoreSelect(numbers[j]);
            }

            ans = possibleScore.size();
            sb.append("#").append(i).append(" ").append(ans).append("\n");
        }

        System.out.println(sb);
    }

    static void scoreSelect(Integer num) {
        Set<Integer> tmpSet = new HashSet<Integer>();
        tmpSet.addAll(possibleScore);
        Iterator<Integer> it = tmpSet.iterator();
        while (it.hasNext()) {
            possibleScore.add(it.next() + num);
        }
    }
}
