import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        int n;
        ArrayList<String> fileList = new ArrayList<>();
        Comparator<String> comparator = String::compareTo;
        Map<String, Integer> extensionMap = new TreeMap<>(comparator);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        // 1. 저장
        for(int i = 0; i < n; i++){
            String fileName = br.readLine();
            fileList.add(fileName);
        }

        // 2. 확장자 분리하기
        for(int i = 0; i < n; i++){
            String test = fileList.get(i);
            String extension = fileList.get(i).split("\\.")[1];
            //3. Map에 저장
            if(extensionMap.containsKey(extension)){
                int cnt = extensionMap.get(extension);
                extensionMap.put(extension, cnt+1);
            }else{
                extensionMap.put(extension, 1);
            }
        }

        // 4. 확장자 이름 순으로 출력
        for (Map.Entry<String, Integer> entry: extensionMap.entrySet()){
            String extension = entry.getKey();;
            int cnt = entry.getValue();
            bw.write(extension + " " + cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
