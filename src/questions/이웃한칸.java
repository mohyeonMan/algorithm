package questions;

public class 이웃한칸 {
    
    public int execute(){

        String[][] board = {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        int h = 1;
        int w = 1;

        String color = board[h][w];
        
        
        int answer = 0;
        answer += color.equals(getColor(board,h, w - 1))? 1:0;
        answer += color.equals(getColor(board,h, w + 1))? 1:0;
        answer += color.equals(getColor(board,h - 1, w))? 1:0;
        answer += color.equals(getColor(board,h + 1, w))? 1:0;
        
        return answer;
    }
    
    public String getColor(String[][] board, int h, int w){
        
        int max = board.length -1;
        
        if(h < 0 || h > max ) return "";
        if(w < 0 || w > max ) return "";
        
        return board[h][w];
        
    }
}
