package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfAPhoneNumber {
    private Map<Character, List<Character>> digitMap= new HashMap<>();

    public LetterCombinationOfAPhoneNumber() {
        digitMap.put('1', Arrays.asList('1'));
        digitMap.put('2', Arrays.asList('a','b','c'));
        digitMap.put('3', Arrays.asList('d','e','f'));
        digitMap.put('4', Arrays.asList('g','h','i'));
        digitMap.put('5', Arrays.asList('j','k','l'));
        digitMap.put('6', Arrays.asList('m','n','o'));
        digitMap.put('7', Arrays.asList('p','q','r','s'));
        digitMap.put('8', Arrays.asList('t','u','v'));
        digitMap.put('9', Arrays.asList('w','x','y','z'));
        digitMap.put('0', Arrays.asList(' '));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder currStr = new StringBuilder();
        find(digits, currStr, 0, result);
        return result;
    }

    private void find(String digits, StringBuilder currStr, int currIndex, List<String> result) {
        if (currIndex == digits.length()) {
            if (currStr.length() != 0) {
                result.add(currStr.toString());
            }
        }
        else {
            char currDigit = digits.charAt(currIndex);
            for (char letter : digitMap.get(currDigit)) {
                currStr.append(letter);
                find(digits, currStr, currIndex + 1, result);
                currStr.deleteCharAt(currStr.length()-1);
            }
        }
    }
}
