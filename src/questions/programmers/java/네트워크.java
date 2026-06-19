package questions.programmers;

/*
 * n	computers	return
3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
 */
public class 네트워크 {
    boolean[] visited;
    int[][] computers;
    int n;
    
    public void solution(){
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        this.n = n;
        this.computers = computers;
        this.visited = new boolean[n];
        
        int answer = 0;

        for(int i = 0;i<n;i++){
            if(!visited[i]) {
                answer ++;
                bfs(i);
            }
        }
        System.out.println(answer);
        
    }

    private void bfs(int cur){
        visited[cur] = true;

        for(int i = 0; i< n;i++){
            if(computers[cur][i] == 1 && !visited[i]){
                bfs(i);
            }
        }
        
        return;

    }
}
