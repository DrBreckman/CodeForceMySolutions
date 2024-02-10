package round923.taskB;

import java.util.*;

public class Task {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        for(int test = 0; test < tests; test++){
            int n = in.nextInt();

            Map<Integer, Character> map = new HashMap<>();
            char[] arr = new char[n];
            for(int i = 0; i < n; i++){
                int value = in.nextInt();
                if (map.containsKey(value))
                    map.replace(value, (char)(1 + map.get(value)));
                else
                    map.put(value, (char) 97);

                arr[i] = map.get(value);
            }
            System.out.println(new String(arr));
        }
    }
}