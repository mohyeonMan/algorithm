import java.io.IOException;
import java.util.*;

class Main {
    static int N, M;
    static int[] array;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        array = new int[N];
        for (int i = 0; i < N; i++) array[i] = sc.nextInt();

        Arrays.sort(array);

        dfs(0, 0, 0);
        System.out.println(max);

    }   

    private static void dfs(int start, int count, int sum) {
        if (sum > M) return;
        if (count == 3) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = start; i <= N - (3 - count); i++) {
            int next = sum + array[i];
            if (next > M) break;
            dfs(i + 1, count + 1, next);
        }
    }
}