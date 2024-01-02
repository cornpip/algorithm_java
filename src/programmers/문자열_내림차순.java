package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class 문자열_내림차순 {
    public static void main(String[] args) {
        String s = "abasdASDF";
        char[] charArray = s.toCharArray();

        List<Character> charList = new ArrayList<>();
        for (char c: charArray){
            charList.add(c);
        }
        Comparator<Character> comparator = new Comparator<>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o2.compareTo(o1);
//                int o1_ = (int) o1;
//                int o2_ = (int) o2;
//                if (o1_ < o2_) {
//                    return 1;
//                } else if (o1_ > o2_) {
//                    return -1;
//                } else {
//                    return 0;
//                }
            }
        };
//        System.out.println(Arrays.toString(charArray));
//        Arrays.sort(charArray);
//        System.out.println(Arrays.toString(charArray));

        System.out.println(charList);
        Collections.sort(charList, comparator);
        System.out.println(charList);;
//        String collect = charList.stream().map(String::valueOf).collect(Collectors.joining());
//        System.out.println(collect);
    }
}
