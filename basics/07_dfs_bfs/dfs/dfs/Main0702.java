import java.util.*;

class Node { // 트리의 한 원소
    int data; // 값
    Node left, right; // 왼쪽 자식 노드, 오른쪽 자식노드의 참조값 저장

    public Node(int val) {
        data = val;
        left = right = null; // 처음 생성할 때 참조값들은 null로 초기화
    }
}
// Node a = new Node(1); 로 선언하면
// a.left = new Node(2); 값이 2인 노드를 생성하고 왼쪽노드로 연결한다는 뜻이고, a.left.data = 2이다

public class Main0702 {
    public static void inorder(Node root) {
        if (root == null) return; // 종료 조건
        // 자식이 없는 끝 노드에서 inorder(root.left)를 하면 inorder(null)이 호출됨.

        inorder(root.left); // 왼쪽 서브트리 방문
        System.out.print(root.data + " "); // 현재 노드 (부모) 출력
        inorder(root.right); // 오른쪽 서브트리 방문
    }

    public static void main(String[] args) {
        // 노드 생성
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        inorder(root); // root 부터 넣어서 중위순회
    }
}
