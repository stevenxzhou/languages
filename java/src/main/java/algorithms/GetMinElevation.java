package algorithms;

import java.util.PriorityQueue;

public class GetMinElevation {
    
    static class GetMinElevationBFS {
        public int getMinElevation(int[][] matrix) {
            int rows = matrix.length;
            if (rows == 0) {
                return -1;
            }
            int cols = matrix[0].length;
            if (cols == 0) {
                return -1;
            }
    
            boolean[][] visited = new boolean[rows][cols];
            int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
            // PriorityQueue sorted by elevation height
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]
            );
    
            pq.offer(new int[]{0, 0});
            visited[0][0] = true;
    
            int ans = matrix[0][0];
    
            while (!pq.isEmpty()) {
                int[] rc = pq.poll();
                ans = Math.max(ans, matrix[rc[0]][rc[1]]);
    
                if (rc[0] == rows - 1 && rc[1] == cols - 1) {
                    return ans;
                }
    
                for (int[] dir : dirs) {
                    int nr = rc[0] + dir[0];
                    int nc = rc[1] + dir[1];
    
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                        pq.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
    
            return -1;
        }
    }

    static class GetMinElevationDFS {
        private int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        private int rows, cols;
    
        public int getMinElevation(int[][] matrix) {
            rows = matrix.length;
            if (rows == 0) return -1;
            cols = matrix[0].length;
            if (cols == 0) return -1;
    
            int minVal = matrix[0][0];
            int maxVal = matrix[0][0];
    
            // Find the max elevation in matrix
            for (int[] row : matrix) {
                for (int val : row) {
                    maxVal = Math.max(maxVal, val);
                    minVal = Math.min(minVal, val);
                }
            }
    
            int left = minVal;
            int right = maxVal;
            int ans = maxVal;
    
            while (left <= right) {
                int mid = left + (right - left) / 2;
    
                boolean[][] visited = new boolean[rows][cols];
                if (matrix[0][0] <= mid && dfs(matrix, 0, 0, visited, mid)) {
                    ans = mid;
                    right = mid - 1;  // try smaller elevation
                } else {
                    left = mid + 1;   // need bigger elevation
                }
            }
    
            return ans;
        }
    
        private boolean dfs(int[][] matrix, int r, int c, boolean[][] visited, int maxElevation) {
            if (r == rows - 1 && c == cols - 1) {
                return true;
            }
    
            visited[r][c] = true;
    
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
    
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
                    !visited[nr][nc] &&
                    matrix[nr][nc] <= maxElevation) {
    
                    if (dfs(matrix, nr, nc, visited, maxElevation)) {
                        return true;
                    }
                }
            }
    
            return false;
        }
    }
    

    public static void main(String[] args) {
        int[][] test1 = new int[][]{{}, {}, {}};
        int[][] test2 = new int[][]{{1,3,5}, {1,9,3}, {3,4,2}};

        // GetMinElevationBFS getMinElevationBFS = new GetMinElevationBFS();
        // System.out.println(getMinElevationBFS.getMinElevation(test1));
        // System.out.println(getMinElevationBFS.getMinElevation(test2));

        GetMinElevationDFS getMinElevationDFS = new GetMinElevationDFS();
        System.out.println(getMinElevationDFS.getMinElevation(test2));
    }
}
