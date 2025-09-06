import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        int len = t.length();

        Set<String> cAlps = Set.of("dz=", "z=", "c=", "c-", "d-", "lj", "nj", "s=");

        int answer = 0;
        int cur =0;
        while (cur < len){

            boolean found = false;
            for(int j = 3; j > 1; j --){
                if(cur + j - 1 >= len) continue;
                String part = t.substring(cur, cur + j);
                if(cAlps.contains(part)){
                    answer ++;
                    cur += j ;
                    found = true;
                    
                    break;
                }
            }

            if(found) continue;
            
            cur++;
            answer ++;
        }

        System.out.println(answer);
        
    }

}