package 인프런.tree;

public class SegmentTree {
    long[] tree;
    int treeSize;

    public SegmentTree(int arrSize) {
        int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2)); // 트리 높이 구하기
        this.treeSize = (int) Math.pow(2, h + 1); // 높이를 이용해 배열 사이즈 구하기
        tree = new long[treeSize]; // 배열 생성
    }

    // arr = 원소배열, node = 현재노드, start = 현재구간 배열 시작, start = 현재구간 배열 끝
    public long buildTree(int[] arr, int node, int start, int end) {
        // 배열의 시작과 끝이 같으면 leaf 노드
        // 원소 배열 값 그대로 담기
        if (start == end) {
            return tree[node] = arr[start];
        }

        // leaf 노드가 아니면 자식 노드의 합 담기
        return tree[node] = buildTree(arr, node * 2, start, (start + end) / 2) +
                buildTree(arr, node * 2 + 1, (start + end) / 2 + 1, end);
    }

    // node = 현재노드 idx, start = 배열의 시작, end = 배열의 끝
    // idx = 변경된 데이터의 idx, diff = 원래 데이터 값과 변경된 데이터 값의 차이
    public void update(int node, int start, int end, int idx, long diff) {
        // 만약 변경할 index 값이 범위 바깥이면 확인 불 필요
        if (idx < start || end < idx)
            return;

        // 차를 저장
        tree[node] += diff;

        // 리프노드가 아니면 아래 자식들도 확인
        if (start != end) {
            update(node * 2, start, (start + end) / 2, idx, diff);
            update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
        }
    }

    // node = 현재노드, start = 배열의 시작, end = 베열의 끝
    // left = 원하는 누적합의 시작, right = 원하는 누적합의 끝
    public long sum(int node, int start, int end, int left, int right) {
        // 범위를 벗어나게 되는 경우 더할 필요는 없음
        if (left > end || right < start)
            return 0;

        // 범위 내에서 완전히 포함시에는 더 내려가지 않고 바로 리턴
        if (left <= start && end <= right)
            return tree[node];

        return sum(node * 2, start, (start + end) / 2, left, right)
                + sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
    }
}
