package yandex2019context.taskC;

import java.util.*;

public class Task {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testsAmount = in.nextInt();

        List<long[]> tests = new ArrayList<>();
        for(int test = 0; test < testsAmount; test++){
            int size = in.nextInt();
            long[] tmp = new long[size];
            for(int i = 0; i < size; i++)
                tmp[i] = in.nextLong();
            tests.add(tmp);
        }

        for(var arr : tests){
            long min = Long.MAX_VALUE;
            var tmp = Arrays.stream(arr).sorted().toArray();
            for(int i = 0; i < tmp.length - 1; i++){
                long current = tmp[i] ^ tmp[i + 1];
                if (min > current)
                    min = current;
            }
            System.out.println(min);
        }
    }
}