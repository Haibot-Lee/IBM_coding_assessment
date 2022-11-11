import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = Integer.parseInt(scanner.nextLine());
        String[] totalClose = scanner.nextLine().split(" ");
        int request = Integer.parseInt(scanner.nextLine());
        String[] requestClose = scanner.nextLine().split(" ");

        HashMap<Integer, Integer> totalMap = new HashMap<>();
        for (int i = 0; i < total; i++) {
            int size = 0;
            if (totalClose[i].equals("M")) {
                size = 0;
            } else if (totalClose[i].charAt(totalClose[i].length() - 1) == 'S') {
                size = -1 * totalClose[i].length();
            } else if (totalClose[i].charAt(totalClose[i].length() - 1) == 'L') {
                size = totalClose[i].length();
            }
            if (totalMap.get(size) != null) {
                int num = totalMap.get(size) + 1;
                totalMap.put(size, num);
            } else {
                totalMap.put(size, 1);
            }
        }

        String ans = "Yes";
        for (int i = 0; i < request; i++) {
            int size = 0;
            if (requestClose[i].equals("M")) {
                size = 0;
            } else if (requestClose[i].charAt(requestClose[i].length() - 1) == 'S') {
                size = -1 * requestClose[i].length();
            } else if (requestClose[i].charAt(requestClose[i].length() - 1) == 'L') {
                size = requestClose[i].length();
            }
            boolean find = false;
            while (size <= 1001) {
                if (totalMap.get(size) != null && totalMap.get(size) > 0) {
                    int num = totalMap.get(size) - 1;
                    totalMap.put(size, num);
                    find = true;
                    break;
                } else {
                    size++;
                }
            }
            if (!find) {
                ans = "No";
                break;
            }
        }

        System.out.println(ans);
    }
}
