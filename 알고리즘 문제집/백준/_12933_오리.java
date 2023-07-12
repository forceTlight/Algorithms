package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 12933 - 오리
 * 문제유형 : 구현
 * 난이도 : SILVER 3
 * 풀이시간 : 1시간
 */
public class _12933_오리 {
    static class Duck {
        char voice;

        public Duck() {
            this.voice = 'q';
        }

        public boolean isDuck(char nextVoice) {
            if (nextVoice == 'q') {
                return voice == 'k';
            } else if (nextVoice == 'u') {
                return voice == 'q';
            } else if (nextVoice == 'a') {
                return voice == 'u';
            } else if (nextVoice == 'c') {
                return voice == 'a';
            } else if (nextVoice == 'k') {
                return voice == 'c';
            }

            return false;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        HashSet<Duck> duckPool = new HashSet<>(); // 울음소리를 모두 다낸 오리들
        LinkedList<Duck> cryDuckPool = new LinkedList<>();

        loop:
        for (int i = 0; i < input.length(); i++) {
            char voice = input.charAt(i);

            if (voice == 'q') {
                if (duckPool.isEmpty()) {
                    cryDuckPool.offer(new Duck());
                } else {
                    Duck duck = duckPool.iterator().next();
                    duckPool.remove(duck);
                    duck.voice = voice;
                    cryDuckPool.offer(duck);
                }
            } else {
                for (Duck d : cryDuckPool) {
                    if (d.isDuck(voice)) {
                        d.voice = voice;

                        if (voice == 'k') {
                            cryDuckPool.remove(d);
                            duckPool.add(d);
                        }
                        continue loop;
                    }
                }

                // 올바른 소리가 아니므로 -1 리턴
                System.out.println(-1);
                return;
            }
        }

        if(cryDuckPool.size() != 0){
            System.out.println(-1);
        }else{
            System.out.println(duckPool.size());
        }
    }
}