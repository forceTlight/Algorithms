import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Gear {
    public int gear[];
    // 시계 방향
    Gear(int gear[]){
        this.gear = gear;
    }
    public void clockwise() {
        int[] gear_tmp = gear.clone();
            for (int i = 1; i < 7; i++) {
                gear[i] = gear_tmp[i-1];
            }
            gear[0] = gear_tmp[7];
    }
    // 반시계 방향
    public void counterClockwise() {
        int[] gear_tmp = gear.clone();
        for (int i = 1; i < 8; i++) {
            gear[i-1] = gear_tmp[i];
        }
        gear[7] = gear_tmp[0];
    }
    public void checkMove(String direct, int rotate, Integer num){ // rotate : -1 - 반시계, '' 1 - 시계 방향
        if(direct.equals("left")){
            if(num != gear[6]){
                if(rotate == -1){
                    clockwise();
                }else if(rotate == 1){
                    counterClockwise();
                }
            }
        }else if(direct.equals("right")){
            if(num != gear[2]){
                if(rotate == -1){
                    clockwise();
                }else if(rotate == 1){
                    counterClockwise();
                }
            }
        }
    }
    public int getScore(int num){
        if(gear[0] == 0){
            return 0;
        }else{
            return (int) Math.pow(2, num);
        }
    }
}

public class Main {
    static int gear[];
    static ArrayList<Gear> gearList = new ArrayList<>();
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            gear = new int[8];
            String input = bf.readLine();
            for (int j = 0; j < 8; j++) {
                gear[j] =  Character.getNumericValue(input.charAt(j));
            }
            gearList.add(new Gear(gear));
        }

        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            String input = bf.readLine();
            String[] inputs = input.split(" ");
            int gn = Integer.parseInt(inputs[0]);
            int rotation = Integer.parseInt(inputs[1]);
            rotate(gn, rotation);
        }
        System.out.println(getScore());
    }

    public static void rotate(int gn, int rotation) {
        gn = gn-1;
        for(int i = gn; i < 3; i++){ // 오른쪽
            Gear gear = gearList.get(i);
            int num = gear.gear[2];
            gearList.get(i+1).checkMove("left", rotation, num);
        }
        for(int i = gn; i > 0; i--){ // 왼쪽
            Gear gear = gearList.get(i);
            int num = gear.gear[6];
            gearList.get(i-1).checkMove("right", rotation, num);
        }
        if(rotation == -1){
            gearList.get(gn).counterClockwise();
        }else{
            gearList.get(gn).clockwise();
        }
    }
    public static int getScore(){
        int score = 0;
        for(int i = 0; i < 4; i++){
            score += gearList.get(i).getScore(i);
        }
        return score;
    }
}
