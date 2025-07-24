import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] split = line.split(" ");
            if(split.length < 2) break;

            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);

            System.out.println(a+b);
        }
    }
}