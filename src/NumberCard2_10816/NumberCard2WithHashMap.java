package NumberCard2_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class NumberCard2WithHashMap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // N 입력
        StringTokenizer st = new StringTokenizer(br.readLine()); // N개의 숫자 입력
        Map<Integer, Integer> map = new HashMap<>(); // 숫자를 입력받을 map 선언

        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            // put으로 데이터를 넣을떄 동일한 키로 다른값을 넣으면 더 늦게 들어간 값으로 대체된다.
            // 1. map.put() 메서드로 넣을 때 key는 입력된 숫자, value는 중복된 개수로 한다.
            // 2. map.getOrDefault() 메서드는 우선 key를 이용해서 value를 찾고, 없으면 defaultValue를 return한다.
            // 3. 따라서 처음 들어가는 key에는 value로 1이 들어가고, 두 번째 이후로는 1씩 추가되어 들어간다.
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine()); // M 입력
        st = new StringTokenizer(br.readLine()); // M개의 숫자 입력

        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken()); // 입력받은 M개의 숫자를 하나씩 탐색
            sb.append(map.getOrDefault(key, 0)).append(" "); // map에 숫자가 있다면 value를 return할 것이고, 없다면 0을 return할 것이다.
        }

        System.out.println(sb);
    }
}
