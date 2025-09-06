import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int side = (int)Math.pow(2, n)+1;
        System.out.print(side * side);

    }
}