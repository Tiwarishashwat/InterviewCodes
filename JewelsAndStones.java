class Solution {
    public int numJewelsInStones(String jewels, String stones) {
// Calculating frequency
        int charFreq[] = new int[256];
        for(int i=0;i<stones.length();i++)
        {
            charFreq[stones.charAt(i)-65]++;
        }
        
//         for storing result
        int count=0;
        
        for(int i=0;i<jewels.length();i++)
        {
            count+=charFreq[jewels.charAt(i)-65];
        }
    return count;
    }
}



    
    

