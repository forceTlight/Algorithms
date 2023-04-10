package 프로그래머스;

import java.util.*;

//C, C#
//D, D#
//F, F#
//G, G#
//A, A#
class 방금_그곡 {
    static class Music implements Comparable<Music>{
        int startTime;
        int endTime;
        String title;
        String song;
        
        public Music(int startTime, int endTime, String title, String song){
            this.startTime = startTime;
            this.endTime = endTime;
            this.title = title;
            this.song = song;
        }
        
        @Override
        public int compareTo(Music music){
            return this.startTime - music.startTime;
        }
    }
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxDiff = Integer.MIN_VALUE;
        
        m = m.replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f")
                .replaceAll("G#", "g").replaceAll("A#", "a");
        
        ArrayList<Music> arrayList = new ArrayList<>();
        for(int i = 0; i < musicinfos.length; i++){
            String[] music = musicinfos[i].split(",");
            int startTime = getMinute(music[0]);
            int endTime = getMinute(music[1]);
            String title = music[2];
            String song = music[3];
            
            arrayList.add(new Music(startTime, endTime, title, song));
        }
        
        Collections.sort(arrayList);

        for(int i = 0; i < arrayList.size(); i++){
            Music music = arrayList.get(i);
            int startTime = music.startTime;
            int endTime = music.endTime;
            String title = music.title;
            String song = music.song;
            
            // replace
            song = song.replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f")
                .replaceAll("G#", "g").replaceAll("A#", "a");

            int diff = endTime - startTime;
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            int pt = 0;
            while(cnt < diff){
                if(pt == song.length())
                    pt = 0;

                sb.append(song.charAt(pt));

                pt++;
                cnt++;
            }

            if(sb.toString().contains(m)){
                if(maxDiff < diff){
                    answer = title;
                    maxDiff = diff;
                }
            }
        }
        if(answer == "")
            answer = "(None)";

        return answer;
    }

    public int getMinute(String time){
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}