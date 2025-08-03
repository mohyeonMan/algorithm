import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        int answer = 0;

        String l = sc.nextLine();
        for(char v : l.toCharArray()){
            answer += v - 48;
        }

        System.out.println(answer);
    }
}