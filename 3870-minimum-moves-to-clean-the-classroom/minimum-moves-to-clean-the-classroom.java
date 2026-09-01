import java.util.*;

class Solution {

    class Pair {
        int r;
        int c;
        int step;
        int energy;
        int mask;

        Pair(int r, int c, int step, int energy, int mask) {
            this.r = r;
            this.c = c;
            this.step = step;
            this.energy = energy;
            this.mask = mask;
        }
    }

    public int minMoves(String[] classroom, int energy) {

        int r = classroom.length;
        int c = classroom[0].length();

        char[][] grid = new char[r][c];

        // litterId[i][j] = ID of litter at this cell
        // -1 means this cell is not litter
        int[][] litterId = new int[r][c];

        for (int i = 0; i < r; i++) {
            Arrays.fill(litterId[i], -1);
        }

        int startR = -1;
        int startC = -1;
        int litterCount = 0;

        // Build grid and give every L a unique ID
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                grid[i][j] = classroom[i].charAt(j);

                if (grid[i][j] == 'S') {
                    startR = i;
                    startC = j;
                }

                if (grid[i][j] == 'L') {
                    litterId[i][j] = litterCount;
                    litterCount++;
                }
            }
        }

        // No litter -> already done
        if (litterCount == 0) {
            return 0;
        }

        // If there are k litter cells:
        // allMask = 111...111 (k bits)
        int allMask = (1 << litterCount) - 1;

        Queue<Pair> q = new LinkedList<>();

        // Start:
        // step = 0
        // energy = given energy
        // mask = 0 (no litter collected)
        q.offer(new Pair(startR, startC, 0, energy, 0));

        /*
         * visited[r][c][energy][mask]
         *
         * Same cell + same energy + same collected litter
         * ko dobara visit karne ki zarurat nahi.
         */
        boolean[][][][] visited =
                new boolean[r][c][energy + 1][1 << litterCount];

        visited[startR][startC][energy][0] = true;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            for (int d = 0; d < 4; d++) {

                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                // Outside grid
                if (nr < 0 || nc < 0 || nr >= r || nc >= c) {
                    continue;
                }

                // Wall
                if (grid[nr][nc] == 'X') {
                    continue;
                }

                // Every move consumes 1 energy
                int newEnergy = curr.energy - 1;

                // Can't move if no energy
                if (newEnergy < 0) {
                    continue;
                }

                // If R, energy gets restored
                if (grid[nr][nc] == 'R') {
                    newEnergy = energy;
                }

                // Current path's collected litter
                int newMask = curr.mask;

                // If next cell is litter, collect it
                if (grid[nr][nc] == 'L') {

                    int id = litterId[nr][nc];

                    newMask = curr.mask | (1 << id);
                }

                int newStep = curr.step + 1;

                // All litter collected
                if (newMask == allMask) {
                    return newStep;
                }

                // Same state already visited
                if (visited[nr][nc][newEnergy][newMask]) {
                    continue;
                }

                visited[nr][nc][newEnergy][newMask] = true;

                q.offer(new Pair(
                        nr,
                        nc,
                        newStep,
                        newEnergy,
                        newMask
                ));
            }
        }

        // Couldn't collect all litter
        return -1;
    }
}