package programmers;

public class 약수 {
    public static void main(String[] args) {
        int left=13, right=17;

        int result=0;
        for (int i=left; i<=right; i++){
            if (getCount(i) % 2 == 0){
                result += i;
            } else {
                result -= i;
            }
        }
        System.out.println(result);
    }

    public static Integer getCount(Integer num) {
        if (num == 1) return 1;

        Integer count = 0;
        for(int i=1; i<=(int) Math.sqrt(num); i++){
            if (num % i == 0){
                if (i != 1 && num / i == i){
                    count++;
                } else {
                    count+=2;
                }
            }
        }
        return count;
    }
}
