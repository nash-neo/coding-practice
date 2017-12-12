package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ExpressionAddOperators {

    private static List<String> operators = Arrays.asList("*", "+", "-", "");

    //backtrack for each location between digits, try four choices "", "+", "-", "*"
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(num, 0, new StringBuilder(), target, result);
        return result;
    }

    private void backtrack(String num, int curr, StringBuilder partial, int target, List<String> result) {
        if (curr == num.length()-1) {
            partial.append(num.charAt(curr));
            String expr = partial.toString();
            if (isTarget(expr, target)) {
                result.add(expr);
            }
            partial.delete(partial.length()-1, partial.length());
            return;
        }
        for (String op : operators) {
            if (num.charAt(curr) == '0' && op.isEmpty() && !Character.isDigit(partial.charAt(partial.length()-1))) {
                continue;
            }
            backtrack(num, curr + 1, partial.append(num.charAt(curr)).append(op), target, result);
            partial.delete(partial.length()-op.length()-1, partial.length());
        }
    }

    boolean isTarget(String expr, int target) {
        int last = 0;
        String[] nums = expr.split("\\+|-|\\*");
        String[] ops = expr.split("\\d+");
        int curr = Integer.valueOf(nums[0]);
        for (int i = 1; i < nums.length; ++i) {
            int next = Integer.valueOf(nums[i]);
            if (ops[i].equals("*")) {
                curr = curr * next;
            }
            else if (ops[i].equals("+")){
                last = last + curr;
                curr = next;
            }
            else {
                last = last + curr;
                curr = -next;
            }
        }
        return last + curr == target;
    }

    void dfs(List<String> ret, char[] path, int len, long left, long cur, char[] digits, int pos, int target) {
        if (pos == digits.length) {
            if (left + cur == target) ret.add(new String(path, 0, len));
            return;
        }
        long n = 0;
        int j = len + 1;
        for (int i = pos; i < digits.length; i++) {
            n = n * 10 + digits[i] - '0';
            path[j++] = digits[i];
            path[len] = '+';
            dfs(ret, path, j, left + cur, n, digits, i + 1, target);
            path[len] = '-';
            dfs(ret, path, j, left + cur, -n, digits, i + 1, target);
            path[len] = '*';
            dfs(ret, path, j, left, cur * n, digits, i + 1, target);
            if (digits[pos] == '0') break;
        }
    }
    public List<String> addOperators2(String num, int target) {
        List<String> ret = new LinkedList<>();
        if (num.length() == 0) return ret;
        char[] path = new char[num.length() * 2 - 1];
        char[] digits = num.toCharArray();
        long n = 0;
        for (int i = 0; i < digits.length; i++) {
            n = n * 10 + digits[i] - '0';
            path[i] = digits[i];
            dfs(ret, path, i + 1, 0, n, digits, i + 1, target);
            if (n == 0) break;
        }
        return ret;
    }
}
