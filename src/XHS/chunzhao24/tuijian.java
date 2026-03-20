package XHS.chunzhao24;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class tuijian {

    static class Item {
        String name;
        int score;
        int idx;


        public Item(String name, int score, int idx) {
            this.name = name;
            this.score = score;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < q; i++) {
            set.add(sc.next());
        }

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int m = sc.nextInt();

            int score = 0;
            for (int j = 0; j < m; j++) {
                String attr = sc.next();
                if (set.contains(attr)) {
                    score++;
                }
            }
            items[i] = new Item(name, score, i);
        }

        Arrays.sort(items, (a, b) -> {
            if (a.score != b.score) return b.score - a.score;
            return a.idx - b.idx;
        });

        for (Item item : items) {
            System.out.println(item.name);
        }
    }
}
