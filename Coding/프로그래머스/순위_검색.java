package 프로그래머스;

import java.util.*;

class 순위_검색 {
    static HashMap<String, ArrayList<Integer>> hashMap;
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        hashMap = new HashMap<>();
        
        for(int i = 0; i < info.length; i++){
            String[] infos = info[i].split(" ");
            dfs(infos, "", 0);
        }
        
        // 정렬
        for(String key : hashMap.keySet()){
            ArrayList<Integer> list = hashMap.get(key);
            Collections.sort(list);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < query.length; i++){
            String q = query[i];
            q = q.replaceAll(" and ", " ");
            
            String[] queries = q.split(" ");
            sb.setLength(0);
            
            for(int j = 0; j < 4; j++){
                sb.append(queries[j]);
            }
            
            ArrayList<Integer> list = hashMap.get(sb.toString());
            int score = Integer.parseInt(queries[4]);
            
            if(list == null){
                answer[i] = 0;
                continue;
            }
            
            int count = binarySearch(list, score);
            answer[i] = count;
        }
        
        return answer;
    }
    
    public static void dfs(String[] infos, String key, int depth){
        if(depth == 4){
            if(!hashMap.containsKey(key)){
                hashMap.put(key, new ArrayList<>());
            }
            
            ArrayList<Integer> list = hashMap.get(key);
            int score = Integer.parseInt(infos[4]);
            list.add(score);
            
            hashMap.put(key, list);
            return;
        }
        
        dfs(infos, key + '-', depth+1);
        dfs(infos, key + infos[depth], depth+1);
    }
    
    // lower-bound
    public static int binarySearch(ArrayList<Integer> list, int num){
        int left = 0;
        int right = list.size() - 1;
        
        while(left <= right){
            int mid = (left + right) / 2;
            if(list.get(mid) < num){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        return list.size() - left;
    }
}