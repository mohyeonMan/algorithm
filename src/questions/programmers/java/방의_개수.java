package questions.programmers;

import java.util.HashSet;
import java.util.Set;

public class 방의_개수 {
    public void solution(){
        int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};

        int[] offsetX = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] offsetY = {1, 1, 0, -1, -1, -1, 0, 1};

        int answer = 0;
        int x = 0, y = 0;

        Set<String> nodes = new HashSet<>();
        nodes.add(getNodeKey(x, y));
        Set<String> edges = new HashSet<>();

        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) { // 해상도 두배
                int nx = x + offsetX[arrow];
                int ny = y + offsetY[arrow];
                String edge = getEdgeKey(x, y, nx, ny); 
                String reverseEdge = getEdgeKey(nx, ny, x, y);
                String node = getNodeKey(nx, ny);

                if (!edges.contains(edge)) {
                    if (nodes.contains(node)) {
                        answer++;
                    }
                    edges.add(edge);
                    edges.add(reverseEdge);
                }
                nodes.add(node);
                x = nx;
                y = ny;
            }
        }

        System.out.println(answer);
    }

    private String getNodeKey(int x, int y) {
        return x + "_" + y;
    }

    private String getEdgeKey(int x1, int y1, int x2, int y2) {
        return x1 + "_" + y1 + "_" + x2 + "_" + y2;
    }
}
