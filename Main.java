import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.print("Enter string: ");
        s = sc.nextLine();
        //option_1(s); Cai nay bi sai a', no ko check duoc cai chuoi ko bi trung nhu: ab, abcd,.... Em sua o cai option 2 r a'
        option_2(s);
    }
    static void option_1 (String s){
        int max = 1;
        Map<Integer, String> map = new HashMap<>();
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
    static void option_2 (String s){
        int max = 1;
        Map<Integer, String> map = new HashMap<>();
        map.put(max, s.substring(0,1));
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            if (s1.contains(Character.toString(s.charAt(i)))){
                if (max < i){
                    max = i;
                    map.put(max, s1);
                }
                i = i - s.indexOf(Character.toString(s.charAt(i))) - 1;
                s = s.substring(s.indexOf(Character.toString(s.charAt(i)))+1);
            }
            else {
                max = s.substring(0, i + 1).length();
                map.put(max, s.substring(0, i + 1));
            }
        }
        System.out.println("Longest string: " + map.get(max));
    }
}