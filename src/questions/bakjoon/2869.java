import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);
        int up = sc.nextInt();
        int down = sc.nextInt();
        int v = sc.nextInt();

        int step = up - down;
        int remain = v - up;
        int days = (int)Math.ceil(remain / (double)step) + 1;

        System.out.println(days);

    }
}