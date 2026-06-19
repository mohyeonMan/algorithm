package questions.programmers;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
* land	result
{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}}	9
{{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}}	16
*/
public class 석유_시추 {
    int w;
    int h;
    int[][] land;
    int[] offsetX = { -1, 0, 1, 0 };
    int[] offsetY = { 0, -1, 0, 1 };
    Map<Integer, Integer> columnMap;
    boolean[][] visited;

    public int solution() {

        int[][] land = {
                { 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 0, 0 },
                { 1, 1, 0, 0, 0, 1, 1, 0 },
                { 1, 1, 1, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 0, 0, 0, 1, 1 } };
        // int[][] land = {{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1},
        // {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1,
        // 1}};

        w = land[0].length;
        h = land.length;
        this.land = land;

        columnMap = new HashMap<>();
        for (int i = 0; i < w; i++) {
            columnMap.put(i, 0);
        }

        visited = new boolean[h][w];

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (land[y][x] == 1 && !visited[y][x]) {

                    int count = 0;
                    Set<Integer> visitedCol = new HashSet<>();
                    Queue<int[]> bfsQueue = new LinkedList<>();

                    bfsQueue.add(new int[] { y, x });
                    visited[y][x] = true;

                    while (!bfsQueue.isEmpty()) {
                        int[] cur = bfsQueue.poll();
                        int cy = cur[0];
                        int cx = cur[1];

                        count++;
                        visitedCol.add(cx);

                        for (int i = 0; i < 4; i++) {
                            int ny = cy + offsetY[i];
                            int nx = cx + offsetX[i];

                            if (isValid(nx, ny) && land[ny][nx] == 1 && !visited[ny][nx]) {
                                bfsQueue.add(new int[] { ny, nx });
                                visited[ny][nx] = true;
                            }
                        }
                    }

                    for (int col : visitedCol) {
                        columnMap.put(col, columnMap.get(col) + count);
                    }
                }
            }
        }

        return Collections.max(columnMap.values());
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < w && y < h;
    }
}
