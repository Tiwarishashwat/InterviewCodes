class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], -1);
        }

        int topRow = 0, bottomRow = m - 1, leftCol = 0, rightCol = n - 1;
        while (head != null) {
            for (int col = leftCol; col <= rightCol; col++) {
                if(head==null) break;
                matrix[topRow][col] = head.val;
                head = head.next;
            }
            topRow++;

        
            for (int row = topRow; row <= bottomRow; row++) {
                if(head==null) break;
                matrix[row][rightCol] = head.val;
                head = head.next;
            }
            rightCol--;

 
            for (int col = rightCol; col >= leftCol ; col--) {
                if(head==null) break;
                matrix[bottomRow][col] = head.val;
                head = head.next;
            }
            bottomRow--;

       
            for (int row = bottomRow; row >= topRow ; row--) {
                if(head==null) break;
                matrix[row][leftCol] = head.val;
                head = head.next;
            }
            leftCol++;
        }

        return matrix;
    }
}
