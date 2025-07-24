import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int half = n / 2;
        int answer = half * (1 + n);


        if(n % 2 != 0) answer += (half + 1);

        System.out.println(answer);

    }
}