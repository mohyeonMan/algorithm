package questions.programmers;

import java.util.HashMap;
import java.util.Map;

/*
 * info	n	m	result
[[1, 2}, {2, 3}, {2, 1]]	4	4	2
[[1, 2}, {2, 3}, {2, 1]]	1	7	0
[[3, 3}, {3, 3]]	7	1	6
[[3, 3}, {3, 3]]	6	1	-1
 */
public class 완전_범죄 {
    int[][] info;
    int len;
    int answer;
    Map<String, Integer> memo;
    
    public void solution(){

        int[][] info = {{3, 3}, {3, 3}};
        int n = 6;
        int m = 1;

        this.info = info;
        this.len = info.length;
        this.answer = Integer.MAX_VALUE;
        this.memo = new HashMap<>();

        dfs(0, n, m,0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    private void dfs(int idx, int curn, int curm, int cost){
        if(cost > answer) return;
        if(idx == len){
            answer = Math.min(answer, cost);
            return;
        }

        String key = idx + "_" + curn + "_" + curm;
        if (memo.containsKey(key) && memo.get(key) <= cost) {
            return;
        }
        memo.put(key, cost);

        int a = info[idx][0];
        int b = info[idx][1];

        if(curm - b > 0){
            dfs(idx + 1, curn, curm - b,cost);
        }

        if(curn - a > 0){
            dfs(idx + 1, curn - a, curm, cost+a);
        }

    }

}
