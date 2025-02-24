package questions.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * genres	plays	return
    ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
 */
public class 베스트앨범 {
    Map<String,Long> genreCountMap;
    Map<String,PriorityQueue<Song>> songMap;

    public void solution(){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        genreCountMap = new HashMap<>();
        songMap = new HashMap<>();

        for(int i = 0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];

            genreCountMap.put(genre, genreCountMap.getOrDefault(genre, 0L) + play); // 횟수 합산

            /*
                이상 발견!
                Comparator.thenComparing 사용시 새로운 Comparator를 사용하지 않고 reversed()를 체이닝 하니,
                먼저번의 reversed() 에 또다시 reversed()가 적용되어 natural이 되는 현상 발생.
             */
            // PriorityQueue<Song> songQueue = songMap.computeIfAbsent(genre,k -> new PriorityQueue<Song>(
            //         Comparator.comparingInt((Song song) -> song.count).reversed()
            //         .thenComparing((Song song) -> song.id).reversed()
            // ));

            PriorityQueue<Song> songQueue = songMap.computeIfAbsent(genre, k -> new PriorityQueue<>(
                (s1, s2) -> {
                    if (s1.count != s2.count) return Integer.compare(s1.count, s2.count);
                    return Integer.compare(s2.id, s1.id);
                }
            ));

            songQueue.add(new Song(i, play));
            while(songQueue.size() > 2){
                songQueue.poll();
            }
            
        }

        List<Integer> reversedAnswerList = new ArrayList<>();
        genreCountMap.keySet().stream().sorted(Comparator.comparingLong(genreCountMap::get))
            .forEach(genre -> {
                PriorityQueue<Song> songQueue =  songMap.get(genre);
                while(!songQueue.isEmpty()){
                    reversedAnswerList.add(songQueue.poll().id);
                }
            });

        
        int listSize = reversedAnswerList.size();
        int[] answer = new int[listSize];

        for(int i = 0; i< answer.length; i ++){
            answer[i] = reversedAnswerList.get(listSize - 1 - i);
        }

        System.out.println(Arrays.toString(answer));

    }
    

    class Song{
        int id;
        int count;

        public Song(int id, int count){
            this.id = id;
            this.count = count;
        }
    }
}


