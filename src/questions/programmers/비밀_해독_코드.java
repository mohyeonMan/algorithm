package questions.programmers;

import java.util.ArrayList;
import java.util.List;

/*
 * n	q	ans	result
10	[[1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7]]	[2, 3, 4, 3, 3]	3
15	[[2, 3, 9, 12, 13}, {1, 4, 6, 7, 9}, {1, 2, 8, 10, 12}, {6, 7, 11, 13, 15}, {1, 4, 10, 11, 14]]	[2, 1, 3, 0, 1]	5
 */
public class 비밀_해독_코드 {
    int N;
    int[][] Q;
    int[] ANS;
    int answer;

    public void solution(){

        int n = 10;
        int[][] q = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}};
        int[] ans = {2, 3, 4, 3, 3};

        N = n;
        Q = q;
        ANS = ans;
        answer = 0;

        dfs(0, new ArrayList<>());

        System.out.println(answer);
        
    }

    private void dfs(int start, List<Integer> list){
        if(list.size() == 5){
            if(check(list)) answer ++;
            return;
        }

        for(int i = start; i< N;i++){
            list.add(i + 1);
            dfs(i + 1, list);
            list.remove(list.size()-1);
        }

    }

    private boolean check(List<Integer> list){
        
        for(int i = 0; i< Q.length;i++){
            int count = 0;
            
            for(int j = 0; j < 5; j++){
                if(list.contains(Q[i][j])) count++; 
            }
            
            if(count != ANS[i]) return false;
        }
        return true;
    }
    
}