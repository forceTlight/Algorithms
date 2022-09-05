import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String voiceInput = br.readLine();
        long answer = solution(voiceInput);
        System.out.println(answer);

    }
    public static long solution(String voiceInput){
        List<Duck> duckList = new ArrayList<>();

        // add Duck
        for(int i = 0; i < voiceInput.length(); i++){
            char voice = voiceInput.charAt(i);
            if(!duckList.stream().anyMatch(duck -> duck.checkNextVoice(voice))){
                if(voice == 'q'){
                    duckList.add(new Duck());
                }else{
                    return -1;
                }
            }
        }
        // check errorVoice
        if(duckList.stream().anyMatch(duck -> !duck.isRealDuck))
            return -1;

        // find RealDuck
        long answer = duckList.stream().filter(duck -> duck.isRealDuck).count();
        if(answer == 0)
            answer = -1;
        return answer;
    }

    static class Duck{
        char currentVoice;
        boolean isRealDuck = false;
        Duck(){
            this.currentVoice = 'q';
        }

        public boolean checkNextVoice(char nextVoice){
            switch(currentVoice){
                case 'q':
                    if(nextVoice == 'u'){
                        currentVoice = 'u';
                        return true;
                    }
                    break;
                case 'u':
                    if(nextVoice == 'a'){
                        currentVoice = 'a';
                        return true;
                    }
                    break;
                case 'a':
                    if(nextVoice == 'c'){
                        currentVoice = 'c';
                        return true;
                    }
                    break;
                case 'c':
                    if(nextVoice == 'k'){
                        currentVoice = 'k';
                        isRealDuck = true;
                        return true;
                    }
                    break;
                case 'k':
                    if(nextVoice == 'q'){
                        currentVoice = 'q';
                        isRealDuck = false;
                        return true;
                    }
                    break;
            }
            return false;
        }
    }
}
