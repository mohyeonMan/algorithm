package questions.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    n개의 좌표가 있음. n는 1~n까지 각각 다른 번호를 가짐.
    x대의 로봇이 각 m개의 포인트로 된 경로가 존재. 순서대로 방문.
    y값 먼저 움직임.

    map으로 다음좌표 모으고, 한턴마다 values가 2이상인 갯수 를 더하면 될듯?
    points 를 Map<Integer,int[]> 로 가지고있어야할듯.

    points	routes	result
    [[3, 2], [6, 4], [4, 7], [1, 4]]	[[4, 2], [1, 3], [2, 4]]	1
    [[3, 2], [6, 4], [4, 7], [1, 4]]	[[4, 2], [1, 3], [4, 2], [4, 3]]	9
    [[2, 2], [2, 3], [2, 7], [6, 6], [5, 2]]	[[2, 3, 4, 5], [1, 3, 4, 5]]	0
 */
public class 충돌위험_찾기{

    public void solution() {

        int[][] points = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] routes = {{4, 2}, {1, 3}, {4, 2}, {4, 3}};

        List<Robot> robots = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            int robotId = i;
            int currentPointIndex = routes[i][0] - 1;
            robots.add(new Robot(robotId, Arrays.copyOf(points[currentPointIndex],2)));
        }

        int answer = 0;

        while(!robots.stream().allMatch(r -> r.arrived)){

            Map<String,Integer> siteMap = new HashMap<>();
            for (Robot robot : robots) {
                if(!robot.arrived){
                    int robotId = robot.robotId;
                    int stopIndex = robot.stopIndex;
                    int pointIndex = routes[robotId][stopIndex] - 1;
                    int[] goal = points[pointIndex];
                    robot.move(goal);
                    if(robot.current[0] == goal[0] && robot.current[1] == goal[1]){
                        if(stopIndex + 1 < routes[robotId].length) robot.stopIndex += 1;
                        else robot.arrived = true;
                    }

                    String currentSiteKey = Arrays.toString(robot.current);

                    int currentSiteCount = siteMap.getOrDefault(currentSiteKey, 0);
                    siteMap.put(currentSiteKey, currentSiteCount + 1);
                }
                
            }
            answer += siteMap.values().stream().filter(v -> v > 1 ).count();

        }

        System.out.println(answer);

        

    }

    class Robot{
        int robotId;
        int stopIndex = 0;
        int[] current;
        boolean arrived;

        public Robot(int robotId, int[] current){
            this.robotId = robotId;
            this.current = current;
        }

        public void move(int[] goal) {
            if (current[0] != goal[0]) {
                if (goal[0] - current[0] > 0) current[0] += 1;
                else current[0] -= 1;
            } else if (current[1] != goal[1]) {
                if (goal[1] - current[1] > 0) current[1] += 1;
                else current[1] -= 1;
            }
        }
    }
}
