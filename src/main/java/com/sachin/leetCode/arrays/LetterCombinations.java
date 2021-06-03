package com.sachin.leetCode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

  public static void main(String[] args) {
    letterCombinations("23");

  }
  
    public static List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> keyboard = new HashMap<>();
        
        keyboard.put('2', Arrays.asList('a', 'b', 'c'));
        keyboard.put('3', Arrays.asList('d', 'e', 'f'));
        keyboard.put('4', Arrays.asList('g', 'h', 'i'));
        keyboard.put('5', Arrays.asList('j', 'k', 'l'));
        keyboard.put('6', Arrays.asList('m', 'n', 'o'));
        keyboard.put('7', Arrays.asList('p', 'q', 'r', 's'));
        keyboard.put('8', Arrays.asList('t', 'u', 'v'));
        keyboard.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        
        List<String> combinations = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        
        letterCombinations(digits, keyboard, combinations, sb, 0);
        
        combinations.forEach(System.out::println);
        return combinations;
    }
    
    private static void letterCombinations(String digits, Map<Character, List<Character>> keyboard, List<String> combinations, StringBuilder sb, int index) {
        if (index == digits.length()) {
            if (index > 0) combinations.add(sb.toString());
            return;
        }
        
        char number = digits.charAt(index);
        
        for (char letter : keyboard.get(number)) {
            sb.append(letter);
            letterCombinations(digits, keyboard, combinations, sb, index + 1);
            sb.setLength(sb.length() - 1);
        }
    }

}
