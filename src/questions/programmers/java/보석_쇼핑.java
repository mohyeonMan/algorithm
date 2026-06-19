package questions.programmers;

import java.util.*;

/* 
    https://school.programmers.co.kr/learn/courses/30/lessons/67258
    gems	result
    ["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]	[3, 7]
    ["AA", "AB", "AC", "AA", "AC"]	[1, 3]
    ["XYZ", "XYZ", "XYZ"]	[1, 1]
    ["ZZZ", "YYY", "NNNN", "YYY", "BBB"]	[1, 5]
 */
public class 보석_쇼핑 {

    public void solution() {

        final String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };

        long gemCount = Arrays.stream(gems).distinct().count();

        // 현재 구간 내의 보석들을 포함.
        Map<String, Integer> gemCountMap = new HashMap<>();
        // 초기화
        int left = 0, right = 0, minLength = Integer.MAX_VALUE;
        int start = 0, end = 0;

        while (right < gems.length) {
            gemCountMap.put(gems[right], gemCountMap.getOrDefault(gems[right], 0) + 1);
            right++;

            // 모든 보석이 포함되어 있을 경우, start를 한칸씩 이동하며 minLength를 줄여나간다.
            while (gemCountMap.size() == gemCount) {
                if (right - left < minLength) { // 현재 구간이 가장 짧은 경우
                    minLength = right - left; // 구간 길이 갱신
                    start = left + 1; // 구간 시작지점 갱신
                    end = right; // 구간 종료지점 갱신
                }

                // 계산이 끝난 left의 값을 정리.
                gemCountMap.put(gems[left], gemCountMap.get(gems[left]) - 1);
                if (gemCountMap.get(gems[left]) == 0) {
                    gemCountMap.remove(gems[left]);
                }

                // left 한칸 이동
                left++;
            }
        }

        int[] answer = { start, end };

        System.out.println(Arrays.toString(answer));

    }

}
