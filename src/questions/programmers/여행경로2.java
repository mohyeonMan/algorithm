package questions.programmers;

import java.util.*;

/*
 * tickets	return
[["ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
[["ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
 */
public class 여행경로2 {
    int len;
    boolean[] visited;
    String[][] tickets;
    String[] answer;

    public void solution(){

        String[][] tickets = {{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}};
        
        this.tickets = tickets;
        len = tickets.length;
        visited = new boolean[len];

        //[1] 순으로 정렬.
        Arrays.sort(tickets, Comparator.comparing(ticket -> ticket[1]));

        dfs("ICN", 0, new ArrayList<>(List.of("ICN")));

        System.out.println(Arrays.toString(answer));
    }

    private boolean dfs(String cur, int count, List<String> path){
        
        if(count >= len){
            answer = path.toArray(new String[path.size()]);
            return true;
        }
        
        for(int i=0;i<len;i++){
            if(!visited[i] && tickets[i][0].equals(cur)){
                visited[i] = true;
                path.add(tickets[i][1]);
                if(dfs(tickets[i][1], count+1, path)){
                    return true;
                };
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }

        return false;
    }
}
