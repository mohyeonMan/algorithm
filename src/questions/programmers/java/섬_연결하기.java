package questions.programmers;

import java.util.Arrays;
import java.util.Comparator;

/*
 * n	costs	return
4	[[0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8]]	4
 */
public class 섬_연결하기 {
    int[] parents;
    
    public void solution(){
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        int answer = 0;

        Arrays.sort(costs,Comparator.comparingInt(cost ->cost[2]));

        parents = new int[n];
        for(int i =0;i<n;i++){
            parents[i] = i;
        }

        for(int[] cost : costs){
            int root1 = findRoot(cost[0]);
            int root2 = findRoot(cost[1]);
            if(root1 != root2){
                answer += cost[2];
                parents[root1] = root2;
                n--;
            }
            if(n == 1){
                break;
            }
        }

        System.out.println(answer);

    }

    private int findRoot(int cur){
        if(parents[cur] == cur) return cur;
        return findRoot(parents[cur]);
    }

}
