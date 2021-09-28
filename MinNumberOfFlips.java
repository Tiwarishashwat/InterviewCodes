class Solution {
    public int minFlips(String S) {
        // Code here
        int flips=0;
//         idea is to calculate string flips when the string starts from 1 and then use (length - calculated) to get the flips when the string starts from 0
//         finally return the minimum
        for(int i=0;i<S.length();i++)
        {
//             If there is a 0 at even index then we need to flip it
            if(i%2==0)
            {
                if(S.charAt(i)=='0') flips++;
            }
//             If there is a 1 at odd index then we need to flip it
            else if(i%2!=0)
            {
                if(S.charAt(i)=='1') flips++;
            }
        }
//         minmum flips would either be the flips in making string start with 1 or with 0
        return Math.min(flips,S.length()-flips);
    }
}


// C++ Code
int minFlips (string S)
{
    // your code here
     int flips=0;
        for(int i=0;i<S.length();i++)
        {
            if(i%2==0)
            {
                if(S[i]=='0') flips++;
            }
            
            else if(i%2!=0)
            {
                if(S[i]=='1') flips++;
            }
        }
        if(flips<S.length()-flips)
        return flips;
        else
        return S.length()-flips;
}
