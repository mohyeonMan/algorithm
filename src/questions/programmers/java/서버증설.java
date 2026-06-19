package questions.programmers;

import java.util.HashMap;
import java.util.Map;

/*
 * players	m	k	result
{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5}	3	5	7
{0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0}	5	1	11
{0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1}	1	1	12
 */
public class 서버증설 {
    Map<Integer,Integer> servers;
    int K;
    int M;
    int answer;

    public void solution(){

        int[] players = {0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1};
        int m = 1;
        int k = 1;

        servers = new HashMap<>();
        K = k;
        M = m;
        answer = 0;

        for (int time = 0; time < 24; time ++){
            servers.put(time, 1);
        }

        for (int time = 0; time < 24; time ++){
            int cur = servers.get(time);
            int coverage = cur * M -1 ;
            int users = players[time];

            if(coverage < users){
                int required = (int)(Math.ceil((double)(users - coverage) / M));
                addServer(time, required);
                answer += required;
            }
        }

        System.out.println(answer);
    }

    private void addServer(int time, int required){
        for(int i = 0; i < K; i++){
            int target = time + i;
            if(target >= 24) return;
            
            servers.put(target, servers.get(target) + required);
        }
    }

}
