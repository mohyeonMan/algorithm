package questions.programmers;

public class 지폐접기 {
    public int execute(){
        int[] wallet = {50, 50};
        int[] bill = {100, 241};

        int[] sortedWallet = sortToIntArray(wallet[0],wallet[1]);
        int[] sortedBill = sortToIntArray(bill[0],bill[1]);

        return foldTillFitToWallet(sortedWallet, sortedBill, 0);
    }

    public int[] sortToIntArray(int x, int y){

        int longerSide = Math.max(x, y);
        int shorterSide = x == longerSide? y:x;

        return new int[]{longerSide,shorterSide};
    }

    public int[] foldBill(int[] bill){
        int x = bill[0] / 2;
        int y = bill[1];

        return sortToIntArray(x, y);
    }


    public int foldTillFitToWallet(int[] wallet, int[] bill, int times){
        if(
            wallet[0] >= bill[0] &&
            wallet[1] >= bill[1]
        ) return times;

        times ++;
        return foldTillFitToWallet(wallet, foldBill(bill), times);
    }
}
