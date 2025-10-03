import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Queue<Integer> queue = new PriorityQueue<>();
        while(sc.hasNextInt()){
            queue.add(sc.nextInt());
        }
        
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        
    }
}