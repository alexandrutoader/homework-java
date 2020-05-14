package com.siit.homework.course11.brackets;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketsExercise {
    public boolean isBalanced(String s) {
        if (s == null) {
            System.out.println("The string " + "'" + s + "'" + " is not balanced!");
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) {
                    System.out.println("The string " + "'" + s + "'" + " is not balanced!");
                    return false;
                }
                char c = stack.pop();
                if (c != map.get(s.charAt(i))) {
                    System.out.println("The string " + "'" + s + "'" + " is not balanced!");
                    return false;
                }
            }
        }
        if (!stack.empty()) {
            System.out.println("The string " + "'" + s + "'" + " is not balanced!");
            return false;
        }
        System.out.println("The string " + "'" + s + "'" + " is balanced!");
        return true;
    }
}
