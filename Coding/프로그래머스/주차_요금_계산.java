package 프로그래머스;

import java.util.*;

class 주차_요금_계산 {
    static int defaultTime;
    static int defaultFee;
    static int staticMinute;
    static int staticFee;
    static HashMap<String, Integer> timeMap;
    static HashMap<String, Integer> feeMap;

    public int[] solution(int[] fees, String[] records) {
        this.timeMap = new HashMap<>();
        this.feeMap = new HashMap<>();
        HashMap<String, Integer> carMap = new HashMap<>();
        ArrayList<String> numberList = new ArrayList<>();
        
        this.defaultTime = fees[0];
        this.defaultFee = fees[1];
        this.staticMinute = fees[2];
        this.staticFee = fees[3];
        
        for(int i = 0; i < records.length; i++){
            String record = records[i];
            String[] inputs = record.split(" ");
            
            String time = inputs[0];
            String number = inputs[1];
            String status = inputs[2];
            
            if(!numberList.contains(number))
                numberList.add(number);
            
            if(status.equals("IN")){
                int totalMinute = getTotalMinute(time);
                carMap.put(number, totalMinute);
            }else{
                int joinTime = carMap.get(number);
                carMap.remove(number);
                int diffTime = getTotalMinute(time) - joinTime;
                int carTime = timeMap.getOrDefault(number, 0);
                timeMap.put(number, diffTime + carTime);
                
                // getFee(number, diffTime);
            }
        }
        
        for(String number : carMap.keySet()){
            int diffTime = getTotalMinute("23:59") - carMap.get(number);
            timeMap.put(number, timeMap.getOrDefault(number, 0) + diffTime);
        }
        
        
        Collections.sort(numberList);
        int[] answer = new int[numberList.size()];
        
        // 계산하기
        for(int i = 0; i < numberList.size(); i++){
            // System.out.println(numberList.get(i));
            answer[i] = getFee(numberList.get(i));
        }
        
        return answer;
    }
    
    public int getTotalMinute(String time){
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    // static int defaultTime;
    // static int defaultFee;
    // static int staticMinute;
    // static int staticFee;
    public int getFee(String number){ // diffTime은 들어갔다가 나오는 시간
        int carFee = 0;
        
        int carTime = timeMap.getOrDefault(number, 0);  
        // System.out.println(carTime);
        if(carTime <= defaultTime){
            carFee = defaultFee;
        }else{
            carTime -= defaultTime;
            int fee = defaultFee + carFee + (int) Math.ceil((double) carTime / staticMinute) * staticFee;
            carFee = fee;
        }
        
        return carFee;
    }
}