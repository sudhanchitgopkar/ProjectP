class Solution {
    public int minimumEffortPath(int[][] heights) {
       int m = heights.length, n = heights[0].length;
       PriorityQueue <int []> pq = new PriorityQueue <> (
           (int [] a, int [] b) -> Integer.compare(a[2], b[2]));
       int [][] minDist = new int [m][n];
       int [][] dirs = new int [][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

       for (int i = 0 ; i < m; i++) {
           for (int j = 0; j < n; j++) {
               minDist[i][j] = Integer.MAX_VALUE;
           } //for
       } //for

       pq.offer(new int [] {0, 0, 0});

       while (!pq.isEmpty()) {
           int [] curr = pq.poll();

           if (curr[0] == m - 1 && curr[1] == n - 1) {
               return curr[2];
           } //if

           for (int [] dir : dirs) {
               int nx = curr[0] + dir[0], ny = curr[1] + dir[1];
               if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                   continue;
               } //if

               int nd = Math.max(curr[2], Math.abs(heights[curr[0]][curr[1]] - heights[nx][ny]));
               if (nd < minDist[nx][ny]) {
                   minDist[nx][ny] = nd;
                   pq.offer(new int [] {nx, ny, nd});
               } //if
           } //for
       } //while
       
       return -1; 
    } //minEffortPath
} //Sol
