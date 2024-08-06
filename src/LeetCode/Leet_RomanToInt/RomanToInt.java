package LeetCode.Leet_RomanToInt;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
        int ans = 0;
        Map<Character, Integer> romanValue = new HashMap<>();

        romanValue.put('I', 1);
        romanValue.put('V', 5);
        romanValue.put('X', 10);
        romanValue.put('L', 50);
        romanValue.put('C', 100);
        romanValue.put('D', 500);
        romanValue.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && romanValue.get(s.charAt(i)) < romanValue.get(s.charAt(i + 1))) {
                ans -= romanValue.get(s.charAt(i));
            } else {
                ans += romanValue.get(s.charAt(i));
            }
        }

        return ans;
    }
}
