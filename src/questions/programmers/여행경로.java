package questions.programmers;

import java.util.*;

/*
 * tickets	return
[["ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
[["ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
 */
public class 여행경로 {
    Map<String,List<Integer>> apIndexMap;
    String[][] tickets;

    public String[] solution(){

        String[][] tickets = {{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}};

        this.tickets = tickets;

        apIndexMap = new HashMap<>();
        Arrays.sort(tickets, Comparator.comparing((String[] ticket) -> ticket[1]));
        

        for(int i = 0; i<tickets.length;i++){
            String[] ticket = tickets[i];
            apIndexMap.computeIfAbsent(ticket[0], k -> new ArrayList<>()).add(i);
        }

        Queue<Entry> queue = new LinkedList<>();
        queue.add(new Entry("ICN", 0, new boolean[tickets.length],new ArrayList<>(List.of("ICN"))));

        while(!queue.isEmpty()){
            Entry entry = queue.poll();
            int count = entry.count;
            boolean[] visited = entry.visited;
            List<String> aps = entry.aps;

            if(count >= tickets.length) {
                aps.toArray();
                System.out.println(aps.toArray(new String[aps.size()]));
                break;
            }

            for(int idx : apIndexMap.getOrDefault(entry.ap,Collections.emptyList())){
                if(!visited[idx]){

                    String nap = tickets[idx][1];

                    boolean[] vCopy = visited.clone();
                    List<String> apsCopy = new ArrayList<>(aps);
                    vCopy[idx] = true;
                    apsCopy.add(nap);
                    queue.add(new Entry(nap, entry.count+1,vCopy, apsCopy));
                }
            }
            

        }


        return null;

    }

    class Entry{
        String ap;
        int count;
        boolean[] visited;
        List<String> aps;

        Entry(String ap, int count, boolean[] visited, List<String> aps){
            this.ap = ap;
            this.count = count;
            this.visited = visited;
            this.aps = aps;
        }
    }

}
