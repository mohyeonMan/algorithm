import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] baskets = new int[n+1];
        for(int i = 0;i<baskets.length;i++){
            baskets[i] = i;
        }
        
        while(m-- > 0){
            int i = sc.nextInt();
            int j = sc.nextInt();
            if(i == j) continue;

            int rep = (j - i + 1) /2;

            while(rep-- > 0){
                int t = baskets[i];
                baskets[i] = baskets[j];
                baskets[j] = t;
                
                i ++;
                j --;
            }
        }
        
        for(int i =1; i<baskets.length; i++){
            System.out.print(baskets[i]+" ");
        }
    }
}