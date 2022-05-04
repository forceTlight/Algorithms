import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Point{
        int arr[];
        int point[];
        int answer = 0;
        Point(int arr[]){
            this.arr = arr;
            point = new int[arr.length];
        }
        void setArr(int idx, int value){
            arr[idx] = value;
        }
        void swap(int idx1, int idx2){
            int tmp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = tmp;
            caculate(); // 계산
            tmp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = tmp;
        }
        void caculate(){
            int sum = 0;
            for(int i = 0; i < arr.length-1; i++){
                sum += Math.abs(arr[i] - arr[i+1]);
            }
            answer = sum;
        }
    }
    public static void main(String args[]) throws IOException {
        int[] arr;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String input = bf.readLine();
        String[] inputs = input.split(" ");
        arr = new int[inputs.length];
        Point point = new Point(arr);

    }
    public static void solution(Point point){

    }
}
