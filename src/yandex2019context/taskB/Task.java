package yandex2019context.taskB;

import java.util.*;

public class Task {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long nod = in.nextLong();
        long nok = in.nextLong();
        in.close();

        if (nok % nod != 0){
            System.out.println("0");
            return;
        }

        nok /= nod;
        HashSet<Long> simple = new HashSet<>();
        for(long i = 2; i <= Math.sqrt(nok); i++){
            while(nok % i == 0){
                simple.add(i);
                nok /= i;
            }
        }
        if (nok != 1){
            simple.add(nok);
        }
        System.out.println((int) Math.pow(2, simple.size()));
    }
}