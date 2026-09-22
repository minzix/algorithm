import java.util.*;

class Point {
    int x;
    int y;
    int index;
    int distance;

    Point(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
        distance = Math.abs(x) + Math.abs(y);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Point(sc.nextInt(), sc.nextInt(), i));
        }

        Collections.sort(list, (a, b) -> {
            if (a.distance != b.distance) return a.distance - b.distance;
            if (a.index != b.index) return a.index - b.index;
            return 0;
        });

        for (Point p : list) System.out.println(p.index + 1);
        
    }
}