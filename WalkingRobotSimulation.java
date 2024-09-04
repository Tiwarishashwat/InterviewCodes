class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        //2,2 -> 2,3 -> 2,4 -> 2,5 -> 2,6
        // 0: North, 1: East, 2: South, 3: West
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; //constant
        int[] curPos = { 0, 0 };
        int res = 0;
        int curDir = 0; 
        HashMap<Integer,HashSet<Integer>> obstacleMap = new HashMap<>(); //O(N)
        for (int[] obstacle : obstacles) { //x,y //O(N)
            if(!obstacleMap.containsKey(obstacle[0])){
                obstacleMap.put(obstacle[0],new HashSet<>());
            }
            obstacleMap.get(obstacle[0]).add(obstacle[1]);
        }

        for (int command : commands) { //K
            if (command == -1) {
                // Turn right
                curDir = (curDir + 1) % 4;
                continue;
            }
            if (command == -2) {
                // Turn left
                curDir = (curDir - 1);
                if(curDir==-1){
                    curDir=3;
                }
                continue;
            }

            // Move forward
            int[] direction = directions[curDir];
            for (int step = 0; step < command; step++) { //9
                int nextX = curPos[0] + direction[0];
                int nextY = curPos[1] + direction[1];
                if(obstacleMap.containsKey(nextX) && obstacleMap.get(nextX).contains(nextY)){
                    break;
                }
                curPos[0] = nextX;
                curPos[1] = nextY;
            }

            res = Math.max(res,curPos[0] * curPos[0] +curPos[1] * curPos[1]);
        }
        return res;
    }
}
