package leetcode;

public class NumberIslands {

    public int numIslands(char[][] grid) {
        int numIsland = 0;
        if (grid == null || grid.length == 0 || grid[0].length ==0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    search(i, j, grid, visited);
                    ++numIsland;
                }
            }
        }
        return numIsland;
    }

    private void search(int i, int j, char[][] grid, boolean[][] visited) {
        visited[i][j] = true;
        if (i+1 < grid.length && !visited[i+1][j] && grid[i+1][j] == '1') {
            search(i+1, j, grid, visited);
        }
        else if (i-1 >= 0 && !visited[i-1][j] && grid[i-1][j] == '1') {
            search(i-1, j, grid, visited);
        }
        else if (j+1 < grid[0].length && !visited[i][j+1] && grid[i][j+1] == '1') {
            search(i, j+1, grid, visited);
        }
        else if (j-1 >= 0 && !visited[i][j-1] && grid[i][j-1] == '1') {
            search(i, j-1, grid, visited);
        }
    }

}