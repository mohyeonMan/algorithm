package questions.programmers;

/*
    board	skill	result
    [[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5]]	[[1,0,0,3,4,4],[1,2,0,2,3,2],[2,1,0,3,1,2],[1,0,1,3,3,1]]	10
    [[1,2,3],[4,5,6],[7,8,9]]	[[1,1,1,2,2,4],[1,0,0,1,1,2],[2,2,0,2,0,100]]	6

    [type, r1, c1, r2, c2, degree]
 */
public class 파괴되지_않은_건물 {

    public void solution() {
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        // int[][] board = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        // int[][] skill = {{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}};

        //누적합 계산할 배열. x+1 y+1 을 할거라서 1씩 키운 크기로.
        int[][] df = new int[board.length + 1][ board[0].length + 1];

        for (int[] arr : skill) {
            int type = arr[0];
            int startY = arr[1];
            int startX = arr[2];
            int endY = arr[3];
            int endX = arr[4];
            int degree = type==1?arr[5] * -1 : arr[5];

            df[startY][startX] += degree;
            df[endY + 1][startX] -= degree;
            df[startY][endX + 1] -= degree;
            df[endY + 1][endX +1] += degree;

        }

        //df x값 채우기
        for(int y = 0; y < board.length; y++){
            for (int x = 1; x < board[0].length; x++) {
                df[y][x] += df[y][x-1];
            }
        }

        //y값 채우기.
        for(int y = 1; y < board.length; y++){
            for (int x = 0; x < board[0].length; x++) {
                df[y][x] += df[y-1][x] ;
            }
        }

        int answer = 0;

        //board와 df 합산하여 값 도출
        for(int y = 0; y < board.length; y++){
            for (int x = 0; x < board[0].length; x++) {
                if(board[y][x] + df[y][x] > 0){
                    answer ++;
                }
            }
        }

        System.out.println(answer);

    }


}