package round923.taskA;

import java.util.*;

public class Task {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = Integer.parseInt(in.nextLine());

        for(int test = 0; test < tests; test++){
            in.nextLine();
            String s = in.nextLine();
            System.out.println(s.lastIndexOf('B') - s.indexOf('B') + 1);
        }
    }
}