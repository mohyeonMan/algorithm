import java.io.IOException;
import java.util.*; 

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int l = String.valueOf(n).length();
        int range = l * 9;

        for(int i = Math.max(1, n - range); i < n ; i++){
            int num = i;
            int sum = 0;
            //모든 자릿수를 더함
            while(true){
                sum += num % 10;
                num /= 10;
                if(num == 0) break;
            }
            // i 와 모든 자릿수의 합이 같으면, i는 생성자.
            if(i + sum == n){
                System.out.print(i);
                return;
            }
        }

        //없으면 0
        System.out.print(0);

    }
    
    
}