import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        
        String S = sc.nextLine();
        int[] alps = new int['z' - 'a' + 1];

        Arrays.fill(alps,-1);

        for(int i = S.length()-1; i >= 0; i--){
            alps[(int)S.charAt(i) - 'a'] = i;
        }
        
        for(int index : alps){
            System.out.print(index + " ");
        }
        
        // 97 - 122

        
    }
}