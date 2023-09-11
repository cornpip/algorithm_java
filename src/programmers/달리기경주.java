package programmers;

import java.util.*;

public class 달리기경주 {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        HashMap<String, Integer> playerMap = new HashMap<>();
        HashMap<Integer, String> rankMap = new HashMap<>();
        Integer initN = 1;
        for (String s : players) {
            playerMap.put(s, initN);
            rankMap.put(initN++, s);
        }

        for (String s : callings) {
            rankChange(playerMap, rankMap, s);
        }
        String[] res = rankMap.values().toArray(new String[0]);
        System.out.println(Arrays.toString(res));
        //["mumu", "kai", "mine", "soe", "poe"]
    }

    private static void rankChange(HashMap<String, Integer> playerMap, HashMap<Integer, String> rankMap, String player) {
        Integer upPlayerRank = playerMap.get(player);
        String downPlayer = rankMap.get(upPlayerRank - 1);

        playerMap.put(player, upPlayerRank - 1);
        playerMap.put(downPlayer, upPlayerRank);
        rankMap.put(upPlayerRank, downPlayer);
        rankMap.put(upPlayerRank - 1, player);
    }

    //시간 초과 방법
    private static ArrayList<String> slotChange(ArrayList<String> playerList, String player, int index) {
        String overTaken = playerList.get(index - 1);
        playerList.set(index - 1, player);
        playerList.set(index, overTaken);
        return playerList;
    }

}