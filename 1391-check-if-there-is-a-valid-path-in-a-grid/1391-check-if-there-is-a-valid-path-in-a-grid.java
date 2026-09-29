class Solution {

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        return dfs(0, 0, grid, visited);
    }

    private boolean dfs(int i, int j, int[][] grid, boolean[][] visited) {

        int m = grid.length;
        int n = grid[0].length;

        // Out of bounds
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }

        // Already visited
        if (visited[i][j]) {
            return false;
        }

        // Destination reached
        if (i == m - 1 && j == n - 1) {
            return true;
        }

        visited[i][j] = true;

        int type = grid[i][j];

        // Type 1: left <-> right
        if (type == 1) {

            // Go right
            if (j + 1 < n && !visited[i][j + 1]
                    && (grid[i][j + 1] == 1 ||
                        grid[i][j + 1] == 3 ||
                        grid[i][j + 1] == 5)) {

                if (dfs(i, j + 1, grid, visited))
                    return true;
            }

            // Go left
            if (j - 1 >= 0 && !visited[i][j - 1]
                    && (grid[i][j - 1] == 1 ||
                        grid[i][j - 1] == 4 ||
                        grid[i][j - 1] == 6)) {

                if (dfs(i, j - 1, grid, visited))
                    return true;
            }
        }

        // Type 2: up <-> down
        else if (type == 2) {

            // Go down
            if (i + 1 < m && !visited[i + 1][j]
                    && (grid[i + 1][j] == 2 ||
                        grid[i + 1][j] == 5 ||
                        grid[i + 1][j] == 6)) {

                if (dfs(i + 1, j, grid, visited))
                    return true;
            }

            // Go up
            if (i - 1 >= 0 && !visited[i - 1][j]
                    && (grid[i - 1][j] == 2 ||
                        grid[i - 1][j] == 3 ||
                        grid[i - 1][j] == 4)) {

                if (dfs(i - 1, j, grid, visited))
                    return true;
            }
        }

        // Type 3: left <-> down
        else if (type == 3) {

            // Go left
            if (j - 1 >= 0 && !visited[i][j - 1]
                    && (grid[i][j - 1] == 1 ||
                        grid[i][j - 1] == 4 ||
                        grid[i][j - 1] == 6)) {

                if (dfs(i, j - 1, grid, visited))
                    return true;
            }

            // Go down
            if (i + 1 < m && !visited[i + 1][j]
                    && (grid[i + 1][j] == 2 ||
                        grid[i + 1][j] == 5 ||
                        grid[i + 1][j] == 6)) {

                if (dfs(i + 1, j, grid, visited))
                    return true;
            }
        }

        // Type 4: right <-> down
        else if (type == 4) {

            // Go right
            if (j + 1 < n && !visited[i][j + 1]
                    && (grid[i][j + 1] == 1 ||
                        grid[i][j + 1] == 3 ||
                        grid[i][j + 1] == 5)) {

                if (dfs(i, j + 1, grid, visited))
                    return true;
            }

            // Go down
            if (i + 1 < m && !visited[i + 1][j]
                    && (grid[i + 1][j] == 2 ||
                        grid[i + 1][j] == 5 ||
                        grid[i + 1][j] == 6)) {

                if (dfs(i + 1, j, grid, visited))
                    return true;
            }
        }

        // Type 5: left <-> up
        else if (type == 5) {

            // Go left
            if (j - 1 >= 0 && !visited[i][j - 1]
                    && (grid[i][j - 1] == 1 ||
                        grid[i][j - 1] == 4 ||
                        grid[i][j - 1] == 6)) {

                if (dfs(i, j - 1, grid, visited))
                    return true;
            }

            // Go up
            if (i - 1 >= 0 && !visited[i - 1][j]
                    && (grid[i - 1][j] == 2 ||
                        grid[i - 1][j] == 3 ||
                        grid[i - 1][j] == 4)) {

                if (dfs(i - 1, j, grid, visited))
                    return true;
            }
        }

        // Type 6: right <-> up
        else if (type == 6) {

            // Go right
            if (j + 1 < n && !visited[i][j + 1]
                    && (grid[i][j + 1] == 1 ||
                        grid[i][j + 1] == 3 ||
                        grid[i][j + 1] == 5)) {

                if (dfs(i, j + 1, grid, visited))
                    return true;
            }

            // Go up
            if (i - 1 >= 0 && !visited[i - 1][j]
                    && (grid[i - 1][j] == 2 ||
                        grid[i - 1][j] == 3 ||
                        grid[i - 1][j] == 4)) {

                if (dfs(i - 1, j, grid, visited))
                    return true;
            }
        }

        return false;
    }
}