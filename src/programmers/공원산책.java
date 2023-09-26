package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 공원산책 {
    public static void main(String[] args) {
        HashMap<String, Integer[]> moveMapping = new HashMap<>();
        moveMapping.put("E", new Integer[]{0, 1});
        moveMapping.put("S", new Integer[]{1, 0});
        moveMapping.put("W", new Integer[]{0, -1});
        moveMapping.put("N", new Integer[]{-1, 0});

//        String[] park = {"SOO", "OOO", "OOO"};
        String[] park = {"SOO", "OXX", "OOO"};
        String[] routes = {"E 2", "S 2", "W 1"};
//        String[] park = {"OSO","OOO","OXO","OOO"};
//        String[] routes = {"E 2","S 3","W 1"};

        Integer[] startPosition = getStartPosition(park);
        Integer[][] blockPositions = getBlockPositions(park);
//        System.out.println(Arrays.toString(startPosition));
//        System.out.println(Arrays.deepToString(blockPositions));

        Integer[] position = startPosition.clone();
        loof1:
        for (String route : routes) {
            String[] s = route.split(" ");
            String arrow = s[0];
            String distance = s[1];
            Integer[] moveArrow = moveMapping.get(arrow);

            Integer nx = moveArrow[0] * Integer.parseInt(distance);
            Integer ny = moveArrow[1] * Integer.parseInt(distance);
            Integer nextPositionX = position[0] + nx;
            Integer nextPositionY = position[1] + ny;

            if (nextPositionX < 0 || nextPositionX >= park.length) continue;
            if (nextPositionY < 0 || nextPositionY >= park[0].length()) continue;
            if (moveArrow[0] != 0) {
                for (Integer[] block : blockPositions) {
                    //일단 열이 같고
                    if (position[1].equals(block[1])) {
                        if (nx > 0) {
                            if (position[0] < block[0] && block[0] <= nextPositionX) {
                                continue loof1;
                            }
                        } else {
                            if (position[0] > block[0] && block[0] >= nextPositionX) {
                                continue loof1;
                            }
                        }
                    }
                }
            }

            if (moveArrow[1] != 0) {
                for (Integer[] block : blockPositions) {
                    //일단 행이 같고
                    if (position[0].equals(block[0])) {
                        if (ny > 0) {
                            if (position[1] < block[1] && block[1] <= nextPositionY) {
                                continue loof1;
                            }
                        } else {
                            if (position[1] > block[1] && block[1] >= nextPositionY) {
                                continue loof1;
                            }
                        }
                    }
                }
            }
            position = new Integer[]{nextPositionX, nextPositionY};
        }
        System.out.println(Arrays.toString(position));
        Arrays.stream(position).mapToInt(Integer::intValue).toArray();
    }

    private static Integer[] getStartPosition(String[] park) {
        for (int i = 0; i < park.length; i++) {
            String row = park[i];
            for (int j = 0; j < park[0].length(); j++) {
                Character c = row.charAt(j);
                if (c.equals('S')) {
                    return new Integer[]{i, j};
                }
            }
        }
        return new Integer[0];
    }

    private static Integer[][] getBlockPositions(String[] park) {
        ArrayList<Integer[]> resultArr = new ArrayList<>();
        for (int i = 0; i < park.length; i++) {
            String row = park[i];
            for (int j = 0; j < park[0].length(); j++) {
                Character c = row.charAt(j);
                if (c.equals('X')) resultArr.add(new Integer[]{i, j});
            }
        }
        return resultArr.toArray(new Integer[0][0]);
    }
}
