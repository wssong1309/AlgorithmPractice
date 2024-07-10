package Queue_10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Queue {
    static int[] queue;
    static int front = 0, rear = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        queue = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {

                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(pop()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "front":
                    sb.append(front()).append('\n');
                    break;

                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }
        br.close();
        System.out.println(sb);
    }

    static void push(int num) {
        queue[rear++] = num;
    }

    static int pop() {
        if (front == rear)
            return -1;
        else
            return queue[front++];
    }

    static int size() {
        return rear - front;
    }

    static int empty() {
        if (front == rear)
            return 1;
        else
            return 0;
    }

    static int front() {
        if (front == rear)
            return -1;
        else
            return queue[front];
    }

    static int back() {
        if (front == rear)
            return -1;
        else
            return queue[rear - 1];
    }
}