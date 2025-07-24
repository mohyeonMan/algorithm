import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);
        
        int max = -1;
        int index = -1;
        for(int i = 1; i<=9; i++){
          int v = sc.nextInt();
            
            if(max < v){
                max = v;
                index = i;
            }
        }
        System.out.println(max);
        System.out.println(index);
    }
}