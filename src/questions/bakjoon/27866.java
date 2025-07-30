import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        System.out.print(text.charAt(sc.nextInt()-1));
    }
}