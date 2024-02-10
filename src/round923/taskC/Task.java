package round923.taskC;

import java.util.*;

public class Task {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        for(int test = 0; test < tests; test++){
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();

            Set<Integer> set1 = new HashSet<>();
            for(int i = 0; i < n; i++){
                set1.add(in.nextInt());
            }
            Set<Integer> set2 = new HashSet<>();
            for(int i = 0; i < m; i++){
                set2.add(in.nextInt());
            }

            int k1 = 0, k2 = 0, both = 0;
            for(int i = 1; i <= k && (k1 <= k / 2 || k2 <= k / 2); i++){
                if (set1.contains(i) && set2.contains(i))
                    both++;
                else if (set1.contains(i))
                    k1++;
                else if (set2.contains(i))
                    k2++;
                else
                    break;
            }
            if (k1 + k2 + both == k && k1 <= k / 2 && k2 <= k / 2)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }
}