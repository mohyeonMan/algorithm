import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = n / 4;

        StringBuilder sb = new StringBuilder();
        
        while(count -- > 0){
            sb.append("long ");
        }
        sb.append("int");

        System.out.print(sb.toString());

    }
}