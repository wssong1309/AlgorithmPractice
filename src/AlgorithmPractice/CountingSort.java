package AlgorithmPractice;

import java.util.Random;

public class CountingSort {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // 17개 랜덤 숫자 생성
        Random random = new Random();
        int[] number = new int[7];
        for (int i = 0; i < 7; i++) {
            number[i] = random.nextInt(20);
            sb1.append(number[i]).append(' ');
        }
        System.out.println(sb1);

        // 각 숫자가 몇 번 생성됐는지 count - 생성되는 숫자 범위: 0~20, 생성된 숫자를 인덱스로 하는 count 배열의 방 +1
        int[] count = new int[20];
        for (int i = 0; i < 7; i++) {
            count[number[i]]++;
        }

        // 누적합으로 변경 - count[1] = count[0] + count[1] => 0이 2번, 1이 3번 나왔다면 count[1]은 5
        // 여기서 누적합이 의미하는것은 0이 result 배열의 인덱스 0~1 공간을 차지한다는 것. 1은 result 배열의 인덱스 2~4 공간을 차지할 것이다.
        for (int i = 1; i < 20; i++) {
            count[i] += count[i - 1];
        }

        // 정렬 결과를 저장할 배열
        int[] result = new int[7];

        for (int i = 6; i >= 0; i--) { // number 배열은 오름차순 정렬이니까 16부터 0까지
            count[number[i]]--; // i == 16일때, number[16]에 어떤 숫자가 들어있을것이고, count[number[16]에 누적합이 써있을것.
            result[count[number[i]]] = number[i]; // counting 배열의 주석대로 result 배열을 채워나간다.
        }

        for (int i = 0; i < 7; i++) {
            sb2.append(result[i]).append(' ');
        }

        System.out.println(sb2);
    }
}
