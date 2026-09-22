import java.util.*;

class Data {
    int index;
    int sortedIndex;
    int value;

    Data (int index, int value) {
        this.index = index;
        this.value = value;
        sortedIndex = index;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Data> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new Data(i, sc.nextInt()));
        }

        // value로 정렬
        Collections.sort(list, (a, b) -> a.value - b.value);

        // sortedIndex 채우기
        for(int i = 0; i < n; i++){
            list.get(i).sortedIndex = i + 1;
        }

        // index로 정렬
        Collections.sort(list, (a, b) -> a.index - b.index);

        for (Data d : list) System.out.print(d.sortedIndex + " ");
    }
}