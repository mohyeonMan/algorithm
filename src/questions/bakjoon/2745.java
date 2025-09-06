import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        String N = split[0];
        int B = Integer.parseInt(split[1]);

        int answer = 0;
        int curB = 1;
        

        for(int i = N.length()-1; i >= 0 ; i--){
            char c = N.charAt(i);
            
            int num = c - '1' + 1 ;
            if(num >= 10) num -= 'A' - '1' - 9;
            
            answer += num * curB;

            curB *= B;
        }

        System.out.print(answer);
    }
}