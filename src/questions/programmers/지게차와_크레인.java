package questions.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/*
    storage	requests	result
    ["AZWQY", "CAABX", "BBDDA", "ACACA"]	["A", "BB", "A"]	11
    ["HAH", "HBH", "HHH", "HAH", "HBH"]	["C", "B", "B", "B", "B", "H"]	4
 */
public class 지게차와_크레인 {

    Map<Character, List<int[]>> coordiMap;
    int n, m;
    boolean[][] boundary;
    boolean[][] removed;
    int[] offsetX = { -1, 0, 1, 0 };
    int[] offsetY = { 0, -1, 0, 1 };

    public void solution() {

        String[] storage = { "AZWQY", "CAABX", "BBDDA", "ACACA" };
        String[] requests = { "A", "BB", "A" };

        coordiMap = new HashMap<>();
        n = storage.length;
        m = storage[0].length();
        boundary = new boolean[n][m];
        removed = new boolean[n][m];

        int answer = n * m;

        // map에 알파벳 별로 모으기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char al = storage[i].charAt(j);
                List<int[]> coordiList = coordiMap.computeIfAbsent(al, k -> new ArrayList<>());
                coordiList.add(new int[] { i, j });
                if (isEdge(i, j))
                    boundary[i][j] = true;
            }
        }

        // 요청 순차적으로 실행
        for (String request : requests) {
            char[] chars = request.toCharArray();
            boolean isCrain = chars.length > 1; // "A" or "AA"

            char al = chars[0];

            List<int[]> coordiList = coordiMap.getOrDefault(al, Collections.emptyList()); // 해당 알파벳 전체.
            List<int[]> targetList;
            if (isCrain) {
                targetList = coordiList;
                coordiMap.remove(al); // 해당 알파벳 삭제
            } else {
                targetList = coordiList.stream().filter(coordi -> {
                    int x = coordi[0];
                    int y = coordi[1];
                    return !removed[x][y] && boundary[x][y]; // 지워지지 않았고, 가장자리에 있는것 특정
                }).collect(Collectors.toList());
                coordiList.removeAll(targetList);
                coordiMap.put(al, coordiList); // targetList뺀 나머지로 갱신
            }

            targetList.forEach(coordi -> outBfs(coordi)); // bfs 실행.

            answer -= targetList.size();

        }

        System.out.println(answer);
    }

    private boolean isEdge(int x, int y) {
        return (x == 0 || x == n - 1 || y == 0 || y == m - 1);
    }

    private boolean isValid(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < m);
    }

    private void outBfs(int[] coordi) {
        int x = coordi[0];
        int y = coordi[1];

        // 일단 removed에서 삭제처리.
        removed[x][y] = true;

        Queue<int[]> bfsQueue = new LinkedList<>(); // bfs 큐
        List<int[]> targetNodes = new ArrayList<>(); // 새로운 가장자리가 될 노드들.
        boolean[][] visited = new boolean[n][m]; // 방문 기록
        boolean isOpened = false; // 외부와 연결 여부.

        bfsQueue.add(coordi);

        while (!bfsQueue.isEmpty()) {
            int[] cur = bfsQueue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int o = 0; o < 4; o++) {
                int nx = cx + offsetX[o];
                int ny = cy + offsetY[o];

                if (!isValid(nx, ny)) {
                    isOpened = true;
                    continue;
                }
                if (visited[nx][ny])
                    continue;

                if (!removed[nx][ny]) {
                    if (!boundary[nx][ny]) {
                        targetNodes.add(new int[] { nx, ny }); // 삭제X, 가장자리x 새로운 가장자리 예정.
                    }
                } else {
                    bfsQueue.add(new int[] { nx, ny }); // 삭제O 데이터들만 queue로 추가.
                }
                visited[nx][ny] = true;
            }

        }

        if (isOpened) { // 삭제된 데이터를 타고간 결과 !isValid에 도달한 경우.
            for (int[] node : targetNodes) {
                boundary[node[0]][node[1]] = true; // 새로운 가장자리로 결정
            }
        }

    }
}
