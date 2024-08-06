package Baekjoon.Stack_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Stack {
    static int[] stack;
    static int top = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        stack = new int[N];

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

                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }
        br.close();
        System.out.println(sb);
    }

    static void push(int num) {
        stack[++top] = num;
    }

    static int pop() {
        if (top == -1)
            return -1;
        return stack[top--];
    }

    static int size() {
        return top + 1;
    }

    static int empty() {
        if (top == -1) return 1;
        else return 0;
    }

    static int top() {
        if (top == -1)
            return -1;
        return stack[top];
    }
}