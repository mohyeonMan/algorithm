import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = n;
        
        while(n-- > 0){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<count; i++){
                sb.append(i>=n? "*":" ");
            }
            System.out.println(sb.toString());
        }
    }
}