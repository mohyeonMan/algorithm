package questions.programmers;
/*
    n개의 문제를 제한시간내에 풀어야한다.
    난이도(diff)와 소요시간(time_cur)이 정해져있다.
    숙련도에 따라 틀리는 횟수가 바뀐다.
    이전퍼즐 소요시간 time_prev
    숙련도 level

    diff <= level 이면 틀리지않음. time_cur.
    diff> level 이면 그 차 만큼 틀림. 틀릴때마다 time_cur 소모 time_prev 추가.
    
    diffs	times	limit	result
    [1, 5, 3]	[2, 4, 7]	30	3
    [1, 4, 4, 2]	[6, 3, 8, 2]	59	2
    [1, 328, 467, 209, 54]	[2, 7, 1, 4, 3]	1723	294
    [1, 99999, 100000, 99995]	[9999, 9001, 9999, 9001]	3456789012	39354
 */
public class 퍼즐_게임_챌린지 {

    public void solution(){
        int[] diffs = {1,5,3};
        int[] times = {2,4,7};
        long limit = 30;

        int levelMin = 1;
        int levelMax = 100_000;
        while(levelMin <= levelMax){
            int level = (levelMax + levelMin) / 2;
            if(isPassed(limit, diffs, times, level)) levelMax = level - 1;
            else levelMin = level + 1;
        }

        System.out.println(levelMin);

    }
    

    public boolean isPassed(final long limit, final int[] diffs, final int[] times, final int level){

        int time_prev = 0;
        long totalTimes = 0;

        for (int i = 0; i < times.length; i++) {
            int diff = diffs[i];
            int time_cur = times[i];
            
            if(diff <= level)  totalTimes += time_cur;
            else totalTimes += ((diff - level) * (time_cur + time_prev) + time_cur);  
            
            if(totalTimes > limit) return false;

            time_prev = time_cur;
        }
        return true;
    }
        
}
