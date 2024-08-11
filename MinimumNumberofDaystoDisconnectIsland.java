// find the articulation point, 
// we need to form a graph from all the 1's present in the matrix.
// We need to find if there is an articulation point in the graph of all 1's
// case 1 : no lands present in matrix (return 0)
// case 2 : more than 2 lands present then land is already disconnected (return 0)
// case 3 : only 1 land present, 
    // case 3.1 : if there is only 1 land cell, we can remove it in 1 time, so return 1 
    // case 3.2 : if there is an articulation point, return 1 
    // case 3.3 : if there is no articulation point, then we need to remove 2 nodes, hence return 2
class Solution {
    // Directions for 4 adjacent: up, right, down, left
    int[][] dirs = {{ -1, 0 },{ 0, 1 },{ 1, 0 },{ 0, -1 }};
    int rows;
    int cols;
    static boolean hasArticulationPoint; //tells if graph has an articulation point
    static int time; //global time counter used by DFS
    public int minDays(int[][] grid) {
        rows = grid.length; 
        cols = grid[0].length;
        hasArticulationPoint = false;
        time = 0;
        int landCells = 0, islandCount = 0;

        int[][] discoveryTime = new int[rows][cols]; // Time when a cell is first discovered
        // Lowest discovery time reachable from the subtree rooted at this cell
        int[][] lowestReachable = new int[rows][cols]; 
        // Parent of each cell in DFS tree
        int[][] parentCell = new int[rows][cols]; 

        // Initialize arrays with default values (note -1 means there is no parent)
        for (int i = 0; i < rows; i++) {
            Arrays.fill(discoveryTime[i], -1);
            Arrays.fill(lowestReachable[i], -1);
            Arrays.fill(parentCell[i], -1);
        }

        // Traverse the grid to find islands and articulation points
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) { //1 means a node in graph.
                    landCells++;
                    if (discoveryTime[i][j] == -1) { // If not yet visited
                        // Start DFS for a new island
                        findArticulationPoints(grid,i,j,discoveryTime,lowestReachable,parentCell);
                        islandCount++; //no of dfs calls means number of connected components
                    }
                }
            }
        }

        // Determine the minimum number of days to disconnect the grid
        if (islandCount == 0 || islandCount >= 2) return 0; // Already disconnected or no land
        if (landCells == 1) return 1; // Only one land cell
        if (hasArticulationPoint) return 1; // An articulation point exists
        return 2; // Need to remove any two land cells
    }

    private void findArticulationPoints(int[][] grid,int row,int col,int[][] discoveryTime,int[][] lowestReachable,int[][] parentCell) {
        discoveryTime[row][col] = time; //first node discovery is 0, note than time is global
        time++; //increment time
        lowestReachable[row][col] = discoveryTime[row][col]; //visited for first time so lowest time and discovery will be same.
        //when a node can be articulation point
        // case 1 : if there are more than 1 subtree of a dfs tree rooted at node (row,col) then it is an articulation point.
        // case 2 : if from any of the subtree of a node(row,col), you cannot reach an ancestor of node(row,col) then
        // node(row,col) is an articulation point. 
        int children = 0;
        // dfs calls in 4 directions
        for (int[] direction : dirs) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (!isCellValid(grid, newRow, newCol)) {
                continue;
            }
                if (discoveryTime[newRow][newCol] == -1) { //not visited
                    children++; //increment subtree count
                    parentCell[newRow][newCol] = row * cols + col; // Set parent
                    findArticulationPoints(grid,newRow,newCol,discoveryTime,lowestReachable,parentCell);
                    // Update lowest reachable time
                    lowestReachable[row][col] = Math.min(lowestReachable[row][col],lowestReachable[newRow][newCol]);

                    // Check for articulation point condition
                    if (lowestReachable[newRow][newCol] >= discoveryTime[row][col] && parentCell[row][col] != -1) {
                        hasArticulationPoint = true;
                    }
                } else if (newRow * cols + newCol != parentCell[row][col]) {
                    // Update lowest reachable time for back edge
                    lowestReachable[row][col] = Math.min(lowestReachable[row][col],discoveryTime[newRow][newCol]);
                }
        }

        // Root of DFS tree is an articulation point if it has more than one child
        if (parentCell[row][col] == -1 && children > 1) {
            hasArticulationPoint = true;
        }
    }

    // Check if the given cell is a valid land cell (inside grid and land cell)
    private boolean isCellValid(int[][] grid, int row, int col) {
        return (row >= 0 &&col >= 0 && row < rows && col < cols && grid[row][col] == 1);
    }

    
}
