package questions.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 양과늑대
 */
public class 양과늑대 {
    private static ArrayList<Integer>[] tree;

    public void execute(){
        //각 트리 인덱스의 양과 늑대 여부 0 - 양, 1 늑대
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};

        
        buildTree(info, edges);

        int answer = 0;

        ArrayDeque<Information> infoQueue = new ArrayDeque<>();
        infoQueue.add(new Information(0, 1, 0, new HashSet<>()));


        while (!infoQueue.isEmpty() ) {
            
            Information now = infoQueue.pollFirst();

            answer = Math.max(answer, now.sheepCount);

            ArrayList<Integer> nextNodeIndexes = tree[now.nodePosition];
            now.visitedNodes.addAll(nextNodeIndexes);

            for (int next : now.visitedNodes) {

                HashSet<Integer> copySet = new HashSet<>(now.visitedNodes);
                copySet.remove(next);
                
                //다음 노드가 늑대일때
                if(info[next] == 1){
                    if(now.sheepCount > now.wolfCount + 1){
                        infoQueue.add(new Information(next, now.sheepCount, now.wolfCount + 1 , copySet));
                    }
                }else{
                    infoQueue.add(new Information(next, now.sheepCount + 1, now.wolfCount, copySet));
                }
            }
        }

        System.out.println(answer);
        
    }

    private static void buildTree(final int[] info, final  int[][] edges){
        tree = new ArrayList[info.length];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
    }

    private static class Information{
        int nodePosition;
        int sheepCount;
        int wolfCount;
        HashSet<Integer> visitedNodes;

        public Information(
            int nodePosition,
            int sheepCount,
            int wolfCount,
            HashSet<Integer> visitedNodes
        ){
            this.nodePosition = nodePosition;
            this.sheepCount = sheepCount;
            this.wolfCount = wolfCount;
            this.visitedNodes = visitedNodes;
        }
    }
    
}