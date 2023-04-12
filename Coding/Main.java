
class Main {
    public static void main(String args[]){
        Solution solution = new Solution();
        int[] answer = solution.solution("ABABABABABABABAB");
        for(int a : answer)
            System.out.print(a + " ");
    }
}