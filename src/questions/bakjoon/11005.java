import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int B = Integer.parseInt(split[1]);

        int answer = 0;
        int curB = B;

        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            int mod = N % B;
            if (mod > 9) sb.append((char) ('A' + mod - 10));
            else sb.append(mod);

            N = N / B;
        }

        System.out.print(sb.reverse().toString());
    }
}