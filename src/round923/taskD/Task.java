package round923.taskD;

import java.util.*;

public class Task {

    public record Number(int index, int value) implements Comparable<Number>{
        @Override
        public int compareTo(Number o) {
            return index != o.index ? index - o.index : value - o.value;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        int INF = 1000 * 1000 * 10 + 25;

        for (int test = 0; test < tests; test++) {
            int n = in.nextInt();

            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = in.nextInt();
            }

            TreeSet<Number> numbers = new TreeSet<>();
            numbers.add(new Number(0, INF));
            numbers.add(new Number(n + 1, INF));
            for(int i = 0; i < a.length; i++){
                if (i == a.length - 1 || a[i] != a[i + 1]){
                    numbers.add(new Number(i + 1, a[i]));
                }
            }

            int q = in.nextInt();
            for(int j = 0; j < q; j++){
                int l = in.nextInt();
                int r = in.nextInt();

                var left = numbers.higher(new Number(l, -INF));
                var right = numbers.higher(new Number(r, -INF));

                if (left.index != right.index) {
                    if (left.value != right.value)
                        System.out.println(l + " " + r);
                    else {
                        left = numbers.higher(left);
                        System.out.println(left.index + " " + r);
                    }
                } else
                    System.out.println("-1 -1");
            }
        }
    }
}