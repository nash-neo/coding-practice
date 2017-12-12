package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlipGame2 {

    //My idea is to generate all next possible move, and call canWinRecursively, if there is at least on next Move the opponent canNotWin, then this move canWin; if all next move the opponent can win, then this move canNotWin
    //Time: O(n) n is s.length() because each possible move is memoized and only evaluated once
    public boolean canWin(String s) {
        Map<String, Boolean> memo = new HashMap<>();
        return canWin(s, memo);
    }

    private boolean canWin(String s, Map<String, Boolean> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        //get possible moves
        List<String> moves = getMoves(s);
        if (moves.size() == 0) {
            memo.put(s, false);
            return false;
        }
        for (String move : moves) {
            if (!canWin(move, memo)) {
                memo.put(s, true);
                return true;
            }
        }
        return false;
    }

    private List<String> getMoves(String s) {
        List<String> moves = new ArrayList<>();
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i-1) == '+' && s.charAt(i) == '+') {
                char[] chs = s.toCharArray();
                chs[i-1] = chs[i] = '-';
                moves.add(new String(chs));
            }
        }
        return moves;
    }
}