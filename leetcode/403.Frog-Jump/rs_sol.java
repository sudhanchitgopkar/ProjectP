class Solution {
    public boolean canCross(int[] stonesArr) {
        int max = stonesArr[stonesArr.length - 1];
        boolean[][] visited = new boolean[stonesArr.length][stonesArr.length];
        HashMap<Integer, Integer> stones = new HashMap<>();

        for (int i = 0; i < stonesArr.length; i++) {
            stones.put(stonesArr[i], i);
        } // if

        if (stones.get(1) == null) return false;

        return isPossible(0, 1, visited, stones, max);
    } // canCross

    public boolean isPossible(int curr, int next, boolean[][] visited, HashMap<Integer, Integer> stones, int max) {
        if (next == max) return true;

        int currInd = stones.get(curr);
        int nextInd = stones.get(next); 

        if (visited[currInd][nextInd]) return false;

        if (curr == next || next < 0) {
            visited[currInd][nextInd] = true;
            return false;
        } // if

        int k = next - curr;

        if (stones.get(next + k + 1) != null) {
            if (isPossible(next, next + k + 1, visited, stones, max)) return true;
        } // if
        if (stones.get(next + k - 1) != null) {
            if (isPossible(next, next + k - 1, visited, stones, max)) return true;
        } // if
        if (stones.get(next + k) != null) {
            if (isPossible(next, next + k, visited, stones, max)) return true;
        } // if

        visited[currInd][nextInd] = true;

        return false;
    } // isPossible
} // Solution