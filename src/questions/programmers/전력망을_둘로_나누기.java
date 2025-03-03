package questions.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * n	wires	result
9	[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]	3
4	[[1,2],[2,3],[3,4]]	0
7	[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]	1
 */
public class 전력망을_둘로_나누기 {
    List<Integer>[] nodeArr;
    
    public int solution(){
        
        int n = 9; 
        // int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int[][] wires = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};

        int answer = Integer.MAX_VALUE;

        nodeArr = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            nodeArr[i] = new ArrayList<>();
        }

        for(int[] wire : wires){
            nodeArr[wire[0]].add(wire[1]);
            nodeArr[wire[1]].add(wire[0]);
        }

        
        for(int[] wire : wires){
            int treeSize1 = countTreeSize(wire[0],wire[1]);
            int treeSize2 = n - treeSize1;

            answer = Math.min(Math.abs(treeSize1 - treeSize2), answer);
        }

        System.out.println(answer);
        return answer;
    }

    private int countTreeSize(int root, int other){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[nodeArr.length];
        visited[root] = true;
        queue.add(root);
        
        int count = 0;

        while(!queue.isEmpty()){
            int current = queue.poll();
            count++;

            for(int next : nodeArr[current]){
                if(!visited[next] && next != other){
                    visited[next] = true;
                    queue.add(next);
                }
            }
                        
        }
        return count;

    }

}
