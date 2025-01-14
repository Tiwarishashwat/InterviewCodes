class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        //find the freq
        int n = A.length;
        int freq[] = new int[n+1];
        int C[] = new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            freq[A[i]]++;
            if(freq[A[i]]==2) count++;

            freq[B[i]]++;
            if(freq[B[i]]==2) count++;

            C[i] = count;
        }
        return C;
    }
}
