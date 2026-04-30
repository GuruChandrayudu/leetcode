import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] d : dirs) {
                int x = curr[0] + d[0];
                int y = curr[1] + d[1];

                if (x >= 0 && y >= 0 && x < rows && y < cols && mat[x][y] == -1) {
                    mat[x][y] = mat[curr[0]][curr[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }

        return mat;
    }
}