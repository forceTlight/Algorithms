package 프로그래머스;

class 광물_캐기 {
    static boolean[] visited;
    static int[] picks;
    static String[] minerals;
    static int answer = Integer.MAX_VALUE;

    public static void main(String args[]){
        System.out.println(solution(new int[]{0,1,1}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}));
    }

    // 곡괭이는 종류에 상관없이 광물 5개를 캔 후는 더 이상 사용할 수 없음
    // 한번 사용하기 시작한 곡괭이는 사용할 수 없을 때까지 사용함
    // 다이아몬드 > 철 > 돌
    // picks => 0 - dia, 1 - iron, 2 - stone
    // mineral => diamond, iron, stone
    public static int solution(int[] pi, String[] mi) {
        int solutionAnswer = 0;
        minerals = mi;

        int sum = 0;
        for(int i = 0; i < 3; i++)
            sum += pi[i];

        picks = new int[sum];
        int idx = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < pi[i]; j++)
                picks[idx++] = i;
        }

        visited = new boolean[picks.length];

        dfs(0, 0, 0, 0, 0);

        return answer;
    }

    // count -> 곡괭이 횟수, sum -> 피로도 총 합, idx -> 광물 카운트, pi -> for문 i
    public static void dfs(int count, int sum, int idx, int depth, int pi){
        // 모든 광물을 다 캤을 경우
        if(idx == minerals.length){
            answer = Math.min(answer, sum);
            return;
        }

        if(count == 5) {
            // 곡괭이를 모두 사용했을 경우
            if(depth == picks.length){
                answer = Math.min(answer, sum);
                return;
            }
            count = 0;
        }

        // 곡괭이가 깨졌을 경우
        if(count == 0){
            for(int i = 0; i < picks.length; i++){
                if(!visited[i]){
                    visited[i] = true;
                    dfs(count+1, sum + getPirodo(picks[i], minerals[idx]), idx+1, depth+1, i);
                    visited[i] = false;
                }
            }
        }else{
            dfs(count+1, sum + getPirodo(picks[pi], minerals[idx]), idx+1, depth, pi);
        }
    }

    // 곡괭이, 광물을 보고 피로도를 계산해주는 메서드
    public static int getPirodo(int pickNum, String material){
        if(material.equals("stone")){
            return 1;
        }else if(material.equals("iron")){
            if(pickNum == 2)
                return 5;
            else
                return 1;
        }else{
            if(pickNum == 0)
                return 1;
            else if(pickNum == 1)
                return 5;
            else
                return 25;
        }
    }
}