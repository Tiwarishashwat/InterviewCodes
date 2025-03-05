class Solution {
    public long coloredCells(int n) {
        return 1 + (long) n * (n-1)  * 2;
    }
}
