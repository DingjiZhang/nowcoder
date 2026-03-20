package XHS.chunzhao260311;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class prefectNum {
    static final long MAXX = 1000_000_000L;

    public static void main(String[] args) {
        Set<Long> prefect = new HashSet<>();

        for (long start = 1; start * (start + 1) * (start + 2) <= MAXX; start++) {
            long prod = start;
            long len = 1;

            for (long next = start + 1; len <= 3; next++) {
                if (prod > MAXX / next) break;
                prod *= next;
                len++;

                if (len >= 3) prefect.add(prod);
            }
        }
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            long x = sc.nextLong();
            System.out.println(prefect.contains(x) ? "YES" : "NO");
        }
    }

}
