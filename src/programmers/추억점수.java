package programmers;

import java.util.Arrays;
import java.util.HashMap;

public class 추억점수 {
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {
                {"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"},
        };

        HashMap<String, Integer> nameScore = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            nameScore.put(name[i], yearning[i]);
        }

        int[] result = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            int totalScore = 0;
            for (int j = 0; j < photo[i].length; j++) {
                String n = String.valueOf(nameScore.get(photo[i][j]));
                if (n.equals("null")) continue;
                totalScore += nameScore.get(photo[i][j]);
            }
            result[i] = totalScore;
        }

        System.out.println(Arrays.toString(result));
    }
}
