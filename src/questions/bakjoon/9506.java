import java.io.IOException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        while(n != -1){
            sb.append(n);
            
            int sum = 1;
            int rep = (int)Math.floor(Math.sqrt(n));
            
            List<Integer> t = new ArrayList<>();
            t.add(1);
            
            for(int i = 2; i <= rep; i++){
                if(n % i == 0){
                    int d = n/i;
                    t.add(i);
                    t.add(d);
                    sum += i;
                    sum += d;
                }
            }
            
            if(sum == n){
                sb.append(" = ");
                
                String s = t.stream()
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" + "));
                
                sb.append(s);
            }else{
                sb.append(" is NOT perfect.");
            }

            System.out.println(sb.toString());
            sb.delete(0, sb.length());
            n = sc.nextInt();
        }
    }
}