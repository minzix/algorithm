import java.util.Scanner;

/*
 * 개념 설명
 * Find: 어떤 원소가 어느 집합에 속하는지 대표(parent, root) 를 찾는 연산. 대표가 같으면 같은 집합임. find(a) = a가 속한 그룹의 대표
 * Union: 두 원소가 속한 집합을 하나로 합치는 연산
 */
public class Main0906 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        /*
        * 풀이 과정
        * 1. 초기: {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9} → 학생이 전부 따로 있다고 가정
        * 2. 친구 관계를 입력할 때마다 합치기: (1 2) 입력 →  {1, 2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}
        * 3. 최종적으로 같은 집합에 있으면 친구
        */

    }
}
