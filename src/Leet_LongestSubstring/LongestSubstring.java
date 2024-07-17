package Leet_LongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "";
        int n = lengthOfLongestSubstring(s);
        System.out.println(n);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int stringLength = s.length();
        int startIndex = 0;
        int maxLength = 0;

        for (int lastIndex = 0; lastIndex < stringLength; lastIndex++) {
            if (!set.contains(s.charAt(lastIndex))) {
                set.add(s.charAt(lastIndex));
                maxLength = Math.max(maxLength, lastIndex - startIndex + 1);
            } else {
                set.clear();
                startIndex = lastIndex;
                set.add(s.charAt(lastIndex));
            }
        }

        return maxLength;
    }
}
