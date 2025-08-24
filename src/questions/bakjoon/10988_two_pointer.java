import java.io.IOException;
import java.util.*; 

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();
        char[] chars = word.toCharArray();

        for(int s = 0, e = word.length() - 1; s < e ; s++, e-- ){
            if(chars[s] != chars[e]){
                System.out.print(0);
                return;
            }
        }
        System.out.print(1);

    }
}