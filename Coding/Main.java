class Main {
    public static void main(String args[]){
        String answer = solution("ABC",new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"});
        System.out.println(answer);
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "";

        m = m.replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f")
                .replaceAll("G#", "g").replaceAll("A#", "a");

        for(int i = 0; i < musicinfos.length; i++){
            String[] music = musicinfos[i].split(",");
            String startTime = music[0];
            String endTime = music[1];
            String title = music[2];
            String song = music[3];

            // replace
            song = song.replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f")
                    .replaceAll("G#", "g").replaceAll("A#", "a");

            int diff = getDiffMinute(startTime, endTime);
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
                if(answer.length() < title.length()){
                    answer = title;
                }
            }
        }
        if(answer == "")
            answer = "(None)";

        return answer;
    }

    public static int getDiffMinute(String startTime, String endTime){
        String[] startTimes = startTime.split(":");
        String[] endTimes = endTime.split(":");

        int st = Integer.parseInt(startTimes[0]) * 60 + Integer.parseInt(startTimes[1]);
        int ed = Integer.parseInt(endTimes[0]) * 60 + Integer.parseInt(endTimes[1]);

        return ed - st;
    }
}