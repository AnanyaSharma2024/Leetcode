class Solution {
    public int countServers(int[][] grid) {
        int r = grid.length;
        int c = r == 0 ? 0 : grid[0].length;
        int[] rarr = new int[r];
        int[] carr = new int[c];
        int servers = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == 1) {
                    rarr[i]++;
                    carr[j]++;
                }
            }
        }
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == 1 &&
                   (rarr[i] > 1 || carr[j] > 1)) {
                    servers++;
                }
            }
        }
        return servers;
    }
}