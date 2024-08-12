package LeetCode.Leet_LetterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        Map<Character, String> hashMap = new HashMap<>();
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");

        backTracking(digits, 0, new StringBuilder(), result, hashMap);

        return result;
    }

    // digits: 전화기 키패드 숫자, depth: 전화기 키패드를 누르는 횟수(트리의 depth)
    // combination: 가능한 글자 조합(depth가 +1 될 때 마다 한 글자씩 추가될 예정
    // result: 최종 결과. 트리의 끝에 도달할 경우 combination을 추가한다.
    // Map: Key - 키패드 숫자, Value - 키패드 글자
    public void backTracking(String digits, int depth, StringBuilder combination, List<String> result, Map<Character, String> hashMap) {
        // 트리의 끝에 도달한 경우
        if (depth == digits.length()) {
            result.add(combination.toString());
            return;
        }

        // letters: digit에서 depth번째 숫자 키패드에 있는 글자들
        String letters = hashMap.get(digits.charAt(depth));
        // 글자들 개수만큼 반복
        for (char letter : letters.toCharArray()) {
            combination.append(letter);
            backTracking(digits, depth + 1, combination, result, hashMap);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
