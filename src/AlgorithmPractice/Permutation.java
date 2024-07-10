package AlgorithmPractice;

public class Permutation {
    static int[] initArr = {1, 2, 3, 4, 5};
    static int[] resultArr = new int[3];
    static boolean[] visited = new boolean[5];
    static int n = 5;
    static int r = 3;
    static int cnt = 0;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n5개의 숫자 중에 3개 숫자를 뽑는 경우");
        System.out.println(sb);

        permutation(0);
        System.out.println("개수 : " + cnt);
    }

    public static void permutation(int depth) {
        if (depth == r) {
            print();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                resultArr[depth] = initArr[i];
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            sb.append(resultArr[i]).append(" ");
        }
        System.out.println(sb);
        cnt++;
    }
}
