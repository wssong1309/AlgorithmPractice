package AlgorithmPractice;

public class FindMaze {
    private static int N = 8;
    private static int[][] maze = {
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0, 1, 0, 0}
    };

    public static void main(String[] args) {
        print(maze, N);
        System.out.println();
        findPath(0, 0);
        print(maze, N);
    }

    private static final int PATH = 0; // white
    private static final int WALL = 1; // blue
    private static final int BLOCKED = 2; // red
    private static final int ROUTE = 3; // green

    public static boolean findPath(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N)
            return false;
        else if (maze[x][y] != PATH)
            return false;
        else if (x == N - 1 && y == N - 1)
            return true;
        else {
            maze[x][y] = ROUTE;
            if (findPath(x + 1, y) || findPath(x - 1, y) || findPath(x, y + 1) || findPath(x, y - 1))
                return true;
            maze[x][y] = BLOCKED;
            return false;
        }
    }

    public static void print(int[][] arr, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
