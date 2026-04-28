class Node1 { // 트리의 한 원소
    int data; // 값
    Node1 left, right; // 왼쪽 자식 노드, 오른쪽 자식노드의 참조값 저장

    public Node1(int data) {
        this.data = data;
        left = right = null; // 처음 생성할 때 참조값들은 null로 초기화
    }
}
// Node1 a = new Node1(1); 로 선언하면
// a.left = new Node1(2); 값이 2인 노드를 생성하고 왼쪽노드로 연결한다는 뜻이고, a.left.data = 2이다

public class Main0702 {
    // root는 항상 전체 트리의 진짜 루트 1만 의미하지 않으며, 재귀호출 될 때마다 바뀜
    // inorder(2) → inorder(4) → sout(4) → sout(2) → inorder(5) → sout(5) → sout(1) → inorder(3) → inorder(6) → sout(6) → sout(3) → inorder(7) → sout(7)
    public static void inorder(Node1 root) {
        if (root == null) return; // 종료 조건
        // 자식이 없는 끝 노드에서 inorder(root.left)를 하면 inorder(null)이 호출됨.

        inorder(root.left); // 왼쪽 서브트리 방문: 해당 함수에서는 root.left가 root가 됨.
        System.out.print(root.data + " "); // 현재 노드 (부모) 출력
        inorder(root.right); // 오른쪽 서브트리 방문: 해당 함수에서는 root.right가 root가 됨.
    }

    public static void main(String[] args) {
        // 노드 생성
        Node1 root = new Node1(1);
        root.left = new Node1(2);
        root.right = new Node1(3);
        root.left.left = new Node1(4);
        root.left.right = new Node1(5);
        root.right.left = new Node1(6);
        root.right.right = new Node1(7);

        inorder(root); // root 부터 넣어서 중위순회
    }
}
