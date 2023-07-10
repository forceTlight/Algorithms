package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 20546 - 기적의 매매법
 * 문제유형 : 구현
 * 난이도 : SILVER 5
 * 풀이시간 : 20분
 */

// 준현이는 주식을 살 수 있다면, 무조건 최대한 많이 산다.
// 성민이는 전량 매수와 전량 매도로 이루어진다.
// 성민이는 현재 소유한 주식 가격이 3일째 상승한다면, 전량 매도한다. 만약, 전일과 오늘의 주가가 동일하다면 상승한 것이 아니다.
// 성민이는 현재 소유한 주식 가격이 3일짜 하락한다면, 즉시 주식을 전량 매수한다. 만약, 전일과 오늘의 주가가 동일하다면 하락한 것이 아니다.
// 1월 14일의 자산은 (현금 + 1월 14일의 주가 x 주식 수)로 계산한다.
// 준현이의 자산이 더 크면 "BNP"를, 성민이의 자산이 더 크다면 "TIMING"을 출력한다. 둘의 자산이 같으면 "SAMESAME"을 출력한다.

public class _20546_기적의_매매법 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());

        int junMoney = money;
        int junStock = 0;

        int seongMoney = money;
        int seongStock = 0;
        int prevStock = 0;
        int raiseDay = 0;
        int fallDay = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 13; i++) {
            int stockPrice = Integer.parseInt(st.nextToken());

            while (junMoney - stockPrice >= 0) {
                junStock++;
                junMoney -= stockPrice;
            }

            // 전날 거래를 비교해 상승, 하락했는지 알아내야됨
            if (prevStock != 0) {
                if (prevStock < stockPrice) { // 상승
                    raiseDay++;
                    fallDay = 0;
                } else if (prevStock > stockPrice) { // 하락
                    raiseDay = 0;
                    fallDay++;

                } else { // 동일할 때
                    raiseDay = 0;
                    fallDay = 0;
                }
            }

            // 연속 3거래일 상승했는지 비교 -> 상승시 전량매도
            if (raiseDay == 3) {
                while (seongStock >= 1) {
                    seongStock--;
                    seongMoney += stockPrice;
                }
                raiseDay = 0;
            }

            // 연속 3거래일 하락했는지 비교 -> 하락시 전량매수
            if (fallDay == 3) {
                while (seongMoney - stockPrice >= 0) {
                    seongStock++;
                    seongMoney -= stockPrice;
                }
                fallDay = 0;
            }

            prevStock = stockPrice;
        }

        int lastStockPrice = Integer.parseInt(st.nextToken());
        // 모두 전량 매도
        while (seongStock >= 1) {
            seongStock--;
            seongMoney += lastStockPrice;
        }

        while (junStock >= 1) {
            junStock--;
            junMoney += lastStockPrice;
        }

        if(seongMoney > junMoney){
            System.out.println("TIMING");
        }else if(seongMoney < junMoney){
            System.out.println("BNP");
        }else{
            System.out.println("SAMESAME");
        }
    }
}