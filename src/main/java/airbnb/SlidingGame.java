package airbnb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SlidingGame {

    private static final String GOAL = "123456780";

    private static final int[][] steps = {{1,0}, {-1,0}, {0,1}, {0,-1}};


    public static Solution findPath(int[][] board) {
        //convert to id
        String init = toId(board);
        //dfs to find goal state
        List<int[]> moves = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        boolean isSolvable = dfs(init, moves, visited);
        if(isSolvable) {
            return new Solution(isSolvable, moves);
        }
        else {
            return new Solution(isSolvable, null);
        }

    }

    private static boolean dfs(String curr, List<int[]> moves, Set<String> visited) {
        if (GOAL.equals(curr)) {
            return true;
        }
        visited.add(curr);
        List<Move> nextMoves = nextMoves(curr);
        for (Move nextMove : nextMoves) {
            if(!visited.contains(nextMove.next)) {
                moves.add(nextMove.move);
                boolean found = dfs(nextMove.next, moves, visited);
                if (found) {
                    return true;
                }
                moves.remove(moves.size()-1);
            }
        }
        return false;
    }

    private static String toId(int[][] state) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < state.length; ++row) {
            for (int col = 0; col < state[0].length; ++col) {
                sb.append(state[row][col]);
            }
        }
        return sb.toString();
    }

    private static List<Move> nextMoves(String id) {
        int[][] state = new int[3][3];
        int currRow = -1;
        int currCol = -1;
        for (int i = 0; i < id.length(); ++i) {
            int k = id.charAt(i) - '0';
            if (k == 0) {
                currRow = i/3;
                currCol = i%3;
            }
            state[i/3][i%3] = k;
        }
        List<Move> moves = new ArrayList<>();
        for (int[] step : steps) {
            int nextRow = currRow + step[0];
            int nextCol = currCol + step[1];
            if (nextRow >=0 && nextRow < 3 && nextCol >=0 && nextCol < 3) {
                int[][] nextState = copy(state);
                nextState[nextRow][nextCol] = state[currRow][currCol];
                nextState[currRow][currCol] = state[nextRow][nextCol];
                Move nextMove = new Move(toId(nextState), step);
                moves.add(nextMove);
            }
        }
        return moves;
    }

    private static int[][] copy(int[][] state) {
        int[][] nextState = new int[3][3];
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col <3; ++col) {
                nextState[row][col] = state[row][col];
            }
        }
        return nextState;
    }

    private static class Move {
        String next; //nextId
        int[] move;
        public Move(String next, int[] move) {
            this.next = next;
            this.move = move;
        }
    }

    private static class Solution {
        boolean isSolvable;
        List<int[]> moves; //null if isSolvable is false
        public Solution(boolean isSolvable, List<int[]> moves) {
            this.isSolvable = isSolvable;
            this.moves = moves;
        }
    }


    public static void main(String[] args) {
        int[][] init = {{1,3,2},{4, 0, 5}, {8, 7, 6}};
//        int[][] init = {{1,2,3},{4,5,6},{7,0,8}};
        Solution solution = findPath(init);
        System.out.println(solution.isSolvable);
        System.out.println(solution.moves.size());
    }
}

