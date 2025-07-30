import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0){
            String text = sc.nextLine();
            System.out.println(text.charAt(0)+""+text.charAt(text.length()-1));
        }
    }
}