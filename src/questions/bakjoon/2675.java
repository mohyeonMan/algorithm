import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            
            String[] split = sc.nextLine().split(" ");
            int R = Integer.parseInt(split[0]);
            String S = split[1];

            for(char c : S.toCharArray()){
                for(int i = 0; i<R ; i++){
                    sb.append(c);
                }
            }

            System.out.println(sb.toString());
            sb.delete(0, sb.length());
        }
        
    }
}