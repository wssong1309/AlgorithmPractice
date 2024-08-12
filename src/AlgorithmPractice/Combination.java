package AlgorithmPractice;

public class Combination {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        int[] numbers = {1, 2, 3, 4, 5};
        boolean[] visited = new boolean[5];

        sb.append("배열 초기값\n");
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]).append(" ");
        }
        sb.append("\n\n5개의 숫자 중에 3개 숫자를 순서없이 뽑는 경우");
        System.out.println(sb);

        combination(numbers, visited, 0, 5, 3);
    }

    //n개의 숫자 중 r개 숫자를 순서없이 뽑는 경우의 수를 구하는 함수
    //depth는 현재 인덱스를 의미한다.
    public static void combination(int[] numbers, boolean[] visited, int depth, int n, int r) {
        //n개의 숫자 중 한 개도 뽑지 않는다면 아무것도 출력하지 않음
        //또는 아래에서 r을 1씩 빼면서 combination 함수를 호출하기 때문에 r == 0인 경우, 원하는 만큼 숫자를 선택한 경우가 됨.
        if (r == 0) {
            print(numbers, visited, n);
            return;
        }

        //depth == n이면 끝에 도달한 것이므로 return
        if (depth == n)
            return;

        //현재 인덱스를 방문한것(선택한 것)으로 표시하고, 다음 숫자를 선택하기 위해 combination()을 적절히 호출
        visited[depth] = true;
        combination(numbers, visited, depth + 1, n, r - 1);

        //이 부분은 직접 따져보면 금방 알 수 있다.
        visited[depth] = false;
        combination(numbers, visited, depth + 1, n, r);
    }

    public static void print(int[] numbers, boolean[] visited, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sb.append(numbers[i]).append(" ");
            }
        }
        System.out.println(sb);
    }
}