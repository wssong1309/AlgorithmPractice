package Baekjoon.Deque_10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Deque {
    static int[] deque;
    static int front, rear;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        deque = new int[N * 2];
        front = rear = N;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {

                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    sb.append(pop_front()).append('\n');
                    break;

                case "pop_back":
                    sb.append(pop_back()).append('\n');
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

    static void push_front(int num) {
        deque[--front] = num;
    }

    static void push_back(int num) {
        deque[rear++] = num;
    }

    static int pop_front() {
        if (front == rear)
            return -1;
        else
            return deque[front++];
    }

    static int pop_back() {
        if (front == rear)
            return -1;
        else
            return deque[--rear];
    }

    static int size() {
        return rear - front;
    }

    static int empty() {
        if (rear == front)
            return 1;
        else
            return 0;
    }

    static int front() {
        if (rear == front)
            return -1;
        else
            return deque[front];
    }

    static int back() {
        if (rear == front)
            return -1;
        else
            return deque[rear - 1];
    }
}
