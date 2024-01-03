package programmers;

import java.util.ArrayList;

public class 푸드파이터 {
    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int count = food[i];
            while (count > 1) {
                count -= 2;
                sb.append(i);
            }
        }

        StringBuilder sb2 = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            sb2.append(c);
        }

        String result = sb.append(0).append(sb2).toString();
        System.out.println(result);
    }
}
