package programmers;

public class 서울에서김서방 {
    public static void main(String[] args) {
        String[] seoul = {"asdf", "Kim"};
        String result = "";
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                result = String.format("김서방은 %d에 있다", i);
                break;
            }
        }
        System.out.println(result);
    }
}
