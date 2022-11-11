import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        ArrayList<String> ansList = new ArrayList<>();
        String ans = "Yes";
        for (int i = 0; i < num; i++) {
            String[] state = scanner.nextLine().split(" ");
            if (state[1].equals("false") && state.length == 3) {
                ans = "No";
                ansList.add(state[2]);
            }
        }

        System.out.println(ans);
        for (String state : ansList) {
            System.out.print(state + " ");
        }

    }
}
