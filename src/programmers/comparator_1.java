package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class comparator_1 {
    public static void main(String[] args) {
        Integer[] arr = {12,23,3,14,5};

        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        Arrays.sort(arr, comparator); // List 면 Collections
        System.out.println(Arrays.toString(arr));

        Integer[] arr2 = {12,23,3,14,5};
        Arrays.sort(arr2, Collections.reverseOrder()); //int[] 는 안됨
    }
}
