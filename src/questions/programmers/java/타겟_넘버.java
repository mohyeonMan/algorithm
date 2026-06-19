package questions.programmers;

/*
 * numbers	target	return
[1, 1, 1, 1, 1]	3	5
[4, 1, 2, 1]	4	2
 */
public class 타겟_넘버 {

    int[] numbers;
    int len;
    int t;
    int answer;

    public void solution(){
        
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        this.numbers = numbers;
        this.len = numbers.length;
        this.t = target;
        this.answer = 0;

        dfs(0, 0);

        System.out.println(answer);
    }
    
    private void dfs(int sum, int index){
        if(index >= len){
            if(sum == t) answer ++;
            return;
        }

        int nxIndex = index + 1;

        dfs(sum + numbers[index], nxIndex);
        dfs(sum - numbers[index], nxIndex);
    }


}
