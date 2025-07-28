import java.io.IOException;
import java.util.*;
/*
 * 5597 - 과제 안 내신 분..?
 */
class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);
        int n = 28;

        int[] students = new int[31]; 
        while(n-- > 0 ){
            int student  = sc.nextInt();
            students[student] = 1;
        }

        for(int i = 1; i<= 30; i++){
            if(students[i] != 1  )
            System.out.println(i);
        }

    
    }
}