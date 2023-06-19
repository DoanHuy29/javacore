import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        int max = 1;
        Map<Integer, String> map = new HashMap<>();

        System.out.print("Nhap chuoi: ");
        s = sc.nextLine();
        map.put(max, s.substring(0,1));

        while (max < s.length()) {

            for (int i = 0; i < s.length(); i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (max < i){
                            max = i;
                            map.put(max, s.substring(0, i));
                        }
                        s = s.substring(j+1);
                        i = i - j - 1;
                        break;
                    }
                }

            }
        }
        System.out.println("Chuoi co cac ki tu khac nhau dai nhat: " + map.get(max));

    }
}