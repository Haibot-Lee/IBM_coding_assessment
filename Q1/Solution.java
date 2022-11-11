import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = Integer.parseInt(scanner.nextLine());
        String[] totalClose = scanner.nextLine().split(" ");
        int request = Integer.parseInt(scanner.nextLine());
        String[] requestClose = scanner.nextLine().split(" ");

//        build the table of shops
        HashMap<Integer, Integer> totalMap = new HashMap<>();
        for (int i = 0; i < total; i++) {
            int size = getSize(totalClose[i]);

            if (totalMap.get(size) != null && totalMap.get(size) > 0) {
                int num = totalMap.get(size) + 1;
                totalMap.put(size, num);
            } else {
                totalMap.put(size, 1);
            }
        }

        String ans = "Yes";
        for (int i = 0; i < request; i++) {
            int size = getSize(requestClose[i]);

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

    public static int getSize(String type) {
        int size = 0;
        if (type.equals("M")) {
            size = 0;
        } else if (type.charAt(type.length() - 1) == 'S') {
            size = -1 * type.length();
        } else if (type.charAt(type.length() - 1) == 'L') {
            size = type.length();
        }
        return size;
    }
}
