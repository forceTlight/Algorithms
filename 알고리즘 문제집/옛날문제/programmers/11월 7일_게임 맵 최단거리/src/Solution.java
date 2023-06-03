import java.util.LinkedList;
import java.util.Queue;
/**
 * @Author Neo
 * @Level programmers_level_2
 * @name ���� �� �ִܰŸ�
 * */
//��� Ŭ����
class Node{
	private int idx;
	private int distance;
	
	public Node(int idx, int distance) {
		this.idx = idx;
		this.distance = distance;
	}
	public int getIdx() {
		return this.idx;
	}
	public int getDistance() {
		return this.distance;
	}
}

public class Solution {
	public static int n;
	public static int m;
	// �̵��� �� ���� ���� (��, ��, ��, ��) 
	public static int dx[] = {-1,1,0,0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static void main(String args[]) {
		int maps[][] = {{1,2,3},{1,2,3}};
		System.out.println(solution(maps));
	}
	public static int solution(int[][] maps) {
		 n = maps[0].length;
		 m = maps.length;
		 return bfs(0, 0, maps);
	}
	// �ʺ� �켱 Ž��
	public static int bfs(int x, int y, int[][] maps) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x,y));
		// ť�� �� ������ �ݺ�
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.getIdx();
			y = node.getDistance();
			// ���� ��ġ���� 4���� �������� Ȯ��
			for(int i = 0; i < 4; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				// ���� ��� ��� ����
				if(nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				// ���� ��� ����
				if(maps[nx][ny] == 0)
					continue;
				// �ش� ��� ó�� �湮�ϴ� ��� �ִܰŸ� ���
				if(maps[nx][ny] == 1) {
					maps[nx][ny] = maps[x][y] + 1;
					q.offer(new Node(nx, ny));
				}
			}
		}
		int answer = maps[n-1][m-1];
		if(answer == 1) answer = -1;
		return answer;
	}
}
