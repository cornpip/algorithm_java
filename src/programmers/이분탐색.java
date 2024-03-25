package programmers;

import java.util.Arrays;

public class 이분탐색 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};

        Arrays.sort(times);
        long result_time = 0;
        long start = 1, end = times[times.length - 1] * (long)n; //long = int * int 는 오버플로우 된 상태로 long에 할당된다.

        while (true) {
            long mid = (start + end) / 2;
//            System.out.printf("%d, %d, %d\n",start, end, mid);
            if (start == mid) {
                result_time = end;
                break;
            }

            long res = 0;
            for (int time : times) {
                res += mid / time;
                if(res > n) break;
            }
//            System.out.printf("res = %d\n",res);
            if (res >= n) {
                end = mid;
            } else {
                start = mid;
            }
        }
    }
}
