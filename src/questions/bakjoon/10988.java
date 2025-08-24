import java.io.IOException;
import java.util.*; 

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);

        Queue<Character> queue = new ArrayDeque<>();

        String word = sc.nextLine();
        int len = word.length();
        int half = len / 2;
        char[] chars = word.toCharArray();
        
        for(int i = 0; i < half; i ++){
            queue.add(chars[i]);
        }

        for(int i = 0; i < half; i ++){
            if(queue.poll() != chars[len - 1 - i]) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }
}