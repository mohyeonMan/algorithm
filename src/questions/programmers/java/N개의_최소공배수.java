package questions.programmers;

/*
 * arr	result
[2,6,8,14]	168
[1,2,3]	6
 */
public class N개의_최소공배수 {
    
    public int solution(){

        int[] arr = {2,6,8,14};

        int max = 0;
        for (int i : arr) {
            max = Math.max(max,i);
        }

        int answer = max;

        while(true){
            int checked = 0;
            for (int i : arr) {
                if(answer % i != 0) break;
                checked++; 
            }

            if(checked == arr.length) {
                System.out.println(answer);
                return answer;
            }
            answer += max;
        }

        
    }
}
