import java.util.LinkedList;
import java.util.Queue;

class Node3 {
    int data;
    Node3 left, right;
    public Node3 (int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
public class Main0705 {
    public static void shortestPath(Node3 root) {
        int level = 0;
        Queue<Node3> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                Node3 temp = queue.poll();
                if (temp.right == null && temp.left == null) {
                    System.out.println(level);
                    return;
                }
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            level++;

        }
    }
    // 각 level 에서 .left, .right = null 인 노드가 있으면 해당 level 출력
    public static void main(String[] args) {
        Node3 root = new Node3(1);
        root.left = new Node3(2);
        root.right = new Node3(3);
        root.left.left = new Node3(4);
        root.left.right = new Node3(5);
        shortestPath(root);
    }
}
