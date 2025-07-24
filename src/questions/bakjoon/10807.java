import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());

        Map<String,Long> countMap = Arrays.stream(br.readLine().split(" ")).collect(Collectors.groupingBy(i->i,Collectors.counting()));

        String key = br.readLine();
        bw.write(String.valueOf(countMap.getOrDefault(key, 0L)));
        bw.close();
    }
}