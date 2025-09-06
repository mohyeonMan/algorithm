import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        int total = 0;
        int i = 0;
        while(n > total){
            total += i;
            i++;
        }

        int v1 = total - n + 1;
        int v2 = i - v1; 
        
        System.out.println(i % 2 != 0? v2 +"/"+v1 : v1 +"/"+v2);


    }
}