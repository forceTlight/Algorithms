package 인프런.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 응급실 {
    static class Patient{
        int index;
        int risk;

        public Patient(int index, int risk){
            this.index = index;
            this.risk = risk;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Patient> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            queue.offer(new Patient(i, Integer.parseInt(st.nextToken())));
        }

        int cnt = 0;
        while(!queue.isEmpty()){
            Patient patient = queue.poll();
            boolean containHigher = queue.stream().anyMatch(p -> p.risk > patient.risk);

            if(containHigher){
                queue.offer(patient);
            }else{
                cnt++;
                if(patient.index == m){
                    System.out.println(cnt);
                    return;
                }
            }
        }
    }
}