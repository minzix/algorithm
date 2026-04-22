import java.util.*;

class Node2 { // 트리의 한 원소
    int data; // 값
    Node1 left, right; // 왼쪽 자식 노드, 오른쪽 자식노드의 참조값 저장

    public Node2(int val) {
        data = val; // 값은 가지고 생성됨
        left = right = null; // 처음 생성할 때 참조값들은 null로 초기화
    }
}
// 예: Node1 a = new Node1(1); 로 선언하면
// a.left = new Node1(2); 값이 2인 노드를 생성하고 왼쪽노드로 연결한다는 뜻
// a.left.data = 2임

public class Main0703 {
    public static void bfs(Node1 root) { // 본 함수만 다름
        Queue<Node1> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            System.out.print(level + " : "); // level이 거리임

            for (int i = 0; i < levelSize; i++) {
                Node1 current = queue.poll();
                System.out.print(current.data + " ");

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            level++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 노드 생성 과정은 DFS와 동일함
        Node1 root = new Node1(1);
        root.left = new Node1(2);
        root.right = new Node1(3);
        root.left.left = new Node1(4);
        root.left.right = new Node1(5);
        root.right.left = new Node1(6);
        root.right.right = new Node1(7);

        bfs(root); // root부터 넣어서 레벨 순서대로 탐색
    }
}