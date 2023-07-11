package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 20436 - ZOAC 3
 * 문제유형 : 구현
 * 난이도 : SILVER 4
 * 풀이시간 : 20분
 */
public class _20436_ZOAC_3 {
    static class Point{
        int a;
        int b;

        public Point(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    static char[][] answer;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char leftHandPos = st.nextToken().charAt(0); // 자음
        char rightHandPos = st.nextToken().charAt(0); // 모음

        char[] chArray = {'y','u','i','o','p','h','j','k','l','b','n','m'};
        HashSet<Character> moumSet = new HashSet<>();
        for(int i = 0; i < chArray.length; i++)
            moumSet.add(chArray[i]);

        HashMap<Character, Point> alphabetMap = new HashMap<>();
        init(alphabetMap);

        int answer = 0;

        String input = br.readLine();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);

            Point currentPoint = alphabetMap.get(c);
            int x = currentPoint.a;
            int y = currentPoint.b;

            Point prevPoint;
            // 자음인지 확인
            if(!moumSet.contains(c)){
                prevPoint = alphabetMap.get(leftHandPos);
                leftHandPos = c;
            }else{ // 모음
                prevPoint = alphabetMap.get(rightHandPos);
                rightHandPos = c;
            }

            int a = prevPoint.a;
            int b = prevPoint.b;

            int distance = Math.abs(a - x) + Math.abs(b - y);
            answer += distance + 1;
        }

        System.out.println(answer);
    }

    public static void init(HashMap<Character, Point> hashMap){
        char[][] alphabetArray = {{'q','w','e','r','t','y','u','i','o','p'},{'a','s','d','f','g','h','j','k','l'}, {'z','x','c','v','b','n','m'}};
        for(int i = 0; i < alphabetArray.length; i++){
            for(int j = 0; j < alphabetArray[i].length; j++){
                hashMap.put(alphabetArray[i][j], new Point(i, j));
            }
        }
    }
}