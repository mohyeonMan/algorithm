import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long curMax = 1;
        int answer = 1;
        while(n > curMax){
            curMax += answer * 6;
            answer++;
        }

        System.out.println(answer);

    }
}